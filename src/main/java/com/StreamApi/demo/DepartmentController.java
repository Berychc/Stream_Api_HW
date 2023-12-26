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

    public DepartmentController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam("departmentId") int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartament() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam("departmentId") int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartament() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees(@RequestParam(required = false) Integer departmentId) {
        Stream<Employee> employeeStream = employeeService.getAllEmployees().stream();

        if (departmentId != null) {
            employeeStream = employeeStream.filter(employee -> employee.getDepartament() == departmentId);
        }

        return employeeStream.collect(Collectors.toList());
    }

    @GetMapping("/allEmployees")
    public Map<Integer, List<Employee>> getAllEmployeesGrouped() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartament));
    }
}
