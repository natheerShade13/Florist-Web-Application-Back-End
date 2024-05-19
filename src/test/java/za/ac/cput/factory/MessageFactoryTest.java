package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Message;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MessageFactoryTest {

    private Message messageA;

    /*
    private Message messageB;
    private Message messageC;
    */

    @Test
    @Order(1)
    void buildMessage() {
        Customer customerA = new Customer.Builder().build();
        Employee employeeA = new Employee.Builder().build();
        Date dateSentA = new Date();
        messageA = MessageFactory.buildMessage(1L, "Test Subject A", "Test Message A", false, dateSentA, customerA, employeeA);
        assertNotNull(messageA);
        System.out.println(messageA);
    }

    /*
    @Test
    @Order(2)
    void copyBuildMessage() {
        Customer customerB = new Customer.Builder().build();
        Employee employeeB = new Employee.Builder().build();
        Date dateSentB = new Date();
        messageC = MessageFactory.buildMessage(2L, "Test Subject B", "Test Message B", false, dateSentB, customerB, employeeB);
        messageB = new Message.Builder().copy(messageC).setSubject("Updated Test Subject B").build();
        assertNotNull(messageB);
        System.out.println(messageB);
    }
     */
}
