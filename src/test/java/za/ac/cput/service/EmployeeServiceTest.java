package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;

import java.util.Set;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    private static Employee employee1;
    private static Employee employee2;

    @BeforeAll
    static void setup() {
        employee1 = new Employee.Builder().setEmployeeId(1L).setName("John Doe").setEmail("john@example.com").build();
        employee2 = new Employee.Builder().setEmployeeId(2L).setName("Jane Doe").setEmail("jane@example.com").build();
    }

    @Order(1)
    @Test
    void a_setup() {
        Assertions.assertNotNull(employee1);
        System.out.println(employee1);

        Assertions.assertNotNull(employee2);
        System.out.println(employee2);
    }

    @Order(2)
    @Test
    void b_saveEmployee() {
        Employee savedEmployee1 = employeeService.saveEmployee(employee1);
        Assertions.assertNotNull(savedEmployee1);
        System.out.println(savedEmployee1);

        Employee savedEmployee2 = employeeService.saveEmployee(employee2);
        Assertions.assertNotNull(savedEmployee2);
        System.out.println(savedEmployee2);
    }

    @Order(3)
    @Test
    void c_getEmployeeById() {
        Employee retrievedEmployee = employeeService.getEmployeeById(employee2.getEmployeeId());
        Assertions.assertNotNull(retrievedEmployee);
        System.out.println(retrievedEmployee);
    }

    @Order(4)
    @Test
    void d_updateEmployee() {
        Employee updatedEmployee = new Employee.Builder()
                .copy(employee2)
                .setName("Jane Smith")
                .build();
        Employee result = employeeService.updateEmployee(updatedEmployee);
        Assertions.assertNotNull(result);
        System.out.println(result);
    }

    @Order(5)
    @Test
    void e_getAllEmployees() {
        Set<Employee> allEmployees = employeeService.getAllEmployees();
        Assertions.assertFalse(allEmployees.isEmpty());
        System.out.println(allEmployees);
    }
}
