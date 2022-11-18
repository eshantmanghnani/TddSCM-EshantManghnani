package com.example.FizzBuzzTDD;

import com.example.FizzBuzzTDD.model.Employee;
import com.example.FizzBuzzTDD.repository.EmployeeRepositoryFromCSV;
import com.example.FizzBuzzTDD.repository.EmployeeRespository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmployeeRepositoryFromCSVTest {

    @Test
    @DisplayName("" +
            "Given a csv in datastore.csv" +
            "when employeeRepositoryFROMCSV is executed" +
            "THEN it should return valid Employee objects")
    public void positiveCase() {
        //arrange
        EmployeeRespository employeeRespository = new EmployeeRepositoryFromCSV();
        //act

        List<Employee> employeesFromCSV = employeeRespository.getAllEmployees();

        //assert

        List<Employee> expectedEmployees = List.of(
                new Employee("Wayne", 30, 20000d, "softwareengineer"),
                new Employee("Eshant", 23, 200000d, "softwareengineer"),
                new Employee("Alejandro", 25, 2000000d, "qaengineer")
        );
        assertEquals(expectedEmployees, employeesFromCSV);
    }
}