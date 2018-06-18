package dao;

import model.Product;
import model.ProductCategory;

import java.util.ArrayList;


public interface ProductDAO {

    Product getProductById(int id);
    ArrayList<Product> getAllProducts();
    ArrayList<Product> getAllProductByCategory(ProductCategory productCategory);
    boolean addProduct(Product product);
    boolean deleteProduct(Product product);
    boolean updateProduct(Product product);

}
