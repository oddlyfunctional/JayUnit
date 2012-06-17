/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.tests;

import jUnit.framework.TestCase;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agir
 */
public class WasRun extends TestCase {

    private String log;

    public WasRun(String name) {
        super(name);
    }

    @Override
    protected void setUp() {
        this.log = "setUp ";
    }

    public void testMethod() {
        this.log += "testMethod ";
    }
    
    public void testBrokenMethod() throws Exception {
        throw new Exception("Message");
    }
    
    public void testBrokenMethodWithoutMessage() throws Exception {
        throw new Exception();
    }

    @Override
    protected void tearDown() {
        this.log += "tearDown";
    }

    public String log() {
        return log;
    }
}
