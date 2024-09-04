package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Cart_Items;
import za.ac.cput.service.CartItemService;

import java.util.List;
/*
Masithembe Ndzotyana
219145091
CartItemsController Class


 */

@RestController
@RequestMapping("/api/cart-items")
public class CartItemsController {

    private final CartItemService cartItemService;

    @Autowired
    public CartItemsController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/create")
    public ResponseEntity<Cart_Items> createCartItem(@RequestBody Cart_Items cartItem) {
        Cart_Items createdCartItem = cartItemService.create(cartItem);
        return new ResponseEntity<>(createdCartItem, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Cart_Items> readCartItem(@PathVariable Long id) {
        Cart_Items cartItem = cartItemService.read(id);
        return cartItem != null ? new ResponseEntity<>(cartItem, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Cart_Items> updateCartItem(@RequestBody Cart_Items cartItem) {
        Cart_Items updatedCartItem = cartItemService.update(cartItem);
        return new ResponseEntity<>(updatedCartItem, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        cartItemService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cart_Items>> getAllCartItems() {
        List<Cart_Items> cartItems = cartItemService.getAll();
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @GetMapping("/cart/{cartId}")
    public ResponseEntity<List<Cart_Items>> getCartItemsByCartId(@PathVariable long cartId) {
        List<Cart_Items> cartItems = cartItemService.getCartItemsByCartId(cartId);
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Cart_Items>> getCartItemsByProductId(@PathVariable long productId) {
        List<Cart_Items> cartItems = cartItemService.getCartItemsByProductId(productId);
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }
}
