package za.ac.cput.service;

import za.ac.cput.domain.Employee;

import java.util.Set;

public interface IEmployeeService extends IService<Employee, Long> {
    Set<Employee> getAllEmployees();
}
