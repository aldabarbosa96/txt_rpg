package game0;

import window.GameFrame;

import javax.swing.*;
import java.util.Locale;
import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
        /*SwingUtilities.invokeLater(() -> {
            GameFrame frame = new GameFrame();
            frame.setVisible(true);
        });*///todo --> esto implementa una GUI básica que extenderemos e implementaremos en un futuro
        GameLoop.run(sc);
        sc.close();
    }
}
