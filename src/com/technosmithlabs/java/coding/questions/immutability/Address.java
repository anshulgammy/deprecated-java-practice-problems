package com.technosmithlabs.java.coding.questions.immutability;

public class Address {

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
