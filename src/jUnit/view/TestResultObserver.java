/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.view;

import jUnit.Observer;
import jUnit.TestResult;

/**
 *
 * @author marcos
 */
public class TestResultObserver extends javax.swing.JLabel implements Observer {
    
    private TestResult result;

    public TestResultObserver() {
    }

    public TestResultObserver(TestResult result) {
        this.result = result;
    }

    public void setResult(TestResult result) {
        this.result = result;
    }

    public void update() {
        setText(result.summary());
    }
    
}
