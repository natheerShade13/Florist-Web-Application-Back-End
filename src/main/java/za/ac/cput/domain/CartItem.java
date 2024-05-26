package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartItem_id", nullable = false)
    private long cartItemId;

    @OneToOne
    @JoinColumn(name = "Cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    public CartItem() {
    }

    private CartItem(Builder builder) {
        this.cartItemId = builder.cartItemId;
        //this.cart = builder.cart;
        //this.product = builder.product;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

    // Getters
    public long getCartItemId() {
        return cartItemId;
    }

    public Cart getCartId() {
        return cart;
    }

    public Product getProductId() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(cartItemId, cartItem.cartItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartItemId);
    }

    @Override
    public String toString() {
        return "CartItem\n" +
                "cartItem ID = " + cartItemId + '\n'+
                //"Cart ID = " + cart.getCartId() + '\n'+
                //"Product ID = " + product.getProductId() + '\n'+
                "Quantity = " + quantity + '\n'+
                "Price = " + price;
    }

    public static class Builder {
        private long cartItemId;
        //private Cart cart;
        //private Product product;
        private int quantity;
        private double price;

        public Builder setCartItemId(long cartItemId) {
            this.cartItemId = cartItemId;
            return this;
        }
/*
        public Builder setcart(Cart cart) {
            this.cart = cart;
            return this;
        }
        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

 */

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder copy(CartItem cartItem) {
            this.cartItemId = cartItem.cartItemId;
            //this.cart = cartItem.cart;
            //this.product = cartItem.product;
            this.quantity = cartItem.quantity;
            this.price = cartItem.price;
            return this;
        }
        public CartItem build() {
            return new CartItem(this);
        }
    }
}
