package com.technosmithlabs.java.coding.questions.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetUniqueEntriesOnlyDemo {
    public static void main(String[] args) {
        Set<BananaMarket> bananaSet = new HashSet<>();
        // adding bananas to the set which has same attribute values.
        bananaSet.add(new BananaMarket(50F, "Misri"));
        bananaSet.add(new BananaMarket(50F, "Misri"));
        // even though objects have same attribute values but Set will duplicate inserts.
        System.out.println("Iterating over the class type where equals and hashCode are not overriden");
        Iterator<BananaMarket> iterator = bananaSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Set<BananaMarketModified> bananaModifiedSet = new HashSet<>();
        // adding bananas to the set which has same attribute values.
        bananaModifiedSet.add(new BananaMarketModified(50F, "Misri"));
        bananaModifiedSet.add(new BananaMarketModified(50F, "Misri"));
        System.out.println("Iterating over the class type where equals and hashCode are overriden");
        Iterator<BananaMarketModified> anotherIterator = bananaModifiedSet.iterator();
        while(anotherIterator.hasNext()) {
            System.out.println(anotherIterator.next());
        }
    }
}

class BananaMarket {
    private float pricePerDozen;
    private String type;

    public BananaMarket(float pricePerDozen, String type) {
        this.pricePerDozen = pricePerDozen;
        this.type = type;
    }

    public float getPricePerDozen() {
        return pricePerDozen;
    }

    public void setPricePerDozen(float pricePerDozen) {
        this.pricePerDozen = pricePerDozen;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Banana Price per dozen: " + this.getPricePerDozen() + " and Banana type is: " + this.getType();
    }
}

class BananaMarketModified {
    private float pricePerDozen;
    private String type;

    public BananaMarketModified(float pricePerDozen, String type) {
        this.pricePerDozen = pricePerDozen;
        this.type = type;
    }

    public float getPricePerDozen() {
        return pricePerDozen;
    }

    public void setPricePerDozen(float pricePerDozen) {
        this.pricePerDozen = pricePerDozen;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Banana Price per dozen: " + this.getPricePerDozen() + " and Banana type is: " + this.getType();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BananaMarketModified) {
            if(obj==this) {
                return true;
            } else {
                BananaMarketModified targetObj = (BananaMarketModified) obj;
                return targetObj.getPricePerDozen() == this.getPricePerDozen() && this.getType().equals(targetObj.getType());
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) this.getPricePerDozen()/12 + this.getType().hashCode();
    }
}