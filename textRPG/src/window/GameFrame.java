package window;

import game0.Inputs.KeyBoard;
import game0.interfaces.KeyActionHandler;
import game0.player.Inventory;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameFrame extends JFrame implements KeyActionHandler {
    private JTextArea textArea;
    private JTextField inputField;
    private GuiInteraction guiInteraction;
    private JPanel buttonPanel;
    private JTextArea inventoryArea;
    private JButton continueButton;
    private JScrollPane textScrollPane; // Cambiado el nombre para clarificar su uso
    private JScrollPane inventoryScrollPane;

    public GameFrame() {
        setTitle("txt_rpg");
        setSize(1600, 1080);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        initializeComponents();

        setFocusable(true);
        setVisible(true);
    }

    private void initializeComponents() {
        setupTextArea();
        setupInputField();
        setupButtonPanel();
        setupInventoryArea();
        setupContinueButton();
        setupKeyBindings();
        guiInteraction = new GuiInteraction(textArea, this);
    }

    private void setupTextArea() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.black);
        textArea.setForeground(Color.orange);
        textArea.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        textArea.setMargin(new Insets(15, 12, 300, 5));

        textScrollPane = new JScrollPane(textArea);
        textScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        add(textScrollPane, BorderLayout.CENTER);
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
        inputField.setPreferredSize(new Dimension(Integer.MAX_VALUE, 40));
        add(inputField, BorderLayout.SOUTH);
    }

    private void setupButtonPanel() {
        buttonPanel = new JPanel(new FlowLayout());
        add(buttonPanel, BorderLayout.NORTH);
    }

    private void setupContinueButton() {
        continueButton = new JButton("CONTINUAR");
        continueButton.addActionListener(e -> {
            guiInteraction.continueGame();
            continueButton.setVisible(false);
        });
        continueButton.setVisible(false);
        buttonPanel.add(continueButton);
    }

    private void setupInventoryArea() {
        inventoryArea = new JTextArea(30, 15);
        inventoryArea.setEditable(false);
        inventoryArea.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        inventoryScrollPane = new JScrollPane(inventoryArea);
        inventoryScrollPane.setBorder(BorderFactory.createTitledBorder("Inventario"));
        inventoryScrollPane.setVisible(false);
        add(inventoryScrollPane, BorderLayout.EAST);
    }

    private void setupKeyBindings() {
        JRootPane rootPane = getRootPane();
        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = rootPane.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("I"), "toggleInventory");
        actionMap.put("toggleInventory", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleInventoryVisibility();
            }
        });
    }

    private void toggleInventoryVisibility() {
        SwingUtilities.invokeLater(() -> {
            boolean isVisible = inventoryScrollPane.isVisible();
            inventoryScrollPane.setVisible(!isVisible);
            if (!isVisible) {
                inventoryArea.setText(Inventory.getInventoryDisplay());
            }
        });
    }

    @Override
    public void onToggleInventory() {
        toggleInventoryVisibility();
    }

    public void showContinueButton(boolean show) {
        SwingUtilities.invokeLater(() -> continueButton.setVisible(show));
    }

    public GuiInteraction getGuiInteraction() {
        return guiInteraction;
    }
}
