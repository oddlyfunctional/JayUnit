/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.view;

import jUnit.Command;
import javax.swing.JLabel;

/**
 *
 * @author marcos
 */
public class Button extends JLabel {
    
    private Command command;

    public Button(Command command) {
        this.command = command;
    }
    
    public void doClick() {
        command.execute();
    }
    
}
