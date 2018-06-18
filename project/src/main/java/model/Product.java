package model;

import java.util.ArrayList;
import java.util.Objects;

public class Product {

    private int productId;
    private String name;
    private double price;
    private String description;
    private String image;
    private ProductCategory productCategory;
    private ArrayList<Ingredient> ingredients;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", productCategory=" + productCategory +
                ", ingredients=" + ingredients +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getProductId() == product.getProductId() &&
                Double.compare(product.getPrice(), getPrice()) == 0 &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getDescription(), product.getDescription()) &&
                Objects.equals(getImage(), product.getImage()) &&
                Objects.equals(getProductCategory(), product.getProductCategory()) &&
                Objects.equals(getIngredients(), product.getIngredients());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getProductId(), getName(), getPrice(), getDescription(), getImage(), getProductCategory(), getIngredients());
    }
}
