package jUnit.control;

import jUnit.control.commands.GenerateStatisticsCommand;
import jUnit.model.PersistentTestResult;
import jUnit.model.PersistentTestResultDAO;
import jUnit.view.FollowTestsPanel;
import jUnit.view.MainFrame;
import jUnit.view.ShowStatisticsPanel;

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
        GenerateStatisticsCommand statistics = new GenerateStatisticsCommand();
        statistics.execute();
        return statistics.getStatistics();
    }
}
