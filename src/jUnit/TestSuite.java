/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *
 * @author marcos
 */
public class TestSuite implements TestComponent {
    
    private ArrayList<TestComponent> tests;

    public TestSuite() {
        tests = new ArrayList<TestComponent>();
    }

    public TestSuite(Class testCaseClass) throws InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        this();
        for (Method method : testCaseClass.getMethods()) {
            String methodName = method.getName();
            if (methodName.startsWith("test")) {
                tests.add((TestComponent) testCaseClass.getConstructor(String.class).newInstance(methodName));
            }
        }
    }
    
    public void add(TestCase testCase) {
        tests.add(testCase);
    }

    public void run(TestResult result) {
        for (TestComponent test : tests) {
            test.run(result);
        }
    }
    
}
