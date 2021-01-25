package com.technosmithlabs.java.coding.questions.immutability;

public final class ImmutableClassDemo {

    private final String name;
    private final int age;
    private final Address address;

    public ImmutableClassDemo(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        Address tempAddress = new Address(this.address.getStateName(), this.address.getZipCode());
        return tempAddress;
    }
}
