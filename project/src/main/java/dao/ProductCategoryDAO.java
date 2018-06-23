package dao;

import model.Product;
import model.ProductCategory;

import java.util.ArrayList;

public interface ProductCategoryDAO {

    ProductCategory getProductCategoryById(int id);
    ProductCategory getProductCategoryByCategoryName(String category);
    ArrayList<ProductCategory> getAllProductCategories();
    boolean addProductCategory(ProductCategory productCategory);
    boolean deleteProductCategory(ProductCategory productCategory);
    boolean updateProductCategory(ProductCategory productCategory);

}
