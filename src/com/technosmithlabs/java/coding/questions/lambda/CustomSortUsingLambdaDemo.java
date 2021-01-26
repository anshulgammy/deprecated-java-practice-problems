package com.technosmithlabs.java.coding.questions.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomSortUsingLambdaDemo {
    public static void main(String[] args) {
        List<ComputerScienceStudent> studentList = Arrays.asList(
                new ComputerScienceStudent(1, "Rohit"),
                new ComputerScienceStudent(2, "Ramesh"),
                new ComputerScienceStudent(3, "Ujjwal"),
                new ComputerScienceStudent(4, "Seema"),
                new ComputerScienceStudent(5, "Remma")
        );
        List<String> studentsNameList = studentList.stream().sorted(new ComputerScienceStudentComparator())
                .map(ComputerScienceStudent::getName).collect(Collectors.toList());
        studentsNameList.forEach(name -> System.out.println(name));
    }
}

class ComputerScienceStudent {

    private int rollNumber;
    private String name;

    public ComputerScienceStudent(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ComputerScienceStudentComparator implements Comparator<ComputerScienceStudent> {

    @Override
    public int compare(ComputerScienceStudent studentOne, ComputerScienceStudent studentSecond) {
        return studentSecond.getRollNumber() - studentOne.getRollNumber();
    }
}
