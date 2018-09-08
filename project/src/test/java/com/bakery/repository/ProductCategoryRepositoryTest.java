package com.bakery.repository;

import com.bakery.AppConfig;
import com.bakery.model.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@SpringBootTest
@Transactional
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void getProductCategoryByCategory_categoryExists() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("Bread");
        productCategory.setId(1L);

        assertEquals(productCategory, productCategoryRepository.getProductCategoryByName("Bread"));
    }

    @Test
    public void getProductCategoryByCategory_categoryDoesNotExists() {

        assertEquals(null, productCategoryRepository.getProductCategoryByName("TestCategory"));
    }

    @Test
    public void getAllProductCategories() {
        assertEquals(5, productCategoryRepository.findAll().size());
    }

    @Test
    public void getProductCategoryById_idExists() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(1L);
        productCategory.setName("Bread");

        assertEquals(productCategory, productCategoryRepository.findById(1L).get());
    }

    @Test
    public void getProductCategoryById_idDoesNotExists() {
        assertEquals(Optional.empty(), productCategoryRepository.findById(6L));
    }

    @Test
    public void saveProductCategory() {
        ProductCategory productCategory = new ProductCategory("TestCategory");
        ProductCategory productCategoryCheck = new ProductCategory("TestCategory");

        assertEquals(productCategoryCheck.getName(), productCategoryRepository.save(productCategory).getName());
    }

    @Test
    public void saveAllProductCategoriesThatArentExisting() {
        List<ProductCategory> productCategories = new ArrayList<>();
        //Add 3 categories
        productCategories.add(new ProductCategory("Test category 1"));
        productCategories.add(new ProductCategory("Test category 2"));
        productCategories.add(new ProductCategory("Test category 3"));

        assertEquals(productCategories, productCategoryRepository.saveAll(productCategories));
    }

    @Test
    public void saveAllProductCategoriesThatAreExisting() {
        List<ProductCategory> productCategories = new ArrayList<>();

        //Add existing product categories with category changed (ID is same)
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setId(1L);
        productCategory1.setName("Test Category 1");
        productCategories.add(productCategory1);

        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setId(2L);
        productCategory2.setName("Test Category 2");
        productCategories.add(productCategory2);

        ProductCategory productCategory3 = new ProductCategory();
        productCategory3.setId(3L);
        productCategory3.setName("Test Category 2");
        productCategories.add(productCategory3);

        //Save categories
        assertEquals(productCategories, productCategoryRepository.saveAll(productCategories));
    }

    @Test
    public void deleteProductCategoryById() {
        ProductCategory productCategory = productCategoryRepository.getProductCategoryByName("Sandwich");

        //Delete product category
        productCategoryRepository.delete(productCategory);

        //Check if is still there
        assertEquals(Optional.empty(), productCategoryRepository.findById(3L));
    }

    @Test
    public void deleteProductCategory_checkProducts(){
        ProductCategory productCategory = productCategoryRepository.getProductCategoryByName("Sandwich");

        productCategoryRepository.delete(productCategory);

        assertEquals(0, productRepository.getProductsByProductCategory(productCategory).size());
    }

    @Test
    public void deleteAllProductCategories() {
        //Delete all product categories
        productCategoryRepository.deleteAll();

        //Check if there are any product categories
        assertEquals(0, productCategoryRepository.findAll().size());
    }
}
