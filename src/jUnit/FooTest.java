/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jUnit;

import jUnit.framework.TestCase;
import java.util.Random;

/**
 *
 * @author marcos
 */
public class FooTest extends TestCase {

    private final int MAX_RUN_TIME = 100;

    public FooTest(String name) {
        super(name);
    }

    public void testFoo1() throws InterruptedException {
        Thread.sleep(generateRandomNumber());
        assertTrue(generateRandomNumber() <= 30);
    }

    public void testFoo2() throws InterruptedException {
        Thread.sleep(generateRandomNumber());
        assertTrue(generateRandomNumber() <= 50);
    }

    private int generateRandomNumber() {
        return new Random().nextInt(MAX_RUN_TIME);
    }

}