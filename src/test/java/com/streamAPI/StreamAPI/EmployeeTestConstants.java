package com.streamAPI.StreamAPI;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeTestConstants {
    public static final String FIRST_NAME = "Ivan";
    public static final String LAST_NAME = "Ivanov";

    public static final String FIRST_NAME2 = "Petr";
    public static final String LAST_NAME2 = "Petrov";

    public static final String FIRST_NAME3 = "Rinat";
    public static final String LAST_NAME3 = "Agliulov";

    public static final String FIRST_NAME4 = "Alexey";
    public static final String LAST_NAME4 = "Alexeev";

    public static final String FIRST_NAME5 = "Sergey";
    public static final String LAST_NAME5 = "Sergeev";

    public static final String FIRST_NAME6 = "Egor";
    public static final String LAST_NAME6 = "Egorov";

    public static final String FIRST_NAME7 = "Semen";
    public static final String LAST_NAME7 = "Semenov";

    public static final String FIRST_NAME8 = "Andrey";
    public static final String LAST_NAME8 = "Andreev";

    public static final String FIRST_NAME9 = "Rinat";
    public static final String LAST_NAME9 = "Alexeev";

    public static final String FIRST_NAME10 = "Sergey";
    public static final String LAST_NAME10 = "Agliulov";

    public static final String FIRST_NAME11 = "Semen";
    public static final String LAST_NAME11 = "Antonov";

    public static final int MIN_SALARY = 100;
    public static final int MAX_SALARY = 100_000;

    public static final int DEPARTMENT_ID = 1;
    public static final int DEPARTMENT_ID2 = 2;

    public static final Employee MAX_SALARY_EMPLOYEE = new Employee(FIRST_NAME, LAST_NAME, MAX_SALARY, DEPARTMENT_ID);
    public static final Employee MIN_SALARY_EMPLOYEE = new Employee(FIRST_NAME3, LAST_NAME3, MIN_SALARY, DEPARTMENT_ID);



    public static final Employee DIFFERENT_DEPARTMENT_EMPLOYEE = new Employee(FIRST_NAME3, LAST_NAME3, MIN_SALARY, DEPARTMENT_ID2);

    public static final List<Employee> EMPLOYEES = List.of(MAX_SALARY_EMPLOYEE, MIN_SALARY_EMPLOYEE);
    public static final List<Employee> DIFFERENT_DEPARTMENT_EMPLOYEES = List.of(MAX_SALARY_EMPLOYEE, DIFFERENT_DEPARTMENT_EMPLOYEE);

    public static final Integer DEPARTMENT_TOTAL_SALARY = EMPLOYEES.stream()
            .mapToInt(Employee::getSalary)
            .sum();

    public static final Map<Integer, List<Employee>> EMPLOYEES_BY_DEPARTMENT_MAP = DIFFERENT_DEPARTMENT_EMPLOYEES.stream()
            .collect(groupingBy(Employee::getDepartmentId));
}
