/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.view;

import jUnit.Command;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author marcos
 */
public class Button extends JButton implements ActionListener {

    private Command command;

    public Button(Command command) {
        super();
        this.command = command;
        super.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        command.execute();
    }
}
