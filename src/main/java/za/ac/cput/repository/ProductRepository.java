package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Products;

import java.time.LocalDate;
import java.util.List;

/**
 * ProductRepository.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    List<Products> findByName(String name);

    // Find products by category ID
    List<Products> findByCategoryId(long categoryId);

    // Find products by price range
    List<Products> findByPriceBetween(double minPrice, double maxPrice);

    // Find products by stock quantity greater than
    List<Products> findByStockQuantityGreaterThan(int stockQuantity);

    // Find products created after a certain date
    List<Products> findByCreatedAtAfter(LocalDate createdAt);

    // Find products updated before a certain date
    List<Products> findByUpdatedAtBefore(LocalDate updatedAt);
}
