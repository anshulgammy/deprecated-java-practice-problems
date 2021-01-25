package com.technosmithlabs.java.coding.questions.singleton;

public class SingletonDemo {

    private static SingletonDemo instance = null;

    private SingletonDemo() {
    }

    public static SingletonDemo getInstance() {
        if(instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }
}
