package jayUnit.tests;

import jayUnit.framework.Observer;
import jayUnit.framework.TestResult;

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
