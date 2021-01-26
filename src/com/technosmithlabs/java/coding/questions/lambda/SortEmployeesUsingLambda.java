package com.technosmithlabs.java.coding.questions.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmployeesUsingLambda {

    private static final List<Employee> employeesList = Arrays.asList(
            new Employee("Mr. A", 21),
            new Employee("Mr. B", 15),
            new Employee("Mr. C", 29),
            new Employee("Mr. D", 32),
            new Employee("Anshul", 24)
    );

    public static void main(String[] args) {
        // preparing Employee Name list to obtain a filtered list where employee's age is even number
        final List<String> filteredEmployeeNameList = employeesList.stream().filter(e -> {
                    return e.getAge() % 2 == 0;
                }
        ).map(e -> e.getName()).collect(Collectors.toList());
        System.out.println("Employee names are: " + filteredEmployeeNameList);
        // preparing Employee age list where they are of even type.
        final List<Integer> filteredEmployeeAgeList = employeesList.stream().filter(e -> e.getAge() % 2 == 0)
                .map(Employee::getAge).collect(Collectors.toList());
        System.out.println("Employee Ages are: " + filteredEmployeeAgeList);
        // preparing string list of employees whose name start with letter 'A"
        List<String> employeesNameList = employeesList.stream().filter(e -> e.getName().startsWith("A"))
                .map(Employee::getName).collect(Collectors.toList());
        System.out.println("Employee List whose name starts with 'A' are : " + employeesNameList);
        // sorting Employee object based on their age and preparing a list of such Employee names
        List<String> sortedByNameList = employeesList.stream().sorted().map(e -> e.getName()).collect(Collectors.toList());
        System.out.println("Employee Names in order of their increasing age are : " + sortedByNameList);
    }
}

class Employee implements Comparable<Employee> {

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Employee employee) {
        return this.getAge() - employee.getAge();
    }
}
