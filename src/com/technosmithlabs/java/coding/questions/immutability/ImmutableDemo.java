package com.technosmithlabs.java.coding.questions.immutability;

public final class ImmutableDemo {

    public static void main(String[] args) {
        Address address = new Address("West Bengal", 700052L);
        ImmutablePatient immutableObj = new ImmutablePatient("Mr. TechnoSmith", 30, address);
        System.out.println(immutableObj.getAddress().getStateName());
        immutableObj.getAddress().setStateName("Bihar");
        // even though we have changed the Address object inside ImmutablePatient, the address val stays same.
        System.out.println(immutableObj.getAddress().getStateName());
    }
}

class Address {

    private String stateName;
    private Long zipCode;

    public Address(String stateName, Long zipCode) {
        this.stateName = stateName;
        this.zipCode = zipCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }
}

class ImmutablePatient {

    private final String name;
    private final int age;
    private final Address address;

    public ImmutablePatient(String name, int age, Address address) {
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


