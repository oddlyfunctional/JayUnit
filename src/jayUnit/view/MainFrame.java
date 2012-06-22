package jayUnit.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

    private Object layoutConstraint;

    public MainFrame() {
        super("JUnit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 200);
        centralize();
        setLayout(new BorderLayout());
        layoutConstraint = BorderLayout.CENTER;
    }

    public void setView(JComponent component) {
        getContentPane().removeAll();
        getContentPane().add(component, layoutConstraint);
        validate();
        repaint();
    }

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        for(Component c : getContentPane().getComponents()) {
            c.setEnabled(b);
        }
    }

    private void centralize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2, getWidth(), getHeight());
    }
}
