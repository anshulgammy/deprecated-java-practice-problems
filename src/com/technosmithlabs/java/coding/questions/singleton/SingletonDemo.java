package com.technosmithlabs.java.coding.questions.singleton;

public class SingletonDemo {

    public static void main(String[] args) {
        // we cannot create object using new, as SingletonClass is having private constructor.
        System.out.println(SingletonClass.getInstance());
        // we get the same instance, same hashcode, every time we do a getInstance().
        System.out.println(SingletonClass.getInstance());
    }

}

class SingletonClass {
    private static SingletonClass instance = null;

    private SingletonClass() {
    }

    public static SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }
}
