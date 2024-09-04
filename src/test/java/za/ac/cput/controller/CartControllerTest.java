package za.ac.cput.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Cart_Items;
import za.ac.cput.service.CartItemService;
import za.ac.cput.service.CartService;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(CartController.class)
public class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CartService cartService;

    @Mock
    private CartItemService cartItemService;

    @InjectMocks
    private CartController cartController;

    @Autowired
    private ObjectMapper objectMapper;

    private Cart cart;
    private Cart_Items cartItem;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize test data
        LocalDate startDate = LocalDate.parse("2024-02-01");
        LocalDate endDate = LocalDate.parse("2024-02-05");

        cart = new Cart.Builder()
                .setCart_id(1)
                .setUser_id(1001)
                .setCreated_at(startDate)
                .setUpdated_at(endDate)
                .build();

        cartItem = new Cart_Items.Builder()
                .setCart_item_id(1)
                .setCart_id(1)
                .setProduct_id(200)
                .setQuantity(5)
                .build();

        mockMvc = MockMvcBuilders.standaloneSetup(cartController).build();
    }

    @Test
    void testCreateCart() throws Exception {
        when(cartService.create(any(Cart.class))).thenReturn(cart);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/carts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cart)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.cart_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.created_at").value("2024-02-01"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.updated_at").value("2024-02-05"))
                .andDo(print());

        verify(cartService, times(1)).create(any(Cart.class));
    }

    @Test
    void testGetCartsByUserId() throws Exception {
        List<Cart> carts = Collections.singletonList(cart);
        when(cartService.read(anyLong())).thenReturn(carts);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/carts/{userId}", 1001))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cart_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user_id").value(1001))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].created_at").value("2024-02-01"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].updated_at").value("2024-02-05"))
                .andDo(print());

        verify(cartService, times(1)).read(anyLong());
    }

    @Test
    void testUpdateCart() throws Exception {
        when(cartService.update(any(Cart.class))).thenReturn(cart);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/carts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cart)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.cart_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.created_at").value("2024-02-01"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.updated_at").value("2024-02-05"))
                .andDo(print());

        verify(cartService, times(1)).update(any(Cart.class));
    }

    @Test
    void testDeleteCart() throws Exception {
        doNothing().when(cartService).delete(anyLong());

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/carts/{userId}", 1001))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(print());

        verify(cartService, times(1)).delete(anyLong());
    }

    @Test
    void testGetAllCarts() throws Exception {
        List<Cart> carts = Collections.singletonList(cart);
        when(cartService.getall()).thenReturn(Collections.singleton(cart));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/carts"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cart_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user_id").value(1001))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].created_at").value("2024-02-01"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].updated_at").value("2024-02-05"))
                .andDo(print());

        verify(cartService, times(1)).getall();
    }

    @Test
    void testCreateCartItem() throws Exception {
        when(cartItemService.create(any(Cart_Items.class))).thenReturn(cartItem);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/carts/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cartItem)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.cart_item_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cart_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(5))
                .andDo(print());

        verify(cartItemService, times(1)).create(any(Cart_Items.class));
    }

    @Test
    void testGetCartItemById() throws Exception {
        when(cartItemService.read(anyLong())).thenReturn(cartItem);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/carts/items/{cartItemId}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.cart_item_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cart_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(5))
                .andDo(print());

        verify(cartItemService, times(1)).read(anyLong());
    }

    @Test
    void testUpdateCartItem() throws Exception {
        when(cartItemService.update(any(Cart_Items.class))).thenReturn(cartItem);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/carts/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cartItem)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.cart_item_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cart_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(5))
                .andDo(print());

        verify(cartItemService, times(1)).update(any(Cart_Items.class));
    }

    @Test
    void testDeleteCartItem() throws Exception {
        doNothing().when(cartItemService).delete(anyLong());

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/carts/items/{cartItemId}", 1))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(print());

        verify(cartItemService, times(1)).delete(anyLong());
    }

    @Test
    void testGetAllCartItems() throws Exception {
        List<Cart_Items> cartItems = Collections.singletonList(cartItem);
        when(cartItemService.getAll()).thenReturn(cartItems);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/carts/items"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cart_item_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cart_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].product_id").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].quantity").value(5))
                .andDo(print());

        verify(cartItemService, times(1)).getAll();
    }

    @Test
    void testGetCartItemsByCartId() throws Exception {
        List<Cart_Items> cartItems = Collections.singletonList(cartItem);
        when(cartItemService.getCartItemsByCartId(anyLong())).thenReturn(cartItems);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/carts/items/cart/{cartId}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cart_item_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cart_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].product_id").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].quantity").value(5))
                .andDo(print());

        verify(cartItemService, times(1)).getCartItemsByCartId(anyLong());
    }

    @Test
    void testGetCartItemsByProductId() throws Exception {
        List<Cart_Items> cartItems = Collections.singletonList(cartItem);
        when(cartItemService.getCartItemsByProductId(anyLong())).thenReturn(cartItems);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/carts/items/product/{productId}", 200))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cart_item_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cart_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].product_id").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].quantity").value(5))
                .andDo(print());

        verify(cartItemService, times(1)).getCartItemsByProductId(anyLong());
    }
}
