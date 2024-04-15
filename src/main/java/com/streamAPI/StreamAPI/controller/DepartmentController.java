package com.streamAPI.StreamAPI.controller;

import com.streamAPI.StreamAPI.Employee;
import com.streamAPI.StreamAPI.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}/employees")
    public Collection<Employee> getEmployeesByDepartment(@PathVariable int departmentId) {
        return departmentService.findEmployeesByDepartment(departmentId);
    }

    @GetMapping("/{departmentId}/salary/sum")
    public Integer getSalarySumByDepartment(@PathVariable int departmentId) {
        return departmentService.getTotalSalaryByDepartment(departmentId);
    }

    @GetMapping("/{departmentId}/salary/max")
    public Employee findEmployeeWithMaxSalary(@PathVariable int departmentId) {
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("{departmentId}/salary/min")
    public Employee findEmployeeWithMinSalary(@PathVariable int departmentId) {
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }
    @GetMapping(value = "{departmentId}/employees", params = {"departmentId"})
    public Collection<Employee> findEmployeeByDepartment(@PathVariable int departmentId) {
        return departmentService.findEmployeesByDepartment(departmentId);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> groupedEmployeesByDepartment() {
        return departmentService.groupedEmployeesByDepartment();
    }
}
