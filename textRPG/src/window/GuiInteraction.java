package window;

import game0.interfaces.UserInteraction;
import game0.multimedia.SoundUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class GuiInteraction implements UserInteraction {
    private JTextArea textArea;
    private GameFrame frame;
    private final BlockingQueue<String> inputQueue = new ArrayBlockingQueue<>(1);
    private Timer typingTimer;
    private Queue<String> messageQueue = new LinkedList<>();
    private boolean isAnimating = false;
    private Timer currentAnimationTimer = null;
    private String currentMessage = "";
    private int currentIndex = 0;

    public GuiInteraction(JTextArea textArea, GameFrame frame) {
        this.textArea = textArea;
        this.frame = frame;
        setupTypingTimer();
    }

    private void setupTypingTimer() {
        typingTimer = new Timer(30, e -> {
            if (!messageQueue.isEmpty() && !isAnimating) {
                startMessageAnimation(messageQueue.poll());
            }
        });
        typingTimer.start();
    }

    public void startMessageAnimation(String message) {
        currentMessage = message;
        currentIndex = 0;
        isAnimating = true;

        boolean isSeparator = message.trim().startsWith("---------------------------------------------------");
        if (isSeparator) {
            SoundUtils.stopTypingSound();
        } else {
            SoundUtils.playTypingSound();
        }

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (currentIndex < currentMessage.length()) {
                    textArea.append(String.valueOf(currentMessage.charAt(currentIndex++)));
                    textArea.setCaretPosition(textArea.getDocument().getLength());
                } else {
                    textArea.append("\n");
                    isAnimating = false;
                    ((Timer) evt.getSource()).stop();
                    currentAnimationTimer = null;
                    SoundUtils.stopTypingSound();
                }
            }
        };
        currentAnimationTimer = new Timer(30, actionListener);
        currentAnimationTimer.start();
    }





    @Override
    public void showMessage(String message) {
        messageQueue.offer(message);
        if (!isAnimating && !messageQueue.isEmpty()) {
            startMessageAnimation(messageQueue.poll());
        }
    }

    private void completeAndStopCurrentMessage() {
        if (currentAnimationTimer != null && currentIndex < currentMessage.length()) {
            textArea.append(currentMessage.substring(currentIndex));
            textArea.append("\n");
            currentIndex = currentMessage.length();
            isAnimating = false;
            currentAnimationTimer.stop();
            SoundUtils.stopTypingSound();
        }
    }

    @Override
    public String getInput() {
        try {
            return inputQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    public void continueGame() {
        completeAndStopCurrentMessage();
        inputQueue.offer("CONTINUE");
    }

    @Override
    public void pauseForUserInput() {
        SwingUtilities.invokeLater(() -> frame.showContinueButton(true));
        try {
            String input;
            do {
                input = inputQueue.take();
            } while (!"CONTINUE".equals(input));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            showMessage("Interacción interrumpida");
        } finally {
            SwingUtilities.invokeLater(() -> frame.showContinueButton(false));
        }
    }

    public void processUserInput(String input) {
        completeAndStopCurrentMessage();
        inputQueue.offer(input);
    }
}
