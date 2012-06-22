package jayUnit.view;

import jayUnit.framework.Command;
import jayUnit.control.Controller;
import jayUnit.framework.TestSuite;
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
        runTestsButton.setText("Run tests");
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

    @Override
    public void setEnabled(boolean enabled) {
        runTestsButton.setEnabled(enabled);
        showStatisticsButton.setEnabled(enabled);
    }

    public TestResultView getTestResult() {
        return testResultView;
    }

    public Button getRunTestsButton() {
        return runTestsButton;
    }
}
