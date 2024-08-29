package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {

    private Product productA;
    private Product productB;

    @Test
    void buildProduct() {
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        productA = ProductFactory.buildProduct("Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        assertNotNull(productA);
        System.out.println(productA);
    }

    @Test
    void buildProductFail() {
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        productB = ProductFactory.buildProduct( "Jalapeno", "Red hot jalapeno"
                , 0, imageUrl, 5, "Plant");
        assertNotNull(productB);
        System.out.println(productB);
    }

}