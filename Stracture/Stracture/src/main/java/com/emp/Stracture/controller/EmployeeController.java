package com.emp.Stracture.controller;

import com.emp.Stracture.Entity.Employee;
import com.emp.Stracture.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // Question 16: Get contract employees from Kolkata with salary < 50,000 and status RESIGNED
    @GetMapping("/filtered")
    public List<Employee> getFilteredEmployees() {
        return employeeService.getContractResignedEmployeesFromKolkataWithLowSalary();
    }

    // Question 17: Sort employees and write to a file
    @GetMapping("/sorted-to-file")
    public String sortEmployeesAndWriteToFile() {
        List<Employee> sortedEmployees = employeeService.getAllEmployeesSorted();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sorted_employees.txt"))) {
            for (Employee emp : sortedEmployees) {
                writer.write(String.format("ID: %s, Name: %s %s, Salary: %.2f, Joining Date: %s%n",
                        emp.getEmployeeId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getSalary(),
                        emp.getJoiningDate()));
            }
            return "Sorted employee list has been written to sorted_employees.txt";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred while writing to file.";
        }
    }

    // Optional: View sorted employees directly as JSON
    @GetMapping("/sorted")
    public List<Employee> getSortedEmployeesAsJson() {
        return employeeService.getAllEmployeesSorted();
    }
}
