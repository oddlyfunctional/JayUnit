package jUnit.view;

import jUnit.Command;
import jUnit.control.Controller;
import jUnit.framework.TestSuite;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class FollowTestsPanel extends JPanel {

    private TestSuite suite;
    private TestResultView testResultView;
    private Button runTestsButton;
    private Button showStatisticsButton;

    public FollowTestsPanel(Class testCase) throws Exception {
        super();
        suite = new TestSuite(testCase);
        testResultView = new TestResultView();
        runTestsButton = new Button(new RunTestsCommand(testResultView, suite));
        runTestsButton.setText("Executar testes");
        showStatisticsButton = new Button(new Command() {

            public void execute() {
                Controller.getInstance().showStatistics();
            }
        });
        showStatisticsButton.setText("Show Statistics");

        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());
        add(testResultView, BorderLayout.CENTER);
        add(runTestsButton, BorderLayout.SOUTH);
        add(showStatisticsButton, BorderLayout.NORTH);
    }

    public TestResultView getTestResult() {
        return testResultView;
    }

    public Button getRunTestsButton() {
        return runTestsButton;
    }
}
