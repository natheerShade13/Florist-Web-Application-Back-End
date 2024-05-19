package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Message;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeFactoryTest {

    private Employee employeeA;

    /*
    private Employee employeeB;
    private Employee employeeC;
    */

    @Test
    @Order(1)
    void buildEmployee() {
        employeeA = EmployeeFactory.buildEmployee(1L, "Jodi-Lee", "jodileerudolph@gmail.com", "123 Main St", "1234567890", "Manager", new ArrayList<Message>());
        assertNotNull(employeeA);
        System.out.println(employeeA);
    }
/*
    @Test
    @Order(2)
    void copyBuildEmployee() {
        employeeC = EmployeeFactory.buildEmployee(2L, "Chadwin", "chadwinkyle2@gmail.com", "123 Main St", "9876543210", "Assistant", new ArrayList<Message>());
        employeeB = new Employee.Builder().copy(employeeC).setRole("Senior Assistant").build();
        assertNotNull(employeeB);
        System.out.println(employeeB);
    }
    */
}
