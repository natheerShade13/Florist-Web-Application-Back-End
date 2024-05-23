package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Transactional
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    private Employee employee;

    @Test
    void a_create() {
        Employee.Builder builder = new Employee.Builder();
        builder.setName("Kakashi")
                .setEmail("kakeshi@gmail.com")
                .setAddress("123 Main St")
                .setPhone("123-456-7890")
                .setRole("Developer");
        employee = builder.build();

        employeeService.create(employee);
        assertNotNull(employee.getEmployeeId());
    }

    @Test
    void b_read() {
        a_create(); // Ensure that an employee record is created before attempting to read
        Employee foundEmployee = employeeService.read(employee.getEmployeeId());
        assertNotNull(foundEmployee);
        assertEquals(employee.getName(), foundEmployee.getName());
        assertEquals(employee.getEmail(), foundEmployee.getEmail());
        assertEquals(employee.getAddress(), foundEmployee.getAddress());
        assertEquals(employee.getPhone(), foundEmployee.getPhone());
        assertEquals(employee.getRole(), foundEmployee.getRole());
    }

    @Test
    void c_update() {
        a_create(); // Ensure that an employee record is created before attempting to update
        String newAddress = "456 Oak St";
        String newPhone = "987-654-3210";
        String newRole = "Manager";
        Employee.Builder builder = new Employee.Builder().copy(employee);
        builder.setAddress(newAddress)
                .setPhone(newPhone)
                .setRole(newRole);
        Employee updatedEmployee = builder.build();
        employeeService.update(updatedEmployee);
        Employee retrievedEmployee = employeeService.read(employee.getEmployeeId());
        assertEquals(newAddress, retrievedEmployee.getAddress());
        assertEquals(newPhone, retrievedEmployee.getPhone());
        assertEquals(newRole, retrievedEmployee.getRole());
    }

    @Test
    void d_delete() {
        a_create(); // Ensure that an employee record is created before attempting to delete
        employeeService.delete(employee.getEmployeeId());
        Employee deletedEmployee = employeeService.read(employee.getEmployeeId());
        assertNull(deletedEmployee);
    }
}
