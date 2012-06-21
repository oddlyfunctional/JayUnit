/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.control.commands;

import jUnit.model.PersistentTestResult;
import jUnit.model.PersistentTestResultDAO;
import java.util.List;

/**
 *
 * @author marcos
 */
public class GenerateStatisticsCommand implements Command {

    private String statistics;

    public void execute() {
        List<PersistentTestResult> results = PersistentTestResultDAO.getInstance().findAll();
        float runCount = 0;
        float errorCount = 0;
        double executionTime = 0;
        for (PersistentTestResult result : results) {
            runCount += result.getRunCount();
            errorCount += result.getErrorCount();
            executionTime += result.getExecutionTimeInNanoSecs();
        }
        int size = results.size();
        statistics = String.format("Average\n\n"
                + "Run: %f\n"
                + "Errors: %f\n"
                + "Execution time (in nano secs): %f\n"
                + "Times run: %d",
                runCount / size, errorCount / size, executionTime / size, size);
    }

    public String getStatistics() {
        return statistics;
    }
}
