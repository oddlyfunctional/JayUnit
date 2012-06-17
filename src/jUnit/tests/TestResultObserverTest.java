/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.tests;

import jUnit.ObservableTestResult;
import jUnit.framework.TestCase;
import jUnit.framework.TestSuite;
import jUnit.view.TestResultView;

/**
 *
 * @author marcos
 */
public class TestResultObserverTest extends TestCase {

    public TestResultObserverTest(String name) {
        super(name);
    }
    
    public void testUpdate() {
        ObservableTestResult result = new ObservableTestResult();
        TestResultView observer = new TestResultView(result);
        result.attach(observer);
        result.testStarted();
        assertEquals(observer.getText(), result.summary());
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println(TestSuite.runTestSuiteFor(TestResultObserverTest.class).summary());
    }
    
}
