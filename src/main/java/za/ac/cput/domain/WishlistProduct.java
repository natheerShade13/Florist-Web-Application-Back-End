package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class WishlistProduct implements Serializable {

    @Id
    private long wishlistProductId;
    @ManyToOne
    @JoinColumn(name = "WISH_LIST_ID")
    private Wishlist wishlist;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    protected WishlistProduct() {}

    private WishlistProduct(Builder builder){
        this.wishlistProductId = builder.wishlistProductId;
        this.wishlist = builder.wishlist;
        this.product = builder.product;
    }

    public long getWishlistProductId() {
        return wishlistProductId;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishlistProduct that = (WishlistProduct) o;
        return wishlistProductId == that.wishlistProductId && Objects.equals(wishlist, that.wishlist) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wishlistProductId, wishlist, product);
    }

    @Override
    public String toString() {
        return "WishlistProduct{" +
                "wishlistProductId=" + wishlistProductId +
                ", wishlist=" + wishlist +
                ", product=" + product +
                '}';
    }

    public static class Builder {
        private long wishlistProductId;
        private Wishlist wishlist;
        private Product product;

        public Builder setWishlistProductId(long wishlistProductId) {
            this.wishlistProductId = wishlistProductId;
            return this;
        }

        public Builder setWishlist(Wishlist wishlist) {
            this.wishlist = wishlist;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder copy(WishlistProduct wishlistProduct){
            this.wishlistProductId = wishlistProduct.wishlistProductId;
            this.wishlist = wishlistProduct.wishlist;
            this.product = wishlistProduct.product;
            return this;
        }

        public WishlistProduct build(){return new WishlistProduct(this);}
    }
}
