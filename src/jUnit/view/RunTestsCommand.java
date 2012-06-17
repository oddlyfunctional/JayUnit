/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.view;

import jUnit.Command;
import jUnit.ObservableTestResult;
import jUnit.PersistentTestDecorator;
import jUnit.framework.TestSuite;

/**
 *
 * @author marcos
 */
public class RunTestsCommand implements Command {

    private TestResultView testResult;
    private TestSuite suite;

    public RunTestsCommand(TestResultView testResult, TestSuite suite) {
        this.testResult = testResult;
        this.suite = suite;
    }

    public void execute() {
        ObservableTestResult result = new ObservableTestResult();
        testResult.setResult(result);
        new PersistentTestDecorator(suite).run(result);
    }
}
