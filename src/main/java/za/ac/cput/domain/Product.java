package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "price", nullable = false)
    private double price;

    @Lob
    @Column(name = "image_url")
    private byte[] imageUrl;


    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Objects.equals(productId, product.productId) && Objects.equals(productName, product.productName) && Objects.equals(productDescription, product.productDescription) && Arrays.equals(imageUrl, product.imageUrl);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productId, productName, productDescription, price);
        result = 31 * result + Arrays.hashCode(imageUrl);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", price=" + price +
                ", imageUrl=" + Arrays.toString(imageUrl) +
                '}';
    }

    private Product(Builder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.productDescription = builder.productDescription;
        this.price = builder.price;
        this.imageUrl = builder.imageUrl;
    }

    public static class Builder {
        private String productId;
        private String productName;
        private String productDescription;
        private double price;
        @Lob
        private byte[] imageUrl;

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setProductDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setImageUrl(byte[] imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder copy(Product products) {
            this.productId = products.productId;
            this.productName = products.productName;
            this.productDescription = products.productDescription;
            this.price = products.price;
            this.imageUrl = products.imageUrl;
            return this;

        }

        public Product build() {
            return new Product(this);
        }

    }


}
