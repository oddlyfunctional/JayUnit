/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jUnit;

import java.lang.reflect.InvocationTargetException;
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
    
    protected void setUp() {}
    protected void tearDown() {}

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
            result.addErrorCause(this.getClass().getName() + "." + this.name + " - " + e.getCause().getClass().getName());
            result.testFailed();
        }
        this.tearDown();
    }
}
