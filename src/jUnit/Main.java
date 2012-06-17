package jUnit;

import jUnit.control.Controller;

public class Main {

    public static void main(String[] args) {
        Controller.getInstance().runTests(FooTest.class);
    }
}
