package jayUnit.tests;

import jayUnit.framework.TestCase;
import jayUnit.framework.TestSuite;
import jayUnit.view.Button;

public class ButtonTest extends TestCase {

    public ButtonTest(String name) {
        super(name);
    }

    public void testDoClick() {
        WasRunCommand wasRun = new WasRunCommand();
        Button button = new Button(wasRun);
        assertFalse(wasRun.wasRun());
        button.doClick();
        assertTrue(wasRun.wasRun());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(TestSuite.runTestSuiteFor(ButtonTest.class).summary());
    }
}
