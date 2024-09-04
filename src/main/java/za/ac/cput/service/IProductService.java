package za.ac.cput.service;

import za.ac.cput.domain.Products;

import java.time.LocalDate;
import java.util.List;

/**
 * IProductService.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 27-Jul-24
 */

public interface IProductService extends IService<Products, Long> {
    void delete(long id);

    List<Products> findByName(String name);

    List<Products> findByCategoryId(long categoryId);

    List<Products> findByPriceBetween(double minPrice, double maxPrice);

    List<Products> findByStockQuantityGreaterThan(int stockQuantity);

    List<Products> findByCreatedAtAfter(LocalDate createdAt);

    List<Products> findByUpdatedAtBefore(LocalDate updatedAt);
}