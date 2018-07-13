package services;

import dao.ProductDAO;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDao;

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }
}
