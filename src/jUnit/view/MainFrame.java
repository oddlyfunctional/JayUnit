/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jUnit.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author marcos
 */
public class MainFrame extends JFrame {
    
    private int width;
    private int height;
    private Object layoutConstraint;

    public MainFrame() {
        super("JUnit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        width = 600;
        height = 300;
        centralize();

        setLayout(new BorderLayout());
        layoutConstraint = BorderLayout.CENTER;
    }

    public void setView(JComponent component) {
        getContentPane().removeAll();
        getContentPane().add(component, layoutConstraint);
//        pack();
        repaint();
    }

    private void centralize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - this.width) / 2, (screenSize.height - this.height) / 2, this.width, this.height);
    }

}
