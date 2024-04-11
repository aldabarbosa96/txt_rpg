package window;

import javax.swing.*;
import java.awt.*;

public class GameFrame  extends JFrame {
    private JTextArea textArea;
    private JTextField inputField;
    public GameFrame(){
        setTitle("txt_rpg");
        setSize(800,600);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        setLayout(new BorderLayout());
        setVisible(true);

        textArea = new JTextArea();
        textArea.setEditable(false);

        inputField = new JTextField();
        add(inputField, BorderLayout.SOUTH);
    }
}
