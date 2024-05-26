package za.ac.cput.factory;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.core.annotation.Order;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Cart;
import java.time.LocalDate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartFactoryTest {

    private Cart cartA;
    private Cart cartB;

    @Test
    @Order(1)
    void createCart(){
        Customer customer = new Customer();
        LocalDate cartDateA = LocalDate.now();
        cartA = CartFactory.createCart(customer,cartDateA);
        Assertions.assertNotNull(cartA);
        Assertions.assertEquals(cartDateA, cartA.getCreatedDate());
        System.out.println(cartA);
    }

    @Test
    @Order(2)
    void testCreateCart(){
        Customer customerb = new Customer();
        LocalDate cartDateB = LocalDate.of(2021, 8, 10);
        cartB = CartFactory.createCart(customerb,cartDateB);
        Assertions.assertNotNull(cartB);
        Assertions.assertEquals(cartDateB, cartB.getCreatedDate());
        System.out.println(cartB);
    }

}