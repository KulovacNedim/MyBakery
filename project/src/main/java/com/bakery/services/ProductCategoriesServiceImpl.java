package com.bakery.services;

import com.bakery.dao.ProductCategoryDAO;
import com.bakery.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoriesServiceImpl implements ProductCategoriesService {

    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @Override
    public List<ProductCategory> getAllCategories() {
        return productCategoryDAO.findAll();
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
