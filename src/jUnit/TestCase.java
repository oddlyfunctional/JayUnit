/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit;

import java.lang.reflect.Method;

/**
 *
 * @author agir
 */
public class TestCase implements TestComponent {

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

    public boolean assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Expected to be true");
        }
        return true;
    }

    public boolean assertFalse(boolean condition) {
        if (condition) {
            throw new AssertionError("Expected to be false");
        }
        return true;
    }

    public boolean assertEquals(Object obj1, Object obj2) {
        if (!obj1.equals(obj2)) {
            throw new AssertionError("Expected " + obj1 + " but it was " + obj2);
        }
        return true;
    }
}
