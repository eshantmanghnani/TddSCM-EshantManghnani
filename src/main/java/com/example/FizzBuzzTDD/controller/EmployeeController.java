package com.example.FizzBuzzTDD.controller;

import com.example.FizzBuzzTDD.model.Employee;
import com.example.FizzBuzzTDD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeController {
    @Autowired
    EmployeeService employeeService; // inject service

    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
