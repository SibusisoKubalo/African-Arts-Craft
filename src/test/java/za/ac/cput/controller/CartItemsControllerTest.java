package za.ac.cput.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import za.ac.cput.domain.Cart_Items;
import za.ac.cput.service.CartItemService;

import java.util.Arrays;
import java.util.List;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
Masithembe Ndzotyana
219145091
CartItemsControllerTest Class


 */

@WebMvcTest(CartItemsController.class)
public class CartItemsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartItemService cartItemService;

    private Cart_Items cartItem;

    @BeforeEach
    void setUp() {
        cartItem = new Cart_Items.Builder()
                .setCart_item_id(1)
                .setCart_id(100)
                .setProduct_id(200)
                .setQuantity(5)
                .build();
    }

    @Test
    void createCartItem() throws Exception {
        Mockito.when(cartItemService.create(Mockito.any(Cart_Items.class))).thenReturn(cartItem);

        mockMvc.perform((RequestBuilder) post("/api/cart-items/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.valueOf(new ObjectMapper().writeValueAsString(cartItem))))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.cart_item_id").value(1))
                .andExpect(jsonPath("$.cart_id").value(100))
                .andExpect(jsonPath("$.product_id").value(200))
                .andExpect(jsonPath("$.quantity").value(5));
    }

    @Test
    void readCartItem() throws Exception {
        Mockito.when(cartItemService.read(1L)).thenReturn(cartItem);

        mockMvc.perform(get("/api/cart-items/read/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cart_item_id").value(1))
                .andExpect(jsonPath("$.cart_id").value(100))
                .andExpect(jsonPath("$.product_id").value(200))
                .andExpect(jsonPath("$.quantity").value(5));
    }

    @Test
    void updateCartItem() throws Exception {
        Mockito.when(cartItemService.update(Mockito.any(Cart_Items.class))).thenReturn(cartItem);

        mockMvc.perform((RequestBuilder) put("/api/cart-items/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.valueOf(new ObjectMapper().writeValueAsString(cartItem))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cart_item_id").value(1))
                .andExpect(jsonPath("$.cart_id").value(100))
                .andExpect(jsonPath("$.product_id").value(200))
                .andExpect(jsonPath("$.quantity").value(5));
    }

    @Test
    void deleteCartItem() throws Exception {
        Mockito.doNothing().when(cartItemService).delete(1L);

        mockMvc.perform(delete("/api/cart-items/delete/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void getAllCartItems() throws Exception {
        List<Cart_Items> cartItems = Arrays.asList(cartItem);
        Mockito.when(cartItemService.getAll()).thenReturn(cartItems);

        mockMvc.perform(get("/api/cart-items/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].cart_item_id").value(1))
                .andExpect(jsonPath("$[0].cart_id").value(100))
                .andExpect(jsonPath("$[0].product_id").value(200))
                .andExpect(jsonPath("$[0].quantity").value(5));
    }

    @Test
    void getCartItemsByCartId() throws Exception {
        List<Cart_Items> cartItems = Arrays.asList(cartItem);
        Mockito.when(cartItemService.getCartItemsByCartId(100L)).thenReturn(cartItems);

        mockMvc.perform(get("/api/cart-items/cart/100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].cart_item_id").value(1))
                .andExpect(jsonPath("$[0].cart_id").value(100))
                .andExpect(jsonPath("$[0].product_id").value(200))
                .andExpect(jsonPath("$[0].quantity").value(5));
    }

    @Test
    void getCartItemsByProductId() throws Exception {
        List<Cart_Items> cartItems = Arrays.asList(cartItem);
        Mockito.when(cartItemService.getCartItemsByProductId(200L)).thenReturn(cartItems);

        mockMvc.perform(get("/api/cart-items/product/200"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].cart_item_id").value(1))
                .andExpect(jsonPath("$[0].cart_id").value(100))
                .andExpect(jsonPath("$[0].product_id").value(200))
                .andExpect(jsonPath("$[0].quantity").value(5));
    }
}

