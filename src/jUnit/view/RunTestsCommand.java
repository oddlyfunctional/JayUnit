package jUnit.view;

import jUnit.control.commands.Command;
import jUnit.ObservableTestResult;
import jUnit.PersistentTestDecorator;
import jUnit.framework.TestSuite;

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
