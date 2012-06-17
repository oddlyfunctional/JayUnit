/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.tests;

import jUnit.Observer;
import jUnit.framework.TestResult;

/**
 *
 * @author marcos
 */
public class FooObserver implements Observer {
    
    private TestResult result;
    private int runCount = 0;
    private int errorCount = 0;

    public FooObserver(TestResult result) {
        this.result = result;
    }

    public void update() {
        this.runCount = result.getRunCount();
        this.errorCount = result.getErrorCount();
    }

    public int getErrorCount() {
        return errorCount;
    }

    public int getRunCount() {
        return runCount;
    }
    
}
