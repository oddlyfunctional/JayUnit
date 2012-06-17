package jUnit.tests;

import jUnit.framework.TestCase;

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
