package com.streamAPI.StreamAPI.service;

import com.streamAPI.StreamAPI.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalary(int departmentId);
    Employee findEmployeeWithMinSalary(int departmentId);
    Collection<Employee> findEmployeesByDepartment(int departmentId);

    Map<Integer, List<Employee>> groupedEmployeesByDepartment();

    Integer getTotalSalaryByDepartment(int departmentId);
}
