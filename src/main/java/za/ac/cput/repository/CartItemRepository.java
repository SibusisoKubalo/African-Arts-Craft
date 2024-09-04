package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Cart_Items;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<Cart_Items, Long> {

    List<Cart_Items> findByCartId(long cartId);

    //List<Cart_Items> findByCart_Item_Id(long cart_Item_Id);

    List<Cart_Items> findByProductId(long product_id);
}
