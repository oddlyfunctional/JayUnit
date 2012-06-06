/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit;

/**
 *
 * @author marcos
 */
public class PersistentTestDecorator extends TestComponent {
    
    private TestCase testCase;
    
    public PersistentTestDecorator(TestCase testCase) {
        this.testCase = testCase;
    }

    public void run(TestResult result) {
        long timeBefore = System.nanoTime();
        testCase.run(result);
        PersistentTestResultDAO.getInstance().insert(new PersistentTestResult(result, System.nanoTime() - timeBefore));
    }
    
}
