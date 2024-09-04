package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import za.ac.cput.domain.Categories;
import za.ac.cput.repository.CategoriesRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CategoriesServiceTest {

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private CategoriesRepository categoriesRepository;

    private Categories category;

    @BeforeEach
    void setUp() {
        // Initialize a sample category
        category = new Categories.Builder()
                .setName("Electronics")
                .setDescription("Electronic items")
                .build();
    }

    @Test
    void create() {
        Categories savedCategory = categoriesService.create(category);
        assertNotNull(savedCategory);
        assertEquals(category.getName(), savedCategory.getName());
        assertEquals(category.getDescription(), savedCategory.getDescription());
    }

    @Test
    void read() {
        Categories savedCategory = categoriesService.create(category);
        Optional<Categories> foundCategory = Optional.ofNullable(categoriesService.read(savedCategory.getCategory_id()));
        assertTrue(foundCategory.isPresent());
        assertEquals(savedCategory.getName(), foundCategory.get().getName());
    }

    @Test
    void update() {
        Categories savedCategory = categoriesService.create(category);
        Categories updatedCategory = new Categories.Builder()
                .copy(savedCategory)
                .setDescription("Updated description")
                .build();
        Categories result = categoriesService.update(updatedCategory);
        assertEquals("Updated description", result.getDescription());
    }

    @Test
    void findAll() {
        categoriesService.create(category);
        List<Categories> categoriesList = categoriesService.findAll();

        assertFalse(categoriesList.isEmpty());
        assertTrue(categoriesList.stream().anyMatch(cat -> cat.getName().equals(category.getName())));
    }
}