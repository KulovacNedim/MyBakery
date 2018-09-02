package com.bakery.model;



import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "product_category_id", referencedColumnName = "product_category_id")
    private ProductCategory productCategory;

    @ManyToMany
    @JoinTable(
            name = "products_productscomponents",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "productcomponent_id", referencedColumnName = "productcomponent_id")
    )
    private Collection<ProductComponent> productcomponents;

    public Product() {
    }

    public Product(String name, double price, String description, String image) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public Product(String name, double price, String description, String image, ProductCategory productCategory, Collection<ProductComponent> productcomponents) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.productCategory = productCategory;
        this.productcomponents = productcomponents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setDescription(String description) {
        this.description = description;
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

    public Collection<ProductComponent> getProductcomponents() {
        return productcomponents;
    }

    public void setProductcomponents(Collection<ProductComponent> productcomponents) {
        this.productcomponents = productcomponents;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", productCategory=" + productCategory +
                ", productcomponents=" + productcomponents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(image, product.image) &&
                Objects.equals(productCategory, product.productCategory) &&
                Objects.equals(productcomponents, product.productcomponents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, image, productCategory, productcomponents);
    }
}
