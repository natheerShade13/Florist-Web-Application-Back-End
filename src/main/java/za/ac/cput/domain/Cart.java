package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Cart {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;
    @OneToOne
    @JoinColumn(name = "CUS_ID")
    private Customer customer;
    @OneToMany(mappedBy = "cart")
    private List<CartProduct> cartProducts;

    protected Cart(){}

    private Cart(Builder builder){
        this.cartId = builder.cartId;
        this.customer = builder.customer;
    }

    public long getCartId() {
        return cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return cartId == cart.cartId && Objects.equals(customer, cart.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, customer);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", customer=" + customer +
                '}';
    }

    public static class Builder{

        private long cartId;
        private Customer customer;

        public Builder setCartId(long cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder copy(Cart cart){
            this.cartId = cart.cartId;
            this.customer = cart.customer;
            return this;
        }

        public Cart build(){return new Cart(this);}

    }

}
