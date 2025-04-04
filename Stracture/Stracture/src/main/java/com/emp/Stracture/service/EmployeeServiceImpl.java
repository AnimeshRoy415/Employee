package com.emp.Stracture.service;

import com.emp.Stracture.Entity.Employee;
import com.emp.Stracture.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getContractResignedEmployeesFromKolkataWithLowSalary() {
        return employeeRepository
                .findByLocation_LocationNameAndEmploymentType_EmploymentTypeDescAndSalaryLessThanAndStatus_StatusDesc(
                        "Kolkata", "Contract", 50000.0, "RESIGNED"
                );
    }

    @Override
    public List<Employee> getAllEmployeesSorted() {
        return employeeRepository.findAll().stream()
                .sorted(Comparator
                        .comparing(Employee::getSalary)
                        .thenComparing(Employee::getJoiningDate)
                        .thenComparing(Employee::getLastName)
                )
                .collect(Collectors.toList());
    }
}
