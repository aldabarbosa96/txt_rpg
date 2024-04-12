package window;

import game0.player.Inventory;
import javax.swing.*;
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
        setSize(1280, 720);
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

        // Asegurar que el panel del botón y el campo de entrada están correctamente añadidos y visibles.
        add(inputField, BorderLayout.SOUTH);
        buttonPanel.add(continueButton);  // Asegúrate de que el botón está en el panel de botones.
        add(buttonPanel, BorderLayout.NORTH);
    }

    private void setupContinueButton() {
        continueButton = new JButton("Continuar");
        continueButton.addActionListener(e -> {
            guiInteraction.continueGame(); // Notifica a la interacción para continuar
            continueButton.setVisible(false); // Oculta el botón después de ser utilizado
        });
        continueButton.setVisible(true); // Inicialmente visible o no según el diseño del juego.
    }

    private void setupTextArea() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.black);
        textArea.setForeground(Color.white);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
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
        inputField.setPreferredSize(new Dimension(inputField.getWidth(), 30));
        add(inputField, BorderLayout.SOUTH);
    }

    private void setupButtonPanel() {
        buttonPanel = new JPanel(new FlowLayout());
        add(buttonPanel, BorderLayout.NORTH);
    }

    private void setupInventoryArea() {
        inventoryArea = new JTextArea(10, 30);
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
                inventoryArea.setText(Inventory.getInventoryDisplay()); // Actualiza el área de texto del inventario
            }
        });
    }

    public void showContinueButton(boolean show) {
        SwingUtilities.invokeLater(() -> continueButton.setVisible(show)); // Asegura que el cambio de visibilidad se haga en el EDT
    }

    public GuiInteraction getGuiInteraction() {
        return guiInteraction;
    }
}
