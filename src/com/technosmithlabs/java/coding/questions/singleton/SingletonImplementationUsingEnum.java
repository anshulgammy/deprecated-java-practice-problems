package com.technosmithlabs.java.coding.questions.singleton;

public class SingletonImplementationUsingEnum {
    public static void main(String[] args) {
        SingletonEnumClass instance = SingletonEnumClass.INSTANCE;
        instance.setParams(10,20);
        instance.printSomething();
        System.out.println("The value of fieldValueOne is: " + instance.getFieldValueOne());
        System.out.println("The value of fieldValueTwo is: " + instance.getFieldValueTwo());
    }
}

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


