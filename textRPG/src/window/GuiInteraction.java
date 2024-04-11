package window;

import game0.interfaces.UserInteraction;
import javax.swing.JTextArea;

public class GuiInteraction implements UserInteraction {
    private JTextArea textArea;

    public GuiInteraction(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void showMessage(String message) {
        textArea.append(message + "\n");
    }

    @Override
    public String getInput() {
        //será implementada más tarde para entrada a través de GUI
        return "";
    }

    @Override
    public void pauseForUserInput() {
    }
}

