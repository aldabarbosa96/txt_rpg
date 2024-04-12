package window;

import game0.interfaces.UserInteraction;
import javax.swing.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class GuiInteraction implements UserInteraction {
    private JTextArea textArea;
    private GameFrame frame;
    private final BlockingQueue<String> inputQueue = new ArrayBlockingQueue<>(1);

    public GuiInteraction(JTextArea textArea, GameFrame frame) {
        this.textArea = textArea;
        this.frame = frame;
    }

    @Override
    public void showMessage(String message) {
        SwingUtilities.invokeLater(() -> textArea.append(message + "\n"));
    }

    @Override
    public String getInput() {
        try {
            return inputQueue.take(); // Espera y toma el siguiente input
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    public void continueGame() {
        inputQueue.offer("CONTINUE"); // Envía un comando especial o un marcador.
    }

    @Override
    public void pauseForUserInput() {
        SwingUtilities.invokeLater(() -> {
            frame.showContinueButton(true);
        });
        try {
            String input = inputQueue.take(); // Bloquea hasta que se reciba "CONTINUE".
            while (!"CONTINUE".equals(input)) {
                input = inputQueue.take(); // Espera activa hasta que se reciba "CONTINUE".
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            showMessage("La interacción fue interrumpida.");
        }

        SwingUtilities.invokeLater(() -> {
            frame.showContinueButton(false); // Oculta el botón 'Continuar' después de ser utilizado.
        });
    }

    public void processUserInput(String input) {
        inputQueue.offer(input); // Añade la entrada al queue para su procesamiento posterior.
    }


}