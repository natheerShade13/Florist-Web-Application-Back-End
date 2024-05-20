package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {
    String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";

    @Test
    void buildProduct_A() {

        Product product = ProductFactory.buildProduct("8888", "Roses", "A woody  flowering plant of the genus Rosa", 25.00f, imageUrl);
        assertNotNull(product);
        System.out.println(product);
    }

    @Test
    void buildProductWithFailingData_B() {
        Product product = ProductFactory.buildProduct("", "Lilles", "A   flowering plant of the Lille Lone", 230.00f, imageUrl);
        assertNotNull(product);
        System.out.println(product);
    }


}