package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class CartFactoryTest {

    @Test
    void buildCart() {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");

        LocalDate startDate = LocalDate.parse("01-02-24", formatter);
        LocalDate endDate = LocalDate.parse("05-02-24", formatter);

        Cart cart = CartFactory.buildCart(1, 1001, startDate, endDate);


        assertEquals(1, cart.getCart_id());
        assertEquals(1001, cart.getUser_id());
        assertEquals(startDate, cart.getCreated_at());
        assertEquals(endDate, cart.getUpdated_at());
    }
}
