package com.bakery.model;

import javax.persistence.*;
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

    public ProductCategory() {
    }

    public ProductCategory(String category) {
        this.category = category;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategory that = (ProductCategory) o;
        return Objects.equals(getProductCategoryId(), that.getProductCategoryId()) &&
                Objects.equals(getCategory(), that.getCategory());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getProductCategoryId(), getCategory());
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "productCategoryId=" + productCategoryId +
                ", category='" + category + '\'' +
                '}';
    }
}
