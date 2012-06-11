/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.view;

import jUnit.Command;
import jUnit.ObservableTestResult;
import jUnit.TestSuite;
import javax.swing.JLabel;

/**
 *
 * @author marcos
 */
public class FollowTestsPanel {
    
    private TestSuite suite;
    private TestResultObserver testResult;
    private Button runTests;

    public FollowTestsPanel(Class testCase) throws Exception {
        suite = new TestSuite(testCase);
        testResult = new TestResultObserver();
        testResult.setText("0 run, 0 failed");
        runTests = new Button(new Command() {

            public void execute() {
                ObservableTestResult result = new ObservableTestResult();
                result.attach(testResult);
                testResult.setResult(result);
                suite.run(result);
            }
        });
    }

    public JLabel getTestResult() {
        return testResult;
    }

    public Button getRunTests() {
        return runTests;
    }
}
