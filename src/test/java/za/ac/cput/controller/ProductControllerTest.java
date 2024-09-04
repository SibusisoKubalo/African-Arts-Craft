package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.Products;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private Products product;

    @BeforeEach
    void setUp() {
        product = new Products.Builder()
                .setProductId(28)
                .setName("African head")
                .setDescription("This is a test product")
                .setPrice(10.99)
                .setStockQuantity(10)
                .setCategoryId(1)
                .setCreatedAt(LocalDate.now())
                .setUpdatedAt(LocalDate.now())
                .setImagePath("path/to/image.jpg")
                .build();
    }

    @Test
    void createProduct() {
        ResponseEntity<Products> response = restTemplate.postForEntity("/store/api/products", product, Products.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(product.getName(), response.getBody().getName());
    }

    @Test
    void getProductById() {
        Products createdProduct = restTemplate.postForObject("/store/api/products", product, Products.class);
        ResponseEntity<Products> response = restTemplate.getForEntity("/store/api/products/" + createdProduct.getProductId(), Products.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(createdProduct.getProductId(), response.getBody().getProductId());
    }

    @Test
    void updateProduct() {
        Products createdProduct = restTemplate.postForObject("/store/api/products", product, Products.class);
        createdProduct = new Products.Builder().copy(createdProduct).setName("Updated Product").build();
        HttpEntity<Products> requestUpdate = new HttpEntity<>(createdProduct);
        ResponseEntity<Products> response = restTemplate.exchange("/store/api/products", HttpMethod.PUT, requestUpdate, Products.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Updated Product", response.getBody().getName());
    }

    @Test
    void deleteProduct() {
        Products createdProduct = restTemplate.postForObject("/store/api/products", product, Products.class);
        restTemplate.delete("/store/api/products/" + createdProduct.getProductId());
        ResponseEntity<Products> response = restTemplate.getForEntity("/store/api/products/" + createdProduct.getProductId(), Products.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void getAllProducts() {
        restTemplate.postForObject("/store/api/products", product, Products.class);
        ResponseEntity<Products[]> response = restTemplate.getForEntity("/store/api/products", Products[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
    }

    @Test
    void getProductsByName() {
        restTemplate.postForObject("/store/api/products", product, Products.class);
        ResponseEntity<Products[]> response = restTemplate.getForEntity("/store/api/products/name/" + product.getName(), Products[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(product.getName(), response.getBody()[0].getName());
    }

    @Test
    void getProductsByCategoryId() {
        restTemplate.postForObject("/store/api/products", product, Products.class);
        ResponseEntity<Products[]> response = restTemplate.getForEntity("/store/api/products/category/" + product.getCategoryId(), Products[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(product.getCategoryId(), response.getBody()[0].getCategoryId());
    }

    @Test
    void getProductsByPriceRange() {
        restTemplate.postForObject("/store/api/products", product, Products.class);
        ResponseEntity<Products[]> response = restTemplate.getForEntity("/store/api/products/price-range?minPrice=10.00&maxPrice=11.00", Products[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody()[0].getPrice() >= 10.00 && response.getBody()[0].getPrice() <= 11.00);
    }

    @Test
    void getProductsByStockQuantityGreaterThan() {
        restTemplate.postForObject("/store/api/products", product, Products.class);
        ResponseEntity<Products[]> response = restTemplate.getForEntity("/store/api/products/stock-quantity-greater-than?stockQuantity=5", Products[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody()[0].getStockQuantity() > 5);
    }

    @Test
    void getProductsCreatedAfter() {
        restTemplate.postForObject("/store/api/products", product, Products.class);
        ResponseEntity<Products[]> response = restTemplate.getForEntity("/store/api/products/created-after?createdAt=" + LocalDate.now().minusDays(1), Products[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody()[0].getCreatedAt().isAfter(LocalDate.now().minusDays(1)));
    }

    @Test
    void getProductsUpdatedBefore() {
        restTemplate.postForObject("/store/api/products", product, Products.class);
        ResponseEntity<Products[]> response = restTemplate.getForEntity("/store/api/products/updated-before?updatedAt=" + LocalDate.now(), Products[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody()[0].getUpdatedAt().isBefore(LocalDate.now().plusDays(1)));
    }
}
