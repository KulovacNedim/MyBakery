package com.bakery.services;

import com.bakery.model.ProductCategory;

import java.util.List;

public interface ProductCategoriesService {

    List<ProductCategory> getAllCategories();

    ProductCategory getProductCategoryById(Long id);

    ProductCategory getProductCategoryByName(String name);

    ProductCategory saveProductCategory(ProductCategory productCategory);

    ProductCategory updateProductCategory(ProductCategory productCategory);

    void deleteProductCategory(ProductCategory productCategory);

}
