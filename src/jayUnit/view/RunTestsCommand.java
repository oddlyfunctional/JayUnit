package jayUnit.view;

import jayUnit.framework.Command;
import jayUnit.framework.ObservableTestResult;
import jayUnit.framework.PersistentTestDecorator;
import jayUnit.framework.TestSuite;

public class RunTestsCommand implements Command {

    private TestResultView testResult;
    private TestSuite suite;

    public RunTestsCommand(TestResultView testResult, TestSuite suite) {
        this.testResult = testResult;
        this.suite = suite;
    }

    public void execute() {
        final ObservableTestResult result = new ObservableTestResult();
        testResult.setResult(result);
        testResult.getParent().setEnabled(false);
        new Thread() {

            @Override
            public void run() {
                new PersistentTestDecorator(suite).run(result);
                testResult.getParent().setEnabled(true);
            }
        }.start();
    }
}
