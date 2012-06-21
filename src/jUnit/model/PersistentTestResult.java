package jUnit.model;

import jUnit.framework.TestResult;

public class PersistentTestResult {

    private int runCount;
    private int errorCount;
    private long executionTimeInNanoSecs;

    public PersistentTestResult(TestResult result, long executionTime) {
        this.runCount = result.getRunCount();
        this.errorCount = result.getErrorCount();
        this.executionTimeInNanoSecs = executionTime;
    }

    public int getRunCount() {
        return runCount;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public long getExecutionTimeInNanoSecs() {
        return executionTimeInNanoSecs;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public String toString() {
        return "<" + getRunCount() + "," + getErrorCount() + "," + getExecutionTimeInNanoSecs() + ">";
    }
}
