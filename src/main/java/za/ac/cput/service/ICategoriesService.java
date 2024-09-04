package za.ac.cput.service;

import za.ac.cput.domain.Categories;

import java.util.List;

/**
 * ICategoriesService.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 30-Jul-24
 */

public interface ICategoriesService extends IService<Categories, Long> {
    List<Categories> findAll();
}
