package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;
    private LocalDate dateCreated;
    @OneToOne
    @JoinColumn(name = "CUS_ID")
    private Customer customer;
    @OneToMany(mappedBy = "cart")
    private List<CartProduct> cartProducts;

    protected Cart(){}

    private Cart(Builder builder){
        this.cartId = builder.cartId;
        this.dateCreated = builder.dateCreated;
        this.customer = builder.customer;
    }

    public long getCartId() {
        return cartId;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return cartId == cart.cartId && Objects.equals(dateCreated, cart.dateCreated) && Objects.equals(customer, cart.customer) && Objects.equals(cartProducts, cart.cartProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, dateCreated, customer, cartProducts);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", dateCreated=" + dateCreated +
                ", customer=" + customer +
                '}';
    }

    public static class Builder{

        private long cartId;
        private LocalDate dateCreated;
        private Customer customer;

        public Builder setCartId(long cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder setDateCreated(LocalDate dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder copy(Cart cart){
            this.cartId = cart.cartId;
            this.dateCreated = cart.dateCreated;
            this.customer = cart.customer;
            return this;
        }

        public Cart build(){return new Cart(this);}

    }

}
