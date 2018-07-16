package com.bakery.services;

import com.bakery.exceptions.ServiceException;
import com.bakery.model.Product;
import com.bakery.model.ProductCategory;

import java.util.List;

public interface ProductCategoriesService {

    List<ProductCategory> getAllCategories() throws ServiceException;
    ProductCategory getProductCategoryById(Long id) throws ServiceException;
    ProductCategory getProductCategoryByName(String name) throws ServiceException;
    ProductCategory saveProductCategory(ProductCategory productCategory) throws ServiceException;
    ProductCategory updateProductCategory(ProductCategory productCategory) throws ServiceException;
    void deleteProductCategory(ProductCategory productCategory) throws ServiceException;

}
