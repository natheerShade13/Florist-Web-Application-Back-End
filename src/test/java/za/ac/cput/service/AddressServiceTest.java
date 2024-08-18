package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CustomerFactory;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressServiceTest {

    @Autowired
    private AddressService addressService;
    @Autowired
    private CustomerService customerService;

    private static Customer customer;
    private static Address address;

    @Test
    @Order(0)
    void setup(){
        customer = CustomerFactory.buildCustomer("Jake", "Long"
                , "long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        address = AddressFactory.buildAddress(2, "10", "Church street"
                , "Strandfontein", "7798", "Cape Town", customer);
    }

    @Test
    @Order(1)
    void create() {
        Customer createCustomer = customerService.create(customer);
        assertNotNull(createCustomer);
        System.out.println(createCustomer);
        Address createAddress = addressService.create(address);
        assertNotNull(createAddress);
        System.out.println(createAddress);
    }

    @Test
    @Order(2)
    void read() {
        Address findAddress = addressService.read(address.getAddressId());
        assertNotNull(findAddress);
        System.out.println(findAddress);
    }

    @Test
    @Order(3)
    void update() {
        Address newAddress = new Address.Builder().copy(address).setStreetNumber("15").build();
        assertNotNull(newAddress);
        Address updatedAddress = addressService.update(newAddress);
        assertNotNull(updatedAddress);
        System.out.println(updatedAddress);
    }

    @Test
    @Order(5)
    //@Disabled
    void delete() {
        boolean deleteAddress = addressService.delete(address.getAddressId());
        assertTrue(deleteAddress);
        System.out.println(deleteAddress);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(addressService.getAll());
    }
}