/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit;

import jUnit.framework.TestComponent;
import jUnit.framework.TestResult;
import jUnit.model.PersistentTestResult;
import jUnit.model.PersistentTestResultDAO;

/**
 *
 * @author marcos
 */
public class PersistentTestDecorator extends TestComponent {
    
    private TestComponent testComponent;
    
    public PersistentTestDecorator(TestComponent testComponent) {
        this.testComponent = testComponent;
    }

    public void run(TestResult result) {
        long timeBefore = System.nanoTime();
        testComponent.run(result);
        PersistentTestResultDAO.getInstance().insert(new PersistentTestResult(result, System.nanoTime() - timeBefore));
    }
    
}
