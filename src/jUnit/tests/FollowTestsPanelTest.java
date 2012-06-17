/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.tests;

import jUnit.framework.TestCase;
import jUnit.framework.TestSuite;
import jUnit.view.FollowTestsPanel;

/**
 *
 * @author marcos
 */
public class FollowTestsPanelTest extends TestCase {

    public FollowTestsPanelTest(String name) {
        super(name);
    }

    public void testRunTestsButton() throws Exception {
        FollowTestsPanel panel = new FollowTestsPanel(WasRun.class);
        assertEquals(panel.getTestResult().getText(), "0 run, 0 failed");
        panel.getRunTestsButton().doClick();
        assertEquals(panel.getTestResult().getText(), "3 run, 2 failed\n"
                + "jUnit.tests.WasRun.testBrokenMethod - Message\n"
                + "jUnit.tests.WasRun.testBrokenMethodWithoutMessage - java.lang.Exception");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(TestSuite.runTestSuiteFor(FollowTestsPanelTest.class).summary());
    }
}
