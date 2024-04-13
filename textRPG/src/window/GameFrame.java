package window;

import game0.player.Inventory;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameFrame extends JFrame {
    private JTextArea textArea;
    private JTextField inputField;
    private GuiInteraction guiInteraction;
    private JPanel buttonPanel;
    private JTextArea inventoryArea;
    private JButton continueButton;

    public GameFrame() {
        setTitle("txt_rpg");
        setSize(1600, 1080);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        initializeComponents();
        setVisible(true);
    }

    private void initializeComponents() {
        setupTextArea();
        setupInputField();
        setupButtonPanel();
        setupInventoryArea();
        setupContinueButton();
        guiInteraction = new GuiInteraction(textArea, this);
        setupKeyBindings();

        add(inputField, BorderLayout.SOUTH);
        buttonPanel.add(continueButton);
        add(buttonPanel, BorderLayout.NORTH);
    }

    private void setupContinueButton() {
        continueButton = new JButton("Continuar");
        continueButton.addActionListener(e -> {
            guiInteraction.continueGame();
            continueButton.setVisible(false);
        });
        continueButton.setVisible(false);
    }

    private void setupTextArea() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.black);
        textArea.setForeground(Color.white);
        textArea.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        textArea.setMargin(new Insets(5, 5, 20, 5));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //esta mierda setea la scrollbar abajo
        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void setupInputField() {
        inputField = new JTextField();
        inputField.addActionListener(e -> {
            String input = inputField.getText().trim();
            if (!input.isEmpty()) {
                guiInteraction.processUserInput(input);
                inputField.setText("");
            }
        });
        inputField.setPreferredSize(new Dimension(Integer.MAX_VALUE, 35));
        add(inputField, BorderLayout.SOUTH);
    }

    private void setupButtonPanel() {
        buttonPanel = new JPanel(new FlowLayout());
        add(buttonPanel, BorderLayout.NORTH);
    }

    private void setupInventoryArea() {
        inventoryArea = new JTextArea(30, 15);
        inventoryArea.setEditable(false);
        JScrollPane inventoryScrollPane = new JScrollPane(inventoryArea);
        inventoryScrollPane.setBorder(BorderFactory.createTitledBorder("Inventario"));
        add(inventoryScrollPane, BorderLayout.EAST);
    }

    private void setupKeyBindings() {
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getRootPane().getActionMap();
        inputMap.put(KeyStroke.getKeyStroke("I"), "openInventory");
        actionMap.put("openInventory", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventoryArea.setText(Inventory.getInventoryDisplay());
            }
        });
    }

    public void showContinueButton(boolean show) {
        SwingUtilities.invokeLater(() -> continueButton.setVisible(show));
    }

    public GuiInteraction getGuiInteraction() {
        return guiInteraction;
    }
}
