package jayUnit.framework;

import java.util.ArrayList;
import java.util.List;

public class TestResult {

    private int runCount;
    private int errorCount;
    private List<String> errorCauses;

    public TestResult() {
        this.runCount = 0;
        this.errorCount = 0;
        this.errorCauses = new ArrayList<String>();
    }

    public void testStarted() {
        runCount += 1;
    }

    public void testFailed() {
        errorCount += 1;
    }

    public void addErrorCause(String message) {
        errorCauses.add(message);
    }

    public String summary() {
        String summary = String.format("%d run, %d failed", runCount, errorCount);
        for (String message : errorCauses) {
            summary += "\n" + message;
        }
        return summary;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public int getRunCount() {
        return runCount;
    }
}
