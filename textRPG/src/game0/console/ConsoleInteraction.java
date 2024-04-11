package game0.console;

import game0.interfaces.UserInteraction;
import java.util.Scanner;

public class ConsoleInteraction implements UserInteraction {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}
