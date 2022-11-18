package com.example.FizzBuzzTDD;

import com.example.FizzBuzzTDD.model.Employee;
import com.example.FizzBuzzTDD.repository.EmployeeRespository;
import com.example.FizzBuzzTDD.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock
    private EmployeeRespository employeeRespository;
    @InjectMocks
    private EmployeeService employeeService = new EmployeeService();

    // Employee, Eshant, 25, 20000
    // Employee, Jerome, 26, 150000
    // Employee, Jojo, 22, 100000

    Employee eshant = new Employee("Eshant", 25, 20000d, "Software Developer");
    Employee jerome = new Employee("Jerome", 26, 150000d, "Software Developer");
    Employee jojo = new Employee("Jojo", 22,200000d, "QA Developer");

    @Test
    @DisplayName("Given employees from repository with the setup above " +
            "WHEN getAllEmployeesThatAreEarningMoreThan is executed with input 90000 " +
            "THEN result should return Jerome and Jojo")
    public void testEmployeesEarningMoreThanAmount() {
        //arrange

        List<Employee> employees = List.of(eshant
                , jerome, jojo);

        Mockito.when(employeeRespository.getAllEmployees())
                .thenReturn(employees);
        //act
        List<Employee> filteredEmployees = employeeService.getAllEmployeesThatAreEarningMoreThan(90000d);

        //assert
        assertThat(filteredEmployees).contains(jerome, jojo);
        assertThat(filteredEmployees).doesNotContain(eshant);
    }

    @Test
    @DisplayName("Given employees from repository with the setup above " +
            "WHEN getAllEmployeesExceedingAge is executed with an age limit of 24 " +
            "THEN result should return Eshant and Jerome")
    public void getAllEmployeesExceedingAge() {
        //arrange
        List<Employee> employees = List.of(eshant
                , jerome, jojo);
        int age = 24;

        Mockito.when(employeeRespository.getAllEmployees())
                .thenReturn(employees);
        //act
        List<Employee> filteredEmployees = employeeService.getAllEmployeesExceedingAge(24);

        //assert
        assertThat(filteredEmployees).contains(eshant, jerome);
        assertThat(filteredEmployees).doesNotContain(jojo);
    }

    @Test
    @DisplayName("Given employees from repository with the setup above " +
            "WHEN getAllEmployeesWithMatchingPosition is executed with an input of Software Developer " +
            "THEN result should return Eshant and Jerome")
    public void getAllEmployeesWithMatchingPosition() {
        //arrange
        List<Employee> employees = List.of(eshant
                , jerome, jojo);
        String position = "Software Developer";

        Mockito.when(employeeRespository.getAllEmployees())
                .thenReturn(employees);
        //act
        List<Employee> filteredEmployees = employeeService.getAllEmployeesWithMatchingPosition(position);

        //assert
        assertThat(filteredEmployees).contains(eshant, jerome);
        assertThat(filteredEmployees).doesNotContain(jojo);
    }

    @Test
    @DisplayName("Given employees from repository with the setup above " +
            "WHEN getEmployeeWithHighestSalary is executed " +
            "THEN result should return Jojo")
    public void getEmployeeWithHighestSalary() {
        //arrange
        List<Employee> employees = List.of(eshant
                , jerome, jojo);
        String position = "Software Developer";

        Mockito.when(employeeRespository.getAllEmployees())
                .thenReturn(employees);
        //act
        Employee filteredEmployee = employeeService.getEmployeeWithHighestSalary();

        //assert
        assertEquals(filteredEmployee, jojo);
    }

}