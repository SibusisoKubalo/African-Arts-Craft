package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.factory.CartFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CartServiceTest {
    @Autowired
    private CartService service;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");

    LocalDate startDate = LocalDate.parse("01-02-24", formatter);
    LocalDate endDate = LocalDate.parse("05-02-24", formatter);

    private Cart cart = CartFactory.buildCart(1, 001, startDate, endDate);


    @Test
    void a_create() {
        Cart created = service.create(cart);
        assertNotNull(created);
        System.out.println(created);

    }

    @Test
    void b_read() {
        List<Cart> read = service.read(cart.getCart_id());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Cart newCart = new Cart.Builder().copy(cart).setCart_id(0002).build();
        Cart updated = service.update(newCart);
        assertNotNull(updated);
        System.out.println(updated);

    }

    @Test
    void d_delete() {
        service.delete(cart.getCart_id());
        System.out.println("cart deleted");
    }

    @Test
    void e_getall() {
        System.out.println(service.getall());
    }
}