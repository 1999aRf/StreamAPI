package com.streamAPI.StreamAPI;

import com.streamAPI.StreamAPI.exception.EmployeeNotFoundException;
import com.streamAPI.StreamAPI.service.EmployeeService;
import com.streamAPI.StreamAPI.service.impl.DepartmentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.streamAPI.StreamAPI.EmployeeTestConstants.*;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    void findEmployeeWithMaxSalary() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE,
                departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployeeWithMaxSalary() {
        when(employeeService.findAll()).thenReturn(emptyList());

        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void findEmployeeWithMinSalary() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployeeWithMinSalary() {
        when(employeeService.findAll()).thenReturn(emptyList());

        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void findEmployeesByDepartment() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);

         assertEquals(singletonList(MAX_SALARY_EMPLOYEE), departmentService.findEmployeesByDepartment(DEPARTMENT_ID));
        assertEquals(singletonList(DIFFERENT_DEPARTMENT_EMPLOYEE), departmentService.findEmployeesByDepartment(DEPARTMENT_ID2));
    }

    @Test
    public void groupedEmployeesByDepartment() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);
        assertEquals(EMPLOYEES_BY_DEPARTMENT_MAP, departmentService.groupedEmployeesByDepartment());
    }

    @Test
    public void getTotalSalaryByDepartment() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(DEPARTMENT_TOTAL_SALARY, departmentService.getTotalSalaryByDepartment(DEPARTMENT_ID2));
    }
}