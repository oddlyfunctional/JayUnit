package jUnit.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestSuite extends TestComponent {

    private List<TestComponent> tests;

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

    public void add(TestComponent testComponent) {
        tests.add(testComponent);
    }

    public void run(TestResult result) {
        for (TestComponent test : tests) {
            beforeRun();
            test.run(result);
            afterRun();
        }
    }

    protected void beforeRun() {
    }

    protected void afterRun() {
    }

    public static TestResult runTestSuiteFor(Class testCaseClass) throws IllegalArgumentException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        TestSuite suite = new TestSuite(testCaseClass);
        TestResult result = new TestResult();
        suite.run(result);
        return result;
    }
}
