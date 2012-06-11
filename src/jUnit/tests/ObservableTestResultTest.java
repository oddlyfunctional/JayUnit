/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.tests;

import jUnit.ObservableTestResult;
import jUnit.Observer;
import jUnit.TestCase;
import jUnit.TestResult;
import jUnit.TestSuite;

/**
 *
 * @author marcos
 */
public class ObservableTestResultTest extends TestCase {
    
    private FooObserver observer;
    private ObservableTestResult result;

    public ObservableTestResultTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() {
        try {
            result = new ObservableTestResult();
            observer = new FooObserver(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void testAttachDettachObserver() {
        result.attach(observer);
        assertContains(result.getObservers(), observer);
        
        result.dettach(observer);
        assertDoNotContain(result.getObservers(), observer);
    }
    
    public void testNotifyObserver() throws Exception {
        result.attach(observer);
        new TestSuite(WasRun.class).run(result);
        assertEquals(observer.getRunCount(), 3);
        assertEquals(observer.getErrorCount(), 2);
    }
    
    public static void main(String[] args) throws Exception {
        TestSuite suite = new TestSuite(ObservableTestResultTest.class);
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println(result.summary());
    }
    
}
