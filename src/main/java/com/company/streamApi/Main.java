package com.company.streamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> empList = Arrays.asList(
                new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020),
                new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015),
                new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014),
                new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013),
                new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013),
                new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017),
                new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016),
                new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015),
                new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010)
        );

        Map<String, List<Employee>> employeesByCity = empList.stream()
                .collect(Collectors.groupingBy(Employee::getCity));

        employeesByCity.forEach((city, employees) -> {
            System.out.println("City: " + city);
            employees.forEach(System.out::println);
            System.out.println();
        });


        Map<Integer, List<Employee>> employeesByAge = empList.stream().collect(Collectors.groupingBy(Employee::getAge));

        employeesByAge.forEach((age, employees) -> {
            System.out.println(age);
            employees.forEach(System.out::println);
            System.out.println();
        });

        Map<String, Long> employeesCountByGender = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        employeesCountByGender.forEach((gender, count) -> {
            System.out.println("Gender: " + gender + ", Count: " + count);
        });

        empList.stream()
                .map(Employee::getDeptName)
                .distinct()
                .forEach(System.out::println);

        System.out.println("Employees with age greater than 28:");

        empList.stream().filter((value) -> value.getAge() > 28).forEach(System.out::println);
        System.out.println("Maximum age of employee");

        int maxAge = empList.stream().mapToInt(Employee::getAge).max().orElseThrow(() -> new RuntimeException("No user found"));
        System.out.println(maxAge);

        System.out.println("Average of Male and Female employees:");

        Map<String, Double> averageByGenderAge = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        averageByGenderAge.forEach((gender, average) -> {
            System.out.println("Gender: " + gender + ", Average Age: " + average);
        });

        System.out.println("Grouping employees by department ");
        empList.stream().collect(Collectors.groupingBy(Employee::getDeptName)).forEach((department, employees) -> {
            System.out.println(department);
            employees.forEach(System.out::println);
            System.out.println();
        });
        System.out.println("Counting employees by department");
        empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).forEach((department, count) -> {
            System.out.println("Department: " + department + ":" + count);
        });

        System.out.println("Oldest employee");
        System.out.println(empList.stream()
                .max(Comparator.comparing(Employee::getAge)).orElseThrow(() -> new RuntimeException("No employee found")));

        System.out.println("Youngest female employee: ");
        System.out.println(empList.stream().filter(value -> "F".equalsIgnoreCase(value.getGender()))
                .min(Comparator.comparing(Employee::getAge)).orElseThrow(() -> new RuntimeException("No employee found")));

        System.out.println("Employees younger than 30 years");
        empList.stream().filter(value -> value.getAge() < 30).forEach(System.out::println);

        System.out.println("Employees older than 30 years");
        empList.stream().filter(value -> value.getAge() > 30).forEach(System.out::println);

        System.out.println("Department with highest number of employees");

        Map<String, Long> departmentCount = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));

        System.out.println(departmentCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElseThrow(() -> new RuntimeException("No employee")));

        boolean anyHrEmployee = empList.stream().anyMatch(value -> "HR".equalsIgnoreCase(value.getDeptName()));

        if (anyHrEmployee) {
            System.out.println("There are employees in the HR department.");
        } else {
            System.out.println("No employees found in the HR department.");
        }




    }
}
