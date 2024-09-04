package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Products;
import za.ac.cput.repository.ProductRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * ProductService.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */
@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Products create(Products products) {
        return productRepository.save(products);
    }

    @Override
    public Products read(Long id) {
        Optional<Products> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public Products update(Products products) {
        return productRepository.save(products);
    }

    @Override
    public List<Products> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Products> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Products> findByCategoryId(long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Products> findByPriceBetween(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Products> findByStockQuantityGreaterThan(int stockQuantity) {
        return productRepository.findByStockQuantityGreaterThan(stockQuantity);
    }

    @Override
    public List<Products> findByCreatedAtAfter(LocalDate createdAt) {
        return productRepository.findByCreatedAtAfter(createdAt);
    }

    @Override
    public List<Products> findByUpdatedAtBefore(LocalDate updatedAt) {
        return productRepository.findByUpdatedAtBefore(updatedAt);
    }
}
