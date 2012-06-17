package jUnit.tests;

import jUnit.framework.TestSuite;
import java.lang.reflect.InvocationTargetException;

public class WasRunSuite extends TestSuite {

    private String log;

    public WasRunSuite(Class testCaseClass) throws InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        super(testCaseClass);
        log = "";
    }

    public String log() {
        return log;
    }

    protected void beforeRun() {
        log += "beforeRun ";
    }

    protected void afterRun() {
        log += "afterRun ";
    }
}
