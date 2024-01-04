package com.StreamApi.demo;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeWithMaxSalary(@RequestParam("departmentId") int departmentId);

    Employee getEmployeeWithMinSalary(@RequestParam("departmentId") int departmentId);

    List<Employee> getAllEmployees(@RequestParam(required = false) Integer departmentId);

    Map<Integer, List<Employee>> getAllEmployeesGrouped();
}
