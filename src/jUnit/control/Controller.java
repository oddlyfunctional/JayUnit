package jUnit.control;

import jUnit.FooTest;
import jUnit.model.PersistentTestResult;
import jUnit.model.PersistentTestResultDAO;
import jUnit.view.FollowTestsPanel;
import jUnit.view.MainFrame;
import jUnit.view.ShowStatisticsPanel;
import java.util.List;

public class Controller {

    private MainFrame mainFrame;
    private static Controller instance;
    private Class lastRunTestCaseClass;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Controller() {
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }

    public void runTests() {
        runTests(lastRunTestCaseClass);
    }

    public void runTests(Class testCaseClass) {
        lastRunTestCaseClass = testCaseClass;
        try {
            mainFrame.setView(new FollowTestsPanel(testCaseClass));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showStatistics() {
        mainFrame.setView(new ShowStatisticsPanel());
    }

    public void insertTestResult(PersistentTestResult testResult) {
        PersistentTestResultDAO.getInstance().insert(testResult);
    }

    public String testsStatistics() {
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
        return String.format("Average\n\n"
                + "Run: %f\n"
                + "Errors: %f\n"
                + "Execution time (in nano secs): %f\n"
                + "Times run: %d",
                runCount / size, errorCount / size, executionTime / size, size);
    }
}
