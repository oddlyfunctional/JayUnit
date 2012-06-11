/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.tests;

import jUnit.ObservableTestResult;
import jUnit.TestCase;
import jUnit.TestSuite;
import jUnit.view.TestResultObserver;

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
        TestResultObserver observer = new TestResultObserver(result);
        result.attach(observer);
        result.testStarted();
        assertEquals(observer.getText(), result.summary());
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println(TestSuite.runTestSuiteFor(TestResultObserverTest.class).summary());
    }
    
}
