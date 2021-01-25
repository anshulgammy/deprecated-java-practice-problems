package com.technosmithlabs.java.coding.questions.immutability;

public class ImmutabilityMainClass {

    public static void main(String[] args) {
        Address address = new Address("West Bengal", 700052L);
        ImmutableClassDemo immutableObj = new ImmutableClassDemo("Mr. TechnoSmith", 30, address);
        System.out.println(immutableObj.getAddress().getStateName());
        immutableObj.getAddress().setStateName("Bihar");
        System.out.println(immutableObj.getAddress().getStateName());
    }
}
