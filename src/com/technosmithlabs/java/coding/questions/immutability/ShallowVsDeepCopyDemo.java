package com.technosmithlabs.java.coding.questions.immutability;

public class ShallowVsDeepCopyDemo {
    public static void main(String[] args) {
        PatientAddress address = new
                PatientAddress("Kaikhali, Kolkata",
                new ZipMapper(700052, "Airlines Housing Colony"));
        Patient patientOne = new Patient(1, "Mary", address);
        Patient patientSecond = null;
        Patient patientThird = null;
        try {
            patientSecond = new Patient(2, "Kom", (PatientAddress) address.clone());
            patientThird = new Patient(2, "Kom", new PatientAddress(address));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("Demonstrating Shallow Copy...");
        System.out.println("PatientAddress ZipMapper hashCode for patientOne is: " + patientOne.getAddress().getZipMapper());
        System.out.println("PatientAddress ZipMapper hashCode for patientTwo is: " + patientSecond.getAddress().getZipMapper());
        System.out.println("Demonstrating Deep Copy...patientThird's address class has been deeply copied.");
        System.out.println("PatientAddress ZipMapper hashCode for patientOne is: " + patientOne.getAddress().getZipMapper());
        System.out.println("PatientAddress ZipMapper hashCode for patientThird is: " + patientThird.getAddress().getZipMapper());
        System.out.println("PatientAddress hashcode for patientOne hashcode is : " + patientOne.getAddress());
        System.out.println("PatientAddress hashcode for patientSecond hashcode is : " + patientSecond.getAddress());
        System.out.println("PatientAddress hashcode for patientThird hashcode is : " + patientThird.getAddress());
    }
}

class Patient {
    private int patientId;
    private String patientName;
    private PatientAddress address;

    public Patient(int patientId, String patientName, PatientAddress address) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.address = address;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public PatientAddress getAddress() {
        return address;
    }

    public void setAddress(PatientAddress address) {
        this.address = address;
    }
}

class PatientAddress implements Cloneable {

    private String completeAddress;
    private ZipMapper zipMapper;

    public PatientAddress(String completeAddress, ZipMapper zipMapper) {
        this.completeAddress = completeAddress;
        this.zipMapper = zipMapper;
    }

    public PatientAddress(PatientAddress patientAddress) {
        this.completeAddress = patientAddress.getCompleteAddress();
        this.zipMapper = new ZipMapper(patientAddress.getZipMapper().getZipCode(), patientAddress.getZipMapper().getColonyName());
    }

    public String getCompleteAddress() {
        return completeAddress;
    }

    public void setCompleteAddress(String completeAddress) {
        this.completeAddress = completeAddress;
    }

    public ZipMapper getZipMapper() {
        return zipMapper;
    }

    public void setZipMapper(ZipMapper zipMapper) {
        this.zipMapper = zipMapper;
    }

    /**
     * Used default clone() method implementation which is doing shallow copy.
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Used default clone() method implementation which here is doing deep copy.
     *
     * @return
     * @throws CloneNotSupportedException
     */
    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        return new PatientAddress(this.getCompleteAddress(), new ZipMapper(this.getZipMapper().getZipCode(), this.getZipMapper().getColonyName()));
    }*/
}

class ZipMapper {
    private int zipCode;
    private String colonyName;

    public ZipMapper(int zipCode, String colonyName) {
        this.zipCode = zipCode;
        this.colonyName = colonyName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getColonyName() {
        return colonyName;
    }

    public void setColonyName(String colonyName) {
        this.colonyName = colonyName;
    }
}
