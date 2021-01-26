package com.technosmithlabs.java.coding.questions.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakSingletonUsingReflectionDemo {

    public static void main(String[] args) {
        ExampleSingletonClass instanceOne = ExampleSingletonClass.getInstance();
        ExampleSingletonClass instanceAnother = ExampleSingletonClass.getInstance();
        System.out.println("Checking if hashcode is same for objects obtained using getInstance of Singleton class: "
                + (instanceOne == instanceAnother));
        breakSingletonUsingReflection();
        breakSingletonUsingSerialization();
        breakSingletonUsingCloning();
    }

    /**
     * For this method to work, you dont need any additional config to be present in the Singleton class.
     * This hack will work for almost all the Singleton class.
     * To make Singleton implementation unhackable
     * using Reflection, we would need to make use of Enums to create Singleton classes.
     */
    public static void breakSingletonUsingReflection() {
        System.out.println("Breaking the singleton pattern using Reflection");
        ExampleSingletonClass instanceOne = ExampleSingletonClass.getInstance();
        ExampleSingletonClass instanceAnother = null;
        Constructor[] constructors = ExampleSingletonClass.class.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            constructors[i].setAccessible(true);
            try {
                instanceAnother = (ExampleSingletonClass) constructors[i].newInstance();
                break;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Checking if instanceOne and instanceAnother of ExampleSingletonClass are equal or not: "
                + (instanceAnother == instanceOne));
        System.out.println("Hashcode of instanceOne is: " + instanceOne.hashCode());
        System.out.println("Hashcode of instanceAnother is: " + instanceAnother.hashCode());
    }

    /**
     * The Singleton class should be serializable for this method to work.
     * If not, then you will get NotSerializableException.
     */
    public static void breakSingletonUsingSerialization() {
        System.out.println("Breaking the singleton pattern using Serialization");
        ExampleSingletonClass instanceOne = ExampleSingletonClass.getInstance();
        ExampleSingletonClass instanceAnother = null;
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("output.txt"));
            outputStream.writeObject(instanceOne);
            outputStream.close();
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("output.txt"));
            instanceAnother = (ExampleSingletonClass) inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Checking if instanceOne and instanceAnother of ExampleSingletonClass are equal or not: "
                + (instanceAnother == instanceOne));
        System.out.println("Hashcode of instanceOne is: " + instanceOne.hashCode());
        System.out.println("Hashcode of instanceAnother is: " + instanceAnother.hashCode());
    }

    public static void breakSingletonUsingCloning() {
        System.out.println("Breaking the singleton pattern using Cloning");
        ExampleSingletonClass instanceOne = ExampleSingletonClass.getInstance();
        ExampleSingletonClass instanceAnother = null;
        try {
            instanceAnother = (ExampleSingletonClass) instanceOne.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("Checking if instanceOne and instanceAnother of ExampleSingletonClass are equal or not: "
                + (instanceAnother == instanceOne));
        System.out.println("Hashcode of instanceOne is: " + instanceOne.hashCode());
        System.out.println("Hashcode of instanceAnother is: " + instanceAnother.hashCode());
    }
}

class ExampleSingletonClass implements Cloneable, Serializable {

    private static ExampleSingletonClass instance = null;

    private ExampleSingletonClass() {

    }

    public static ExampleSingletonClass getInstance() {
        if (instance == null) {
            instance = new ExampleSingletonClass();
        }
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
