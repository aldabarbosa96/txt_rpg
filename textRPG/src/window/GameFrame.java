package window;

import game0.NPCs.Enemy;
import game0.console.ConsolePresentation;
import game0.player.Inventory;
import game0.player.Equipment;
import game0.player.Player;

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
    private JTextArea equipmentArea;
    private JTextArea statsArea;
    private JButton continueButton;
    private JScrollPane textScrollPane;
    private JScrollPane inventoryScrollPane;
    private JScrollPane equipmentScrollPane;
    private JScrollPane statsScrollPane;
    private JPanel sidePanel;
    private JPanel statsPanel;
    private Inventory inventory;
    private Equipment equipment;
    private Player player;
    private Enemy enemy;
    private Timer updateTimer;
    private ConsolePresentation consolePresentation = new ConsolePresentation();

    public GameFrame(Inventory inventory, Equipment equipment, Player player, Enemy enemy) { // todo -> esta clase solamente debería inicializar los componentes (modular clase en un futuro)
        this.inventory = inventory;
        this.equipment = equipment;
        this.player = player;
        this.enemy = enemy;
        setTitle("txt_rpg");
        setSize(1900, 1180);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        initializeComponents();
        startUpdateTimer();

        setFocusable(true);
        setVisible(true);
    }

    private void initializeComponents() {
        setupTextArea();
        setupSidePanel();
        setupStatsPanel();
        setupButtonPanel();
        setupKeyBindings();
        guiInteraction = new GuiInteraction(textArea, this);
    }

    private void startUpdateTimer() {
        updateTimer = new Timer(100, e -> updateUIAreas());  // Actualizar cada 1000 ms = 1 segundo
        updateTimer.start();
    }

    private void updateUIAreas() {
        if (inventoryScrollPane.isVisible()) {
            inventoryArea.setText(inventory.getInventoryDisplay());
        }
        if (equipmentScrollPane.isVisible()) {
            equipmentArea.setText(equipment.toString());
        }
        if (statsScrollPane.isVisible()) {
            statsArea.setText(consolePresentation.displayStats(guiInteraction, player, enemy));
        }
    }

    private void setupTextArea() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(new Color(10, 10, 10));
        textArea.setForeground(new Color(215, 215, 215));
        textArea.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 16));
        textArea.setMargin(new Insets(15, 13, 300, 5));

        textScrollPane = new JScrollPane(textArea);
        textScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        textScrollPane.setBorder(BorderFactory.createEmptyBorder());

        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        add(textScrollPane, BorderLayout.CENTER);
    }

    private void setupButtonPanel() {
        buttonPanel = new JPanel(new BorderLayout());
        setupInputField();
        setupContinueButton();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0));
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
        inputField.setCaretColor(Color.orange);
        inputField.setPreferredSize(new Dimension(Integer.MAX_VALUE, 50));
        inputField.setFont(new Font("Liberation mono", Font.PLAIN, 17));
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
        continueButton.setPreferredSize(new Dimension(245, 50));
        buttonPanel.add(continueButton, BorderLayout.EAST);
    }

    private void setupStatsPanel() {
        statsPanel = new JPanel();
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.PAGE_AXIS));
        statsPanel.setBackground(Color.black);
        setupStatsArea(statsPanel);
        add(statsPanel, BorderLayout.WEST);
    }

    private void setupStatsArea(JPanel parent) {
        statsArea = new JTextArea(8, 8);
        statsArea.setEditable(false);
        statsArea.setBackground(Color.black);
        statsArea.setForeground(new Color(220, 175, 10));
        statsArea.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 16));

        statsScrollPane = new JScrollPane(statsArea);
        statsScrollPane.setPreferredSize(new Dimension(220, 400));
        statsScrollPane.setVisible(false);
        statsScrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
        statsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        statsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        parent.add(statsScrollPane);
    }

    private void setupSidePanel() {
        sidePanel = new JPanel(new GridLayout(2, 1));
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.PAGE_AXIS));
        setupInventoryArea(sidePanel);
        setupEquipmentArea(sidePanel);
        sidePanel.setBackground(Color.black);
        add(sidePanel, BorderLayout.EAST);
    }

    private void setupInventoryArea(JPanel parent) {
        inventoryArea = new JTextArea(15, 15);
        inventoryArea.setEditable(false);
        inventoryArea.setBackground(Color.black);
        inventoryArea.setForeground(new Color(220, 175, 10));
        inventoryArea.setFont(new Font("verdana", Font.BOLD, 16));
        inventoryScrollPane = new JScrollPane(inventoryArea);
        inventoryScrollPane.setVisible(false);
        inventoryScrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
        inventoryScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        inventoryScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        parent.add(inventoryScrollPane);
    }

    private void setupEquipmentArea(JPanel parent) {
        equipmentArea = new JTextArea(15, 15);
        equipmentArea.setEditable(false);
        equipmentArea.setBackground(Color.black);
        equipmentArea.setForeground(new Color(220, 175, 10));
        equipmentArea.setFont(new Font("Verdana", Font.BOLD, 15));
        equipmentScrollPane = new JScrollPane(equipmentArea);
        equipmentScrollPane.setVisible(false);
        equipmentScrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
        equipmentScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        equipmentScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        parent.add(equipmentScrollPane);
    }

    private void setupKeyBindings() {
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getRootPane().getActionMap();

        // Inventario
        inputMap.put(KeyStroke.getKeyStroke("I"), "toggleInventory");
        actionMap.put("toggleInventory", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!inputField.isFocusOwner()) {
                    togglePanelVisibility(inventoryScrollPane);
                }
            }
        });

        // Equipo
        inputMap.put(KeyStroke.getKeyStroke("E"), "toggleEquipment");
        actionMap.put("toggleEquipment", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!inputField.isFocusOwner()) {
                    togglePanelVisibility(equipmentScrollPane);
                }
            }
        });

        // Estadísticas
        inputMap.put(KeyStroke.getKeyStroke("S"), "toggleStats");
        actionMap.put("toggleStats", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!inputField.isFocusOwner()) {
                    togglePanelVisibility(statsScrollPane);
                }
            }
        });
    }

    private void togglePanelVisibility(JScrollPane scrollPane) {
        SwingUtilities.invokeLater(() -> {
            boolean isVisible = scrollPane.isVisible();
            JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();

            if (isVisible) {
                textArea.setText("");
            } else {
                if (scrollPane == inventoryScrollPane) {
                    textArea.setText(inventory.getInventoryDisplay());
                } else if (scrollPane == equipmentScrollPane) {
                    textArea.setText(equipment.toString());
                } else if (scrollPane == statsScrollPane) {
                    textArea.setText(consolePresentation.displayStats(guiInteraction, player, enemy));
                }
            }
            scrollPane.setVisible(!isVisible);
            getContentPane().revalidate();
            getContentPane().repaint();
        });
    }

    public void showContinueButton(boolean show) {
        SwingUtilities.invokeLater(() -> continueButton.setVisible(show));
    }

    public GuiInteraction getGuiInteraction() {
        return guiInteraction;
    }
}
