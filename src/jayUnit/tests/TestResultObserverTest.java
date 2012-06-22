package jayUnit.tests;

import jayUnit.framework.ObservableTestResult;
import jayUnit.framework.TestCase;
import jayUnit.framework.TestSuite;
import jayUnit.view.TestResultView;

public class TestResultObserverTest extends TestCase {

    public TestResultObserverTest(String name) {
        super(name);
    }

    public void testUpdate() {
        ObservableTestResult result = new ObservableTestResult();
        TestResultView observer = new TestResultView(result);
        result.attach(observer);
        result.testStarted();
        assertEquals(observer.getText(), result.summary());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(TestSuite.runTestSuiteFor(TestResultObserverTest.class).summary());
    }
}
