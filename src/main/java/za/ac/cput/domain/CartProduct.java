package za.ac.cput.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class CartProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartProductId;

    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private int quantity;
    private double unitPrice;
    private double totalPrice;

    protected CartProduct() {}

    private CartProduct(Builder builder) {
        this.cartProductId = builder.cartProductId;
        this.cart = builder.cart;
        this.product = builder.product;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
        this.totalPrice = builder.totalPrice;
    }

    public long getCartProductId() {
        return cartProductId;
    }

    public Cart getCart() {
        return cart;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartProduct that = (CartProduct) o;
        return cartProductId == that.cartProductId && quantity == that.quantity
                && Double.compare(that.unitPrice, unitPrice) == 0
                && Double.compare(that.totalPrice, totalPrice) == 0
                && Objects.equals(cart, that.cart) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartProductId, cart, product, quantity, unitPrice, totalPrice);
    }

    @Override
    public String toString() {
        return "CartProduct{" +
                "cartProductId=" + cartProductId +
                ", cart=" + cart +
                ", product=" + product +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public static class Builder {
        private long cartProductId;
        private Cart cart;
        private Product product;
        private int quantity;
        private double unitPrice;
        private double totalPrice;

        public Builder setCartProductId(long cartProductId) {
            this.cartProductId = cartProductId;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder copy(CartProduct cartProduct) {
            this.cartProductId = cartProduct.cartProductId;
            this.cart = cartProduct.cart;
            this.product = cartProduct.product;
            this.quantity = cartProduct.quantity;
            this.unitPrice = cartProduct.unitPrice;
            this.totalPrice = cartProduct.totalPrice;
            return this;
        }

        public CartProduct build() {
            return new CartProduct(this);
        }
    }
}
