package com.technosmithlabs.java.coding.questions.inheritence;

public class OverridingDemo {
    public static void main(String[] args) {
        DemoInterface obj = new ConcreteImpl();
        obj.printSomething();
        System.out.println(obj.val);
    }
}

interface DemoInterface {
    public int val = 10;

    public void printSomething();
}

class ConcreteImpl implements DemoInterface {
    // variables are not overridden. Only methods can be overriden.
    public int val = 11;

    @Override
    public void printSomething() {
        System.out.println("Value of subclass var is: " + val);
    }

    // this method cannot be called via DemoInterface obj, as printSomethingElse() method doesnt exist in the interface.
    public void printSomethingElse() {
        System.out.println("Printing something else");
    }
}