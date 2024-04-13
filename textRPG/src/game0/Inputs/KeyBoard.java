package game0.Inputs;

import game0.interfaces.KeyActionHandler;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;

public class KeyBoard implements KeyListener {
    private JComponent component;
    private KeyActionHandler handler;

    public KeyBoard(JComponent component, KeyActionHandler handler) {
        this.component = component;
        this.handler = handler;
        this.component.setFocusable(true);
        this.component.requestFocusInWindow();
        this.component.addKeyListener(this);
    }


    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_I:
                handler.onToggleInventory();
                break;
            //agregar más teclas y acciones
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
