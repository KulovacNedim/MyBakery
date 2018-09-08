package com.bakery.services;

import com.bakery.repository.ProductCategoryRepository;
import com.bakery.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductCategoriesServiceImpl implements ProductCategoriesService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> getAllCategories() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory getProductCategoryById(Long id) {
        return null;
    }

    @Override
    public ProductCategory getProductCategoryByName(String name) {
        return null;
    }

    @Override
    public ProductCategory saveProductCategory(ProductCategory productCategory) {
        return null;
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategory productCategory) {
        return null;
    }

    @Override
    public void deleteProductCategory(ProductCategory productCategory) {

    }
}
