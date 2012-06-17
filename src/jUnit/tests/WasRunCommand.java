package jUnit.tests;

import jUnit.Command;

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
