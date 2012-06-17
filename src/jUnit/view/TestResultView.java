/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.view;

import jUnit.ObservableTestResult;
import jUnit.Observer;
import jUnit.framework.TestResult;

/**
 *
 * @author marcos
 */
public class TestResultView extends javax.swing.JTextArea implements Observer {

    private TestResult result;

    public TestResultView() {
        setText("0 run, 0 failed");
    }

    public TestResultView(TestResult result) {
        this.result = result;
    }

    public void setResult(ObservableTestResult result) {
        this.result = result;
        result.attach(this);
    }

    public void update() {
        setText(result.summary());
    }
    
}
