package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class AddressServiceTest {

    @Autowired
  private  AddressService addressService;
  private static Address address1;


    @BeforeEach
    void setUp() {
        address1 = AddressFactory.createAddress("67", "Lower Street", " Mowbray", "Cape Town", "7700", "Western Cape");

    }
    @Test
    void a_setup() {
        assertNotNull(address1);
        System.out.println(address1);

    }
    @Test
    void b_create() {
        Address created1 = addressService.create(address1);
        assertNotNull(created1);
        System.out.println(created1);


    }

    @Test
    void c_read() {
        Address read = addressService.read(address1.getAddressId());
        System.out.println(read);
    }

    @Test
    void d_update() {
        Address newAddress= new Address.Builder().copy(address1).setSuburb("WoodStock")
                .build();
        Address updated= addressService.update(newAddress);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    void e_getAll() {
        System.out.println(addressService.getAll());
    }
}