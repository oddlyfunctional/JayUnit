/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.tests;

import jUnit.SetUpError;
import jUnit.TestCase;
import jUnit.TestResult;
import jUnit.TestSuite;

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
        assert test.log().equals("setUp testMethod tearDown");
    }

    public void testResult() {
        WasRun test = new WasRun("testMethod");
        test.run(result);
        assert "1 run, 0 failed".equals(result.summary());
    }

    public void testFailedResult() {
        WasRun test = new WasRun("testBrokenMethod");
        test.run(result);
        assert "1 run, 1 failed\njUnit.tests.WasRun.testBrokenMethod - java.lang.Exception".equals(result.summary());
    }

    public void testFailedResultFormatting() {
        assert result.summary().equals("0 run, 0 failed");
        result.testStarted();
        result.testFailed();
        assert result.summary().equals("1 run, 1 failed");
    }

    public void testErrorOnSetUp() {
        WasRun test = new WasRun("testMethod") {

            protected void setUp() {
                throw new Error();
            }
        };

        try {
            test.run(result);
        } catch (SetUpError e) {
        }
    }

    public void testSuite() {
        TestSuite suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
        suite.run(result);
        assert "2 run, 1 failed\njUnit.tests.WasRun.testBrokenMethod - java.lang.Exception".equals(result.summary());
    }
    
    public void testAutoSuite() throws Exception {
        TestSuite suite = new TestSuite(WasRun.class);
        suite.run(result);
        assert "2 run, 1 failed\njUnit.tests.WasRun.testBrokenMethod - java.lang.Exception".equals(result.summary());
    }

    public static void main(String[] args) throws Exception {
        TestSuite suite = new TestSuite(TestCaseTest.class);
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println(result.summary());
    }
}
