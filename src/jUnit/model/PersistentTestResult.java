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

    /*
     * TODO: Modificar para que a condição de igualdade não seja dependente de seus atributos,
     * pois mais de um TestResult pode ter tido os mesmos resultados.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PersistentTestResult) {
            PersistentTestResult persistentResult = (PersistentTestResult) obj;
            return persistentResult.getErrorCount() == this.getErrorCount()
                    && persistentResult.getRunCount() == this.getRunCount()
                    && persistentResult.getExecutionTimeInNanoSecs() == this.getExecutionTimeInNanoSecs();
        }
        return false;
    }

    @Override
    public String toString() {
        return "<" + getRunCount() + "," + getErrorCount() + "," + getExecutionTimeInNanoSecs() + ">";
    }
}
