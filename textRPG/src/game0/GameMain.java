package game0;

import java.util.Locale;
import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
        GameLoop.run(sc);
        sc.close();
    }
}
