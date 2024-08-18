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

    @BeforeEach
    void setUp() {
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct("Jalapeno", "Red hot jalapeno", 50, imageUrl, 5, "Plant");
    }

    @Test
    @Order(1)
    void create() {
        Product createdProduct = productService.create(product);
        assertNotNull(createdProduct);
        assertEquals("Jalapeno", createdProduct.getName());
        System.out.println(createdProduct);
    }

    @Test
    @Order(2)
    void read() {
        Product createdProduct = productService.create(product);
        Product foundProduct = productService.read(createdProduct.getProductId());
        assertNotNull(foundProduct);
        assertEquals(createdProduct.getProductId(), foundProduct.getProductId());
        System.out.println(foundProduct);
    }

    @Test
    @Order(3)
    void update() {
        Product createdProduct = productService.create(product);
        Product updatedProduct = new Product.Builder()
                .copy(createdProduct)
                .setDescription("Yellow hot jalapeno")
                .build();
        Product updatedProductResult = productService.update(updatedProduct);
        assertNotNull(updatedProductResult);
        assertEquals("Yellow hot jalapeno", updatedProductResult.getDescription());
        System.out.println(updatedProductResult);
    }

    @Test
    @Order(4)
    void delete() {
        Product createdProduct = productService.create(product);
        boolean deleteProductResult = productService.delete(createdProduct.getProductId());
        assertTrue(deleteProductResult);
        System.out.println("Product deleted: " + deleteProductResult);
    }

    @Test
    @Order(5)
    void getAll() {
        productService.create(product);
        assertFalse(productService.getAll().isEmpty());
        System.out.println(productService.getAll());
    }
}
