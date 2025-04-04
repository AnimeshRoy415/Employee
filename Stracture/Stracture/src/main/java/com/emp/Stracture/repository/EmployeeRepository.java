package com.emp.Stracture.repository;

import com.emp.Stracture.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom query to find contract employees from Kolkata with salary < 50000 and status RESIGNED
    List<Employee> findByLocation_LocationNameAndEmploymentType_EmploymentTypeDescAndSalaryLessThanAndStatus_StatusDesc(
            String locationName,
            String employmentTypeDesc,
            Double salary,
            String statusDesc
    );
}
