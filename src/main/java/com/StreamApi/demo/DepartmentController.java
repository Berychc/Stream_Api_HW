package com.StreamApi.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final EmployeeService employeeService;

    public DepartmentController(EmployeeService employeeService)        {
        this.employeeService = employeeService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalary(@RequestParam("departmentId") int departmentId) {
        return employeeService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalary(@RequestParam("departmentId") int departmentId) {
        return employeeService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> findAllEmployees(@RequestParam(required = false) Integer departmentId) {
        return employeeService.getAllEmployees(departmentId);
    }

    @GetMapping("/allEmployees")
    public Map<Integer, List<Employee>> findAllEmployeesGrouped() {
        return employeeService.getAllEmployeesGrouped();
    }
}
