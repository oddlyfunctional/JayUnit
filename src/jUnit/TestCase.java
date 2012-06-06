/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit;

import java.lang.reflect.Method;
import java.util.List;

/**
 *
 * @author agir
 */
public class TestCase extends TestComponent {

    protected String name;
    
    public TestCase(String name) {
        this.name = name;
    }

    protected void setUp() {
    }

    protected void tearDown() {
    }

    public void run(TestResult result) {
        result.testStarted();
        try {
            this.setUp();
        } catch (Throwable t) {
            throw new SetUpError(t);
        }
        try {
            Method method = this.getClass().getMethod(name);
            method.invoke(this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            if (e.getCause().getMessage() == null) {
                result.addErrorCause(this.getClass().getName() + "." + this.name + " - " + e.getCause().getClass().getName());
            } else {
                result.addErrorCause(this.getClass().getName() + "." + this.name + " - " + e.getCause().getMessage());
            }
            result.testFailed();
        }
        this.tearDown();
    }

    public void fail() {
        fail(null);
    }

    public void fail(String message) {
        throw new Failure(message);
    }

    public boolean assertTrue(Boolean condition) {
        if (!condition) {
            throw new AssertionError(equalityErrorMessage(true, condition));
        }
        return true;
    }

    public boolean assertFalse(Boolean condition) {
        if (condition) {
            throw new AssertionError(equalityErrorMessage(false, condition));
        }
        return true;
    }

    public boolean assertEquals(Object actualValue, Object expectation) {
        if (!actualValue.equals(expectation)) {
            throw new AssertionError(equalityErrorMessage(expectation, actualValue));
        }
        return true;
    }
    
    public boolean assertNotEquals(Object actualValue, Object expectation) {
        if (actualValue.equals(expectation)) {
            throw new AssertionError("Expected not to be <" + expectation + "," + expectation.getClass().getSimpleName() + "> but it was <" + actualValue + "," + expectation.getClass().getSimpleName() + ">");
        }
        return true;
    }
    
    public boolean assertContains(List list, Object target) {
        if (!list.contains(target)) {
            throw new AssertionError("Expected <" + list + "," + list.getClass().getSimpleName() + "> to contain <" + target + "," + target.getClass().getSimpleName() + ">");
        }
        return true;
    }
    
    public boolean assertDoNotContain(List list, Object target) {
        if (list.contains(target)) {
            throw new AssertionError("Expected <" + list + "," + list.getClass().getSimpleName() + "> not to contain <" + target + "," + target.getClass().getSimpleName() + ">");
        }
        return true;
    }
    
    public boolean assertArrayEquals(List actualValue, List expectation) {
        AssertionError error = new AssertionError(equalityErrorMessage(expectation, actualValue));
        if (actualValue.size() != expectation.size()) {
            throw error;
        }
        for(int i = 0; i < expectation.size(); i++) {
            if (!expectation.get(i).equals(actualValue.get(i))) {
                throw error;
            }
        }
        return true;
    }
    
    private String equalityErrorMessage(Object expectation, Object actualValue) {
        return "Expected <" + expectation + "," + expectation.getClass().getSimpleName() + "> but it was <" + actualValue + "," + expectation.getClass().getSimpleName() + ">";
    }
}
