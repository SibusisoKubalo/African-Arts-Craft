package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.repository.CartRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartService implements ICartService {

    private CartRepository cartRepository;

    @Autowired
    CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart create(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> read(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public Cart update(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void delete(Long userId) {
        cartRepository.deleteById(userId);
    }

    @Override
    public Set<Cart> getall() {
        return cartRepository.findAll().stream().collect(Collectors.toSet());

    }
}
