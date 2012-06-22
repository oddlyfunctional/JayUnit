package jayUnit.tests;

import jayUnit.model.PersistentTestResult;
import jayUnit.framework.TestCase;
import jayUnit.framework.TestResult;
import jayUnit.framework.TestSuite;

public class PersistentTestResultTest extends TestCase {

    private PersistentTestResult persistentResult;

    public PersistentTestResultTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() {
        TestResult result = new TestResult();
        result.testStarted();
        result.testFailed();
        persistentResult = new PersistentTestResult(result, 1L);
    }

    public void testNewFromTestResult() {
        assertEquals(persistentResult.getRunCount(), 1);
        assertEquals(persistentResult.getErrorCount(), 1);
        assertEquals(persistentResult.getExecutionTimeInNanoSecs(), 1L);
    }

    public void testEquals() {
        TestResult result = new TestResult();
        result.testStarted();
        result.testFailed();
        assertEquals(persistentResult, new PersistentTestResult(result, 1L));
    }

    public void testEqualsFailed() {
        TestResult result = new TestResult();
        result.testStarted();
        result.testFailed();
        assertNotEquals(persistentResult, new PersistentTestResult(result, 2L));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(TestSuite.runTestSuiteFor(PersistentTestResultTest.class).summary());
    }
}
