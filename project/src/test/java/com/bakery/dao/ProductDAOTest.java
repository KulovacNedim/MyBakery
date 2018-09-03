package com.bakery.dao;

import com.bakery.AppConfig;
import com.bakery.model.Product;
import com.bakery.model.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@SpringBootTest
@Transactional
public class ProductDAOTest {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    private ProductCategory makeTestProductCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(20L);
        productCategory.setName("Test category");
        return productCategory;
    }
    private ProductCategory makeExistingProductCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(4L);
        productCategory.setName("Cookie");
        return productCategory;
    }

    private Product makeExistingProduct() {
        Product product = new Product();
        product.setId(12L);
        product.setDescription("Description for just Fortune cookie");
        product.setImagePath("productImage");
        product.setName("Fortune cookie");
        product.setPrice(3.5);
        product.setProductCategory(makeExistingProductCategory());

        return product;
    }
    private Product makeTestProduct() {
        Product product = new Product();
        product.setId(15L);
        product.setDescription("Description for Test product");
        product.setImagePath("testProductImage");
        product.setName("Test Product");
        product.setPrice(20.20);
        product.setProductCategory(makeTestProductCategory());

        return product;
    }
    private Product makeTestProduct(Long var) {
        Product product = new Product();

        product.setId(var);
        product.setDescription("Description for Test product " + var.toString());
        product.setImagePath("testProductImage" + var.toString());
        product.setName("Test Product " + var.toString());
        product.setPrice(var);
        product.setProductCategory(makeTestProductCategory());

        return product;
    }

    private Product makeTestProductWithExistingCategory(Long var) {
        Product product = new Product();

        product.setId(var);
        product.setDescription("Description for Test product " + var.toString());
        product.setImagePath("testProductImage" + var.toString());
        product.setName("Test Product " + var.toString());
        product.setPrice(var);
        product.setProductCategory(makeExistingProductCategory());

        return product;
    }
    private Product makeTestProductWithTestCategory(Long var) {
        Product product = makeTestProduct();
        product.setId(var);
        product.setProductCategory(makeTestProductCategory());
        return product;
    }

    //List of products with same category (category = Cookie)
    private List<Product> makeExistingProductList() {
        List<Product> products = new ArrayList<>();

        //Setting attributes for Afhhan biscuit
        Product product1 = new Product();
        product1.setId(10L);
        product1.setDescription("Description for just Afghan biscuit");
        product1.setImagePath("productImage");
        product1.setName("Afghan biscuit");
        product1.setPrice(3.5);
        product1.setProductCategory(makeExistingProductCategory());
        products.add(product1);

        //Setting attributes for Afhhan biscuit
        Product product2 = new Product();
        product2.setId(11L);
        product2.setDescription("Description for just Almond biscuit");
        product2.setImagePath("productImage");
        product2.setName("Almond biscuit");
        product2.setPrice(3.5);
        product2.setProductCategory(makeExistingProductCategory());
        products.add(product2);

        //Setting attributes for Afhhan biscuit
        Product product3 = new Product();
        product3.setId(12L);
        product3.setDescription("Description for just Fortune cookie");
        product3.setImagePath("productImage");
        product3.setName("Fortune cookie");
        product3.setPrice(3.5);
        product3.setProductCategory(makeExistingProductCategory());
        products.add(product3);

        return products;
    }

    private List<Product> makeTestProductListWithExistingCategory() {
        List<Product> products = new ArrayList<>();
        for (Long i = 17L; i <= 20 ; i++ ) {
            products.add(makeTestProductWithExistingCategory(i));
        }
        return products;
    }
    private List<Product> makeTestProductListWithTestCategory() {
        List<Product> products = new ArrayList<>();
        for (Long i = 17L; i <= 20 ; i++ ) {
            products.add(makeTestProductWithTestCategory(i));
        }
        return products;
    }

    @Test
    public void getProductById_idExists() {
        assertEquals(makeExistingProduct(), productDAO.findById(12L).get());
    }

    @Test
    public void getProductById_idDoesNotExists() {
        assertEquals(Optional.empty(), productDAO.findById(20L));
    }

    @Test
    public void getProductsByProductCategory_categoryExists() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("Cookie");
        productCategory.setId(4L);
        assertEquals(makeExistingProductList(), productDAO.getProductsByProductCategory(productCategory));
    }

    @Test
    public void getProductsByProductCategory_categoryDoesNotExists() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(7L);
        productCategory.setName("Test category");
        assertEquals(0, productDAO.getProductsByProductCategory(productCategory).size());
    }

    @Test
    public void getAllProducts() {
        assertEquals(14, productDAO.findAll().size());
    }

    @Test
    public void saveTestProduct() {
        Product product = makeTestProduct(20L);
        Product savedProduct = productDAO.save(product);
        Product getSavedProduct = productDAO.findById(savedProduct.getId()).get();

        assertEquals(savedProduct, getSavedProduct);
    }

    @Test
    public void saveTestProduct_checkCategory() {
        Product product = makeTestProduct(20L);
        Product savedProduct = productDAO.save(product);
        ProductCategory productCategory = savedProduct.getProductCategory();
        ProductCategory getSavedProductCategory = productCategoryDAO.findById(productCategory.getId()).get();

        assertEquals(productCategory, getSavedProductCategory);
    }

    @Test
    public void saveExistingProduct() {
        Product product = makeExistingProduct();
        product.setName("Test name");
        assertEquals(product, productDAO.save(product));
    }

    @Test
    public void saveAllTestProductsWithExistingCategory() {
        List<Product> products = makeTestProductListWithExistingCategory();
        List<Product> savedProducts = productDAO.saveAll(products);
        for (Product product : products) {
            product.setId(1L);
        }
        for (Product product : savedProducts) {
            product.setId(1L);
        }
        assertEquals(products, savedProducts);
    }

    @Test
    public void saveAllTestProductsWithTestCategory() {
        List<Product> products = makeTestProductListWithTestCategory();
        List<Product> savedProducts = productDAO.saveAll(products);

        for (Product product : products) {
            product.setId(1L);
        }
        for (Product product : savedProducts) {
            product.setId(1L);
        }

        assertEquals(products, savedProducts);
    }

    @Test
    public void deleteExistingProduct() {
        Product product = makeExistingProduct();
        //Delete product
        productDAO.delete(product);

        //Check if it is still there
        assertEquals(Optional.empty(), productDAO.findById(product.getId()));
    }

    @Test
    public void deleteNonExistingProduct() {
        Product product = makeTestProduct();

        //Delete product
        productDAO.delete(product);

        assertEquals(Optional.empty(), productDAO.findById(product.getId()));
    }

    @Test
    public void deleteAllProducts() {
        //Delete all products
        productDAO.deleteAll();

        //Check if there is products in DB
        assertEquals(0, productDAO.findAll().size());
    }



}
