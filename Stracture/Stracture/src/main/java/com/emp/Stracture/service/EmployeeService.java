package com.emp.Stracture.service;


import com.emp.Stracture.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getContractResignedEmployeesFromKolkataWithLowSalary();
    List<Employee> getAllEmployeesSorted(); // For Question 17
}