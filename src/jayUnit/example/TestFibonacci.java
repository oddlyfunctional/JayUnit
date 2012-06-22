package jayUnit.example;

import jayUnit.framework.TestCase;

public class TestFibonacci extends TestCase {

    Fibonacci f;

    public TestFibonacci(String name) {
        super(name);
    }

    public void setUp() {
        f = new Fibonacci();
    }

    public void testFib0() {
        assertEquals(f.compute(0), 0);
    }

    public void testFib1() {
        assertEquals(f.compute(1), 1);
    }

    public void testFib2() {
        assertEquals(f.compute(2), 1);
    }

    public void testFib3() {
        assertEquals(f.compute(3), 2);
    }

    public void testFib4() {
        assertEquals(f.compute(4), 3);
    }

    public void testFib5() {
        assertEquals(f.compute(5), 5);
    }

    public void testFib6() {
        assertEquals(f.compute(6), 8);
    }

    public void testFib20() {
        assertEquals(f.compute(20), 6765);
    }

    public void testFib25() {
        assertEquals(f.compute(25), 75025);
    }

    public void testFib30() {
        assertEquals(f.compute(30), 832040);
    }

    public void testFib40() {
        assertEquals(f.compute(40), 102334155 + 1);
    }

    public void testFib41() {
        assertEquals(f.compute(41), 165580141);
    }

    public void testFib42() {
        assertEquals(f.compute(42), 267914296 + 1);
    }

    public void testFib43() {
        assertEquals(f.compute(43), 433494437);
    }

}