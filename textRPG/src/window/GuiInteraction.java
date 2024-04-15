package window;

import game0.interfaces.UserInteraction;
import javax.swing.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class GuiInteraction implements UserInteraction {
    private JTextArea textArea;
    private GameFrame frame;
    private final BlockingQueue<String> inputQueue = new ArrayBlockingQueue<>(1);
    private StringBuilder textBuilder = new StringBuilder();

    public GuiInteraction(JTextArea textArea, GameFrame frame) {
        this.textArea = textArea;
        this.frame = frame;
    }

    @Override
    public void showMessage(String message) {
        textBuilder.append(message).append("\n");
        SwingUtilities.invokeLater(() -> textArea.setText(textBuilder.toString()));
    }

    @Override
    public String getInput() {
        try {
            return inputQueue.take(); //toma el siguiente input
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    public void continueGame() {
        inputQueue.offer("CONTINUE");
    }

    @Override
    public void pauseForUserInput() {
        SwingUtilities.invokeLater(() -> {
            frame.showContinueButton(true);
        });
        try {
            String input = inputQueue.take(); //bloquea hasta que se recibe "CONTINUE".
            while (!"CONTINUE".equals(input)) {
                input = inputQueue.take(); //espera activa hasta que se recibe "CONTINUE".
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            showMessage("La interacción fue interrumpida.");
        }

        SwingUtilities.invokeLater(() -> {
            frame.showContinueButton(false);
        });
    }

    public void processUserInput(String input) {
        inputQueue.offer(input); //añade entrada a la cola
    }
}

