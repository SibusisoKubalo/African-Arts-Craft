package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart_Items;
import za.ac.cput.domain.Products;
import za.ac.cput.repository.CartItemRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class CartItemService implements ICartItemService {

    private final CartItemRepository cartItemRepository;


    @Autowired
    public CartItemService(CartItemRepository cartItemsRepository) {
        this.cartItemRepository = cartItemsRepository;
    }

    @Override
    public Cart_Items create(Cart_Items cartItems) {
        return cartItemRepository.save(cartItems);
    }

    @Override
    public Cart_Items read(Long id) {
        Optional<Cart_Items> product = cartItemRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public Cart_Items update(Cart_Items cartItems) {
        return cartItemRepository.save(cartItems);
    }

    @Override
    public void delete(Long id) {
        cartItemRepository.deleteById(id);
    }


    @Override
    public List<Cart_Items> getAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public List<Cart_Items> getCartItemsByCartId(long cartId) {
        return cartItemRepository.findByCartId(cartId);
    }
   /* @Override
    public List<Cart_Items>getCartItemsByCartItemId(long cart_Item_Id){
        return cartItemRepository.findByCart_Item_Id(cart_Item_Id);}*/

    @Override
    public List<Cart_Items> getCartItemsByProductId(long productId) {
        return cartItemRepository.findByProductId(productId);
    }

    @Override
    public Cart_Items saveCartItem(Cart_Items cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

}
