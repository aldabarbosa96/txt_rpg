package window;

import javax.swing.*;
import java.awt.*;

public class GameFrame  extends JFrame {    //se implementará una GUI en un futuro
    private JTextArea textArea;
    private JTextField inputField;
    public GameFrame(){
        setTitle("txt_rpg");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);

        inputField = new JTextField();
        add(inputField, BorderLayout.SOUTH);

        pack();
    }
}
