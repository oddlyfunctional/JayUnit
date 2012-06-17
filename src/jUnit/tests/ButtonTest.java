/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.tests;

import jUnit.Command;
import jUnit.framework.TestCase;
import jUnit.framework.TestSuite;
import jUnit.view.Button;

/**
 *
 * @author marcos
 */
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
