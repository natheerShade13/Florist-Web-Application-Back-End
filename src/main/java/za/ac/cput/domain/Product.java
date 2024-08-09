package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Product {

    @Id
    private long productId;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private int stockQuantity;
    //@ManyToOne
    //@JoinColumn(name = "CATEGORY_ID")
    private String category;
    @OneToMany(mappedBy = "product")
    private List<OrderLine> orderLines;
    @OneToMany(mappedBy = "product" /*, cascade = CascadeType.PERSIST*/)
    private List<SupplierProduct> supplierProducts;
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
    @OneToMany(mappedBy = "product")
    private List<CartProduct> cartProducts;

    protected Product(){}

    private Product(Builder builder){
        this.productId = builder.productId;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
        this.imageUrl = builder.imageUrl;
        this.category = builder.category;
    }

    public long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Double.compare(price, product.price) == 0 && stockQuantity == product.stockQuantity && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(imageUrl, product.imageUrl) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, description, price, imageUrl, stockQuantity, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", category='" + category + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public static class Builder{

        private long productId;
        private String name;
        private String description;
        private double price;
        private String imageUrl;
        private int stockQuantity;
        private String category;

        public Builder setProductId(long productId) {
            this.productId = productId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder copy(Product product) {
            this.productId = product.productId;
            this.name = product.name;
            this.description = product.description;
            this.price = product.price;
            this.stockQuantity = product.stockQuantity;
            this.imageUrl = product.imageUrl;
            this.category = product.category;
            return this;

        }

        public Product build() {
            return new Product(this);
        }

    }

}
