package model;

import java.util.Objects;

public class ProductCategory {

    private int productCategoryId;
    private String category;

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "productCategoryId=" + productCategoryId +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategory that = (ProductCategory) o;
        return getProductCategoryId() == that.getProductCategoryId() &&
                Objects.equals(getCategory(), that.getCategory());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getProductCategoryId(), getCategory());
    }
}
