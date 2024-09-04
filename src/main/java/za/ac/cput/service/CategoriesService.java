package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Categories;
import za.ac.cput.repository.CategoriesRepository;

import java.util.List;

/**
 * CategoriesService.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 30-Jul-24
 */

@Service
public class CategoriesService implements ICategoriesService {
    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }


    @Override
    public Categories create(Categories category) {
        return categoriesRepository.save(category);
    }

    @Override
    public Categories read(Long id) {
        return categoriesRepository.findById(id).orElse(null);
    }

    @Override
    public Categories update(Categories category) {
        if (this.categoriesRepository.existsById(category.getCategory_id()))
            return categoriesRepository.save(category);
        return null;
    }

    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }
}
