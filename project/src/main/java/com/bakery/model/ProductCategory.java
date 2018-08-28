package com.bakery.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product_categories")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productCategoryId")
    private Long productCategoryId;

    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.REMOVE)
    private List<Product> products;

    public ProductCategory() {
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "productCategoryId=" + productCategoryId +
                ", category='" + category + '\'' +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategory that = (ProductCategory) o;
        return Objects.equals(productCategoryId, that.productCategoryId) &&
                Objects.equals(category, that.category) &&
                Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCategoryId, category, products);
    }
}
