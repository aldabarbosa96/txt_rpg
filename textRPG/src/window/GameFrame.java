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
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        textArea.setBackground(Color.black);
        textArea.setForeground(Color.white);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(scrollPane, BorderLayout.CENTER);


        inputField = new JTextField();
        add(inputField, BorderLayout.SOUTH);
    }
}
