package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Cart_Items;
import za.ac.cput.service.CartItemService;
import za.ac.cput.service.CartService;

import java.util.List;
import java.util.Set;
/*
Author: Masithembe Ndzotyana
Student Num:219145091
CartItemsController Class


 */

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;
    private final CartItemService cartItemService;

    @Autowired
    public CartController(CartService cartService, CartItemService cartItemService) {
        this.cartService = cartService;
        this.cartItemService = cartItemService;
    }

    // Cart Endpoints

    @PostMapping  //Will create a new cart
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart createdCart = cartService.create(cart);
        return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}") //Made to retreive cart for a user
    public ResponseEntity<List<Cart>> getCartsByUserId(@PathVariable Long userId) {
        List<Cart> carts = cartService.read(userId);
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @PutMapping //Updates a cart
    public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) {
        Cart updatedCart = cartService.update(cart);
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}") ///Deletes a cart by user ID.
    public ResponseEntity<Void> deleteCart(@PathVariable Long userId) {
        cartService.delete(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping //Retreives alla carts by the user IDs
    public ResponseEntity<Set<Cart>> getAllCarts() {
        Set<Cart> carts = cartService.getall();
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    // Cart Item Endpoints

    @PostMapping("/items") // Creates a new cart item
    public ResponseEntity<Cart_Items> createCartItem(@RequestBody Cart_Items cartItem) {
        Cart_Items createdCartItem = cartItemService.create(cartItem);
        return new ResponseEntity<>(createdCartItem, HttpStatus.CREATED);
    }

    @GetMapping("/items/{cartItemId}") // Retrieves a cart item by its ID
    public ResponseEntity<Cart_Items> getCartItemById(@PathVariable Long cartItemId) {
        Cart_Items cartItem = cartItemService.read(cartItemId);
        return new ResponseEntity<>(cartItem, HttpStatus.OK);
    }

    @PutMapping("/items") // Updates an existing cart item.
    public ResponseEntity<Cart_Items> updateCartItem(@RequestBody Cart_Items cartItem) {
        Cart_Items updatedCartItem = cartItemService.update(cartItem);
        return new ResponseEntity<>(updatedCartItem, HttpStatus.OK);
    }

    @DeleteMapping("/items/{cartItemId}") //Deletes a cart item by its ID
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long cartItemId) {
        cartItemService.delete(cartItemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/items") // Retrieves all cart items.
    public ResponseEntity<List<Cart_Items>> getAllCartItems() {
        List<Cart_Items> cartItems = cartItemService.getAll();
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @GetMapping("/items/cart/{cartId}") // Retrieves cart items by cart ID.
    public ResponseEntity<List<Cart_Items>> getCartItemsByCartId(@PathVariable Long cartId) {
        List<Cart_Items> cartItems = cartItemService.getCartItemsByCartId(cartId);
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @GetMapping("/items/product/{productId}") //Retrieves cart items by product ID.
    public ResponseEntity<List<Cart_Items>> getCartItemsByProductId(@PathVariable Long productId) {
        List<Cart_Items> cartItems = cartItemService.getCartItemsByProductId(productId);
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }
}

