/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit;

/**
 *
 * @author marcos
 */
public class PersistentTestResult {

    private TestResult result;
    private long executionTimeInNanoSecs;

    public PersistentTestResult(TestResult result, long executionTime) {
        this.result = result;
        this.executionTimeInNanoSecs = executionTime;
    }

    public int getRunCount() {
        return result.getRunCount();
    }

    public int getErrorCount() {
        return result.getErrorCount();
    }
    
    public long getExecutionTimeInNanoSecs() {
        return executionTimeInNanoSecs;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PersistentTestResult) {
            PersistentTestResult persistentResult = (PersistentTestResult) obj;
            return persistentResult.getErrorCount() == this.getErrorCount() &&
                    persistentResult.getRunCount() == this.getRunCount() &&
                    persistentResult.getExecutionTimeInNanoSecs() == this.getExecutionTimeInNanoSecs();
        }
        return false;
    }

    @Override
    public String toString() {
        return "<" + getRunCount() + "," + getErrorCount() + "," + getExecutionTimeInNanoSecs() + ">";
    }
}
