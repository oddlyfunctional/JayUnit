package jayUnit.tests;

import jayUnit.framework.TestCase;
import jayUnit.framework.TestResult;
import jayUnit.framework.TestSuite;
import jayUnit.errors.Failure;
import jayUnit.errors.SetUpError;
import java.util.ArrayList;
import java.util.List;

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
        assertEquals("1 run, 1 failed\njUnit.tests.WasRun.testBrokenMethodWithoutMessage - java.lang.Exception", result.summary());
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

    public void testSuiteCallbacks() throws Exception {
        WasRunSuite suite = new WasRunSuite(WasRun.class);
        suite.run(result);
        assertEquals(suite.log(), "beforeRun afterRun beforeRun afterRun beforeRun afterRun ");
    }

    public void testRunTestSuiteFor() throws Exception {
        result = TestSuite.runTestSuiteFor(WasRun.class);
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
            assertEquals("Expected <true,Boolean> but it was <false,Boolean>", e.getMessage());
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

    public void testAssertContains() {
        List list = new ArrayList();
        list.add(1);
        assertTrue(assertContains(list, 1));
    }

    public void testAssertDoNotContain() {
        List list = new ArrayList();
        list.add(1);
        assertTrue(assertDoNotContain(list, 2));
    }

    public void testAssertEquals() {
        assertTrue(assertEquals(1, 1));
    }

    public void testAssertEqualsFailed() {
        try {
            assertEquals(1, 2);
            fail();
        } catch (AssertionError e) {
            assertEquals("Expected <2,Integer> but it was <1,Integer>", e.getMessage());
        }
    }

    public void assertNotEquals() {
        assertTrue(assertNotEquals(1, 2));
    }

    public void testAssertNotEqualsFailed() {
        try {
            assertNotEquals(1, 1);
            fail();
        } catch (AssertionError e) {
            assertEquals("Expected not to be <1,Integer> but it was <1,Integer>", e.getMessage());
        }
    }

    public void testAssertArrayEquals() {
        List list1 = new ArrayList();
        list1.add(1);
        List list2 = new ArrayList();
        list2.add(1);
        assertArrayEquals(list1, list2);
    }

    public void testAssertArrayEqualsFailed() {
        List list1 = new ArrayList();
        list1.add(1);
        List list2 = new ArrayList();
        list2.add(2);
        try {
            assertArrayEquals(list1, list2);
            fail();
        } catch (AssertionError e) {
            assertEquals(e.getMessage(), "Expected <[2],ArrayList> but it was <[1],ArrayList>");
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
