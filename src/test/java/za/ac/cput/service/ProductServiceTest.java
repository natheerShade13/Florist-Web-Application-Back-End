package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    private static Product product;

    @Test
    @Order(0)
    void setUp() {
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct(1, "Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
    }

    @Test
    @Order(1)
    void create() {
        Product createProduct = productService.create(product);
        assertNotNull(createProduct);
        System.out.println(createProduct);
    }

    @Test
    @Order(2)
    void read() {
        Product findProduct = productService.read(product.getProductId());
        assertNotNull(findProduct);
        System.out.println(findProduct);
    }

    @Test
    @Order(3)
    void update() {
        Product newProduct = new Product.Builder().copy(product).setDescription("Yellow hot jalapeno").build();
        assertNotNull(newProduct);
        System.out.println(newProduct);
        Product updateProduct = productService.update(newProduct);
        assertNotNull(updateProduct);
        System.out.println(updateProduct);
    }

    @Test
    @Order(5)
    void delete() {
        boolean deleteProduct = productService.delete(product.getProductId());
        assertTrue(deleteProduct);
        System.out.println(deleteProduct);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(productService.getAll());
    }
}