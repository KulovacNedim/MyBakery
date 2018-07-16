package com.bakery.services;

import com.bakery.dao.ProductCategoryDAO;
import com.bakery.exceptions.ErrorCode;
import com.bakery.exceptions.ServiceException;
import com.bakery.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoriesServiceImpl implements ProductCategoriesService{

    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @Override
    public List<ProductCategory> getAllCategories() throws ServiceException {
        try {
            return productCategoryDAO.findAll();
        }
        catch (Exception e) {
            throw new ServiceException(e, ErrorCode.GET_PRODUCT_CATEGORY_ERROR);
        }
    }

    @Override
    public ProductCategory getProductCategoryById(Long id) throws ServiceException {
        try {
            return productCategoryDAO.findById(id).get();
        }
        catch (Exception e) {
            throw new ServiceException(e, ErrorCode.PRODUCT_CATEGORY_NOT_FOUND);
        }
    }

    @Override
    public ProductCategory getProductCategoryByName(String name) throws ServiceException {
        try {
            return productCategoryDAO.getProductCategoryByCategory(name);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.PRODUCT_CATEGORY_NOT_FOUND);
        }
    }

    @Override
    public ProductCategory saveProductCategory(ProductCategory productCategory) throws ServiceException {
        try {
            return productCategoryDAO.save(productCategory);
        }
        catch (Exception e) {
            throw new ServiceException(e, ErrorCode.SAVE_PRODUCT_CATEGORY_ERROR);
        }
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategory productCategory) throws ServiceException {
        try {
            return productCategoryDAO.save(productCategory);
        }
        catch (Exception e) {
            throw new ServiceException(e, ErrorCode.UPDATE_PRODUCT_CATEGORY_ERROR);
        }
    }

    @Override
    public void deleteProductCategory(ProductCategory productCategory) throws ServiceException {
        try {
            productCategoryDAO.delete(productCategory);
        }
        catch (Exception e) {
            throw new ServiceException(e, ErrorCode.DELETE_PRODUCT_CATEGORY_ERROR);
        }
    }
}
