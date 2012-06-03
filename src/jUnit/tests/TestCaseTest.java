/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.tests;

import jUnit.*;

/**
 *
 * @author marcos
 */
public class TestCaseTest extends TestCase {

    private TestResult result;

    public TestCaseTest(String name) {
        super(name);
        result = new TestResult();
    }

    public void testTemplateMethod() {
        WasRun test = new WasRun("testMethod");
        test.run(result);
        assertEquals("setUp testMethod tearDown", test.log());
    }

    public void testResult() {
        WasRun test = new WasRun("testMethod");
        test.run(result);
        assertEquals("1 run, 0 failed", result.summary());
    }

    public void testFailedResult() {
        WasRun test = new WasRun("testBrokenMethod");
        test.run(result);
        assertEquals("1 run, 1 failed\njUnit.tests.WasRun.testBrokenMethod - Message", result.summary());
    }

    public void testFailedWithoutMessageResult() {
        WasRun test = new WasRun("testBrokenMethodWithoutMessage");
        test.run(result);
        assertEquals("1 run, 1 failed\njUnit.tests.WasRun.testBrokenMethodWithoutMessage - java.lang.Exception",result.summary());
    }

    public void testFailedResultFormatting() {
        assert result.summary().equals("0 run, 0 failed");
        result.testStarted();
        result.testFailed();
        assertEquals("1 run, 1 failed", result.summary());
    }

    public void testErrorOnSetUp() {
        WasRun test = new WasRun("testMethod") {

            protected void setUp() {
                throw new Error();
            }
        };

        try {
            test.run(result);
            fail();
        } catch (SetUpError e) {
        }
    }

    public void testSuite() {
        TestSuite suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
        suite.run(result);
        assertEquals("2 run, 1 failed\njUnit.tests.WasRun.testBrokenMethod - Message", result.summary());
    }

    public void testAutoSuite() throws Exception {
        TestSuite suite = new TestSuite(WasRun.class);
        suite.run(result);
        assertEquals("3 run, 2 failed\n"
                + "jUnit.tests.WasRun.testBrokenMethod - Message\n"
                + "jUnit.tests.WasRun.testBrokenMethodWithoutMessage - java.lang.Exception", result.summary());
    }

    public void testAssertTrue() {
        assert assertTrue(true);
    }

    public void testAssertTrueFailed() {
        try {
            assertTrue(false);
            fail();
        } catch (AssertionError e) {
            assertTrue(e.getMessage().equals("Expected to be true"));
        }
    }

    public void testAssertFalse() {
        assert assertFalse(false);
    }

    public void testAssertFalseFailed() {
        try {
            assertFalse(true);
            fail();
        } catch (AssertionError e) {
        }
    }

    public void testAssertEquals() {
        assertTrue(assertEquals(1, 1));
    }

    public void testAssertEqualsFailed() {
        try {
            assertEquals(1, 2);
            fail();
        } catch (AssertionError e) {
            assertTrue(e.getMessage().equals("Expected 1 but it was 2"));
        }
    }

    public void testFail() throws Exception {
        try {
            fail();
            throw new Exception();
        } catch (Failure e) {
        }
    }

    public void testFailMessage() throws Exception {
        try {
            fail("Message");
            throw new Exception();
        } catch (Failure e) {
        }
    }

    public static void main(String[] args) throws Exception {
        TestSuite suite = new TestSuite(TestCaseTest.class);
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println(result.summary());
    }
}
