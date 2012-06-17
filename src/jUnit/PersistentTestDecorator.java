package jUnit;

import jUnit.control.Controller;
import jUnit.framework.TestComponent;
import jUnit.framework.TestResult;
import jUnit.model.PersistentTestResult;

public class PersistentTestDecorator extends TestComponent {
    
    private TestComponent testComponent;
    
    public PersistentTestDecorator(TestComponent testComponent) {
        this.testComponent = testComponent;
    }

    public void run(TestResult result) {
        long timeBefore = System.nanoTime();
        testComponent.run(result);
        Controller.getInstance().insertTestResult(new PersistentTestResult(result, System.nanoTime() - timeBefore));
    }
    
}
