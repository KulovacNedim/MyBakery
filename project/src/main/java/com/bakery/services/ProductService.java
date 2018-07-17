package com.bakery.services;

import com.bakery.exceptions.ServiceException;
import com.bakery.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts() throws ServiceException;
    List<Product> getProductsByCategory(String category);
    Product getProductById(Long id) throws ServiceException;
    Product saveProduct(Product product) throws ServiceException;
    Product updateProduct(Product product) throws ServiceException;
    void deleteProduct(Product product) throws ServiceException;


}
