package za.ac.cput.service;

import za.ac.cput.domain.Cart_Items;

import java.util.List;

public interface ICartItemService {

    Cart_Items create(Cart_Items cartItems);

    Cart_Items read(Long id);

    Cart_Items update(Cart_Items cartItems);

    void delete(Long id);

    List<Cart_Items> getAll();

    List<Cart_Items> getCartItemsByCartId(long cartId);

    List<Cart_Items> getCartItemsByProductId(long productId);

    //List<Cart_Items> getCartItemsByUserId(long userId);

    Cart_Items saveCartItem(Cart_Items cartItem);

    void deleteCartItem(long cartItemId);
}
