package com.technosmithlabs.java.coding.questions.singleton;

public class SingletonImplementationUsingEnum {
    public static void main(String[] args) {
        SingletonEnumClass instance = SingletonEnumClass.INSTANCE;
        instance.setParams(10, 20);
        instance.printSomething();
        System.out.println("The value of fieldValueOne is: " + instance.getFieldValueOne());
        System.out.println("The value of fieldValueTwo is: " + instance.getFieldValueTwo());
    }
}

/**
 * As enums don’t have any constructor so it is not possible
 * for Reflection to utilize it. Enums have their by-default constructor,
 * we can’t invoke them by ourself.
 * JVM handles the creation and invocation of enum constructors internally.
 * As enums don’t give their constructor definition to the program, it is not possible for
 * us to access them by Reflection also. Hence, reflection can’t break singleton property in case of enums.
 */
enum SingletonEnumClass {
    INSTANCE;

    private int fieldValueOne;
    private int fieldValueTwo;

    public void printSomething() {
        System.out.println("I am printing from SingSingletonEnumClass...");
    }

    public void setParams(int fieldValueOne, int fieldValueTwo) {
        this.fieldValueOne = fieldValueOne;
        this.fieldValueTwo = fieldValueTwo;
    }

    public int getFieldValueOne() {
        return fieldValueOne;
    }

    public int getFieldValueTwo() {
        return fieldValueTwo;
    }
}


