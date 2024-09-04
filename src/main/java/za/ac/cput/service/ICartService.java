package za.ac.cput.service;

import za.ac.cput.domain.Cart;

import java.util.List;
import java.util.Set;

public interface ICartService {
    Cart create(Cart cart);

    List<Cart> read(Long userId);

    Cart update(Cart cart);

    void delete(Long userId);


    Set<Cart> getall();
}
