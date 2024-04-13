package window;

import game0.interfaces.KeyActionHandler;
import game0.player.Inventory;
import game0.player.Equipment;
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
    private JTextArea equipmentArea;
    private JButton continueButton;
    private JScrollPane textScrollPane;
    private JScrollPane inventoryScrollPane;
    private JScrollPane equipmentScrollPane;
    private JPanel sidePanel; //panel que contiene ambos
    private Inventory inventory;
    private Equipment equipment;

    public GameFrame(Inventory inventory,Equipment equipment) {
        this.inventory = inventory;
        this.equipment = equipment;
        setTitle("txt_rpg");
        setSize(1600, 1080);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        initializeComponents();

        setFocusable(true);
        setVisible(true);
    }
    private void initializeComponents() {
        setupTextArea();
        setupSidePanel(); // Método nuevo para configurar el panel lateral
        setupButtonPanel();
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
    private void setupButtonPanel() {
        buttonPanel = new JPanel(new BorderLayout());
        setupInputField();
        setupContinueButton();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        buttonPanel.setBackground(Color.black);
        add(buttonPanel, BorderLayout.SOUTH);
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
        inputField.setBackground(Color.black);
        inputField.setForeground(Color.orange);
        inputField.setPreferredSize(new Dimension(Integer.MAX_VALUE, 40));
        inputField.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        buttonPanel.add(inputField, BorderLayout.CENTER);
    }
    private void setupContinueButton() {
        continueButton = new JButton("CONTINUAR");
        continueButton.addActionListener(e -> {
            guiInteraction.continueGame();
            continueButton.setVisible(false);
        });
        continueButton.setVisible(false);
        continueButton.setBackground(Color.black);
        continueButton.setForeground(Color.orange);
        continueButton.setPreferredSize(new Dimension(245, 40));
        buttonPanel.add(continueButton, BorderLayout.EAST);
    }
    private void setupSidePanel() {
        sidePanel = new JPanel(new GridLayout(2, 1));
        setupInventoryArea(sidePanel);
        setupEquipmentArea(sidePanel);
        sidePanel.setBackground(Color.black);
        sidePanel.setVisible(true);
        add(sidePanel, BorderLayout.EAST);
    }
    private void setupInventoryArea(JPanel parent) {
        inventoryArea = new JTextArea(15, 15);
        inventoryArea.setEditable(false);
        inventoryArea.setBackground(Color.black);
        inventoryArea.setForeground(Color.orange);
        inventoryArea.setFont(new Font("Verdana", Font.BOLD, 16));
        inventoryScrollPane = new JScrollPane(inventoryArea);
        inventoryScrollPane.setVisible(false);
        inventoryScrollPane.setBorder(BorderFactory.createEtchedBorder(Color.black,Color.orange));
        inventoryScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        parent.add(inventoryScrollPane);
    }
    private void setupEquipmentArea(JPanel parent) {
        equipmentArea = new JTextArea(15, 15);
        equipmentArea.setEditable(false);
        equipmentArea.setBackground(Color.black);
        equipmentArea.setForeground(Color.orange);
        equipmentArea.setFont(new Font("Verdana", Font.BOLD, 16));
        equipmentScrollPane = new JScrollPane(equipmentArea);
        equipmentScrollPane.setVisible(false);
        equipmentScrollPane.setBorder(BorderFactory.createTitledBorder("Equipo"));
        equipmentScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        parent.add(equipmentScrollPane);
    }
    private void setupKeyBindings() {
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getRootPane().getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("I"), "toggleInventory");
        actionMap.put("toggleInventory", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!inputField.isFocusOwner()) {
                    togglePanelVisibility(inventoryScrollPane, true);
                }
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("E"), "toggleEquipment");
        actionMap.put("toggleEquipment", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!inputField.isFocusOwner()) {
                    togglePanelVisibility(equipmentScrollPane, false);
                }
            }
        });
    }
    private void toggleInventoryVisibility() {
        SwingUtilities.invokeLater(() -> {
            boolean isVisible = inventoryScrollPane.isVisible();
            inventoryScrollPane.setVisible(!isVisible);
            if (!isVisible) {
                inventoryArea.setText(inventory.getInventoryDisplay());
            }
            getContentPane().revalidate();
            getContentPane().repaint();
        });
    }
    @Override
    public void onToggleInventory() {
        toggleInventoryVisibility();
    }

    private void togglePanelVisibility(JScrollPane scrollPane, boolean isInventory) {
        SwingUtilities.invokeLater(() -> {
            boolean isVisible = scrollPane.isVisible();
            scrollPane.setVisible(!isVisible);
            JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();
            if (isVisible) {
                textArea.setText("");
            } else {
                textArea.setText(isInventory ? inventory.getInventoryDisplay() : equipment.toString());
            }
            getContentPane().revalidate();
            getContentPane().repaint();
        });
    }
    public void updateEquipmentDisplay() {
        SwingUtilities.invokeLater(() -> {
            if (equipmentArea != null && equipment != null) {
                equipmentArea.setText(equipment.toString());
                equipmentArea.revalidate();
                equipmentArea.repaint();
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
