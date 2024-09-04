package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart_Items;

import static org.junit.jupiter.api.Assertions.*;

class CartItemFactoryTest {

    @Test
    void buildCartItem() {

        Cart_Items cartItem = CartItemFactory.buildCartItem(012, 013, 014, 123);

        assertNotNull(cartItem);
        assertEquals(012, cartItem.getCart_item_id());
        assertEquals(013, cartItem.getCart_id());
        assertEquals(014, cartItem.getProduct_id());
        assertEquals(123, cartItem.getQuantity());
    }
}