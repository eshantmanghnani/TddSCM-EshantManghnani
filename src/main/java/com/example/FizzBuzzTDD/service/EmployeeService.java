package com.example.FizzBuzzTDD.service;


import com.example.FizzBuzzTDD.model.Employee;
import com.example.FizzBuzzTDD.repository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRespository employeeRespository;


    public List<Employee> getAllEmployeesThatAreEarningMoreThan(Double amount) {
        return employeeRespository.getAllEmployees().stream().filter(employee -> employee.getSalary() > amount)
                .collect(Collectors.toList());
    }

    public List<Employee> getAllEmployeesExceedingAge(int age) {
        return employeeRespository.getAllEmployees().stream().filter(employee -> employee.getAge() > age).collect(Collectors.toList());
    }

    public List<Employee> getAllEmployeesWithMatchingPosition(String position) {
        return employeeRespository.getAllEmployees().stream().filter(employee -> employee.getPosition().equalsIgnoreCase(position)).collect(Collectors.toList());
    }

    public Employee getEmployeeWithHighestSalary() {
        return employeeRespository.getAllEmployees().stream().max(Comparator.comparing(Employee::getSalary)).get();
    }

    public List<Employee> getAllEmployees(){
        return employeeRespository.getAllEmployees();
    }

}
