package com.bakery.services;

import com.bakery.dao.ProductDAO;
import com.bakery.exceptions.ErrorCode;
import com.bakery.exceptions.ServiceException;
import com.bakery.model.Product;
import com.bakery.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductCategoriesService productCategoriesService;

    @Override
    public List<Product> getAllProducts() throws ServiceException {
        try {
            return productDAO.findAll();
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.GET_PRODUCTS_ERROR);
        }
    }

    @Override
    public Product getProductById(Long id) throws ServiceException {
        try {
            return productDAO.findById(id).get();
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.PRODUCT_NOT_FOUND);
        }
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        try {
            ProductCategory productCategory = productCategoriesService.getProductCategoryByName(category);
            return productDAO.getProductsByProductCategory(productCategory);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.GET_PRODUCTS_ERROR);
        }
    }

    @Override
    public Product saveProduct(Product product) throws ServiceException {
        try {
            return productDAO.save(product);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.SAVE_PRODUCT_ERROR);
        }
    }

    @Override
    public Product updateProduct(Product product) throws ServiceException {
        try {
            return productDAO.save(product);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.UPDATE_PRODUCT_ERROR);
        }
    }

    @Override
    public void deleteProduct(Product product) throws ServiceException {
        try {
            productDAO.delete(product);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.DELETE_PRODUCT_ERROR);
        }
    }
}
