/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.tests;

import jUnit.Command;

/**
 *
 * @author marcos
 */
public class WasRunCommand implements Command {
    
    private boolean wasRun;

    public WasRunCommand() {
        wasRun = false;
    }

    public boolean wasRun() {
        return wasRun;
    }

    public void execute() {
        wasRun = true;
    }
    
}
