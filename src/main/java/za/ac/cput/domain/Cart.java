package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false)
    private long cartId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "created_Date", nullable = false)
    private LocalDate createdDate;

    public Cart() {}

    private Cart(Builder builder) {
        this.cartId = builder.cartId;
        //this.customer = builder.customer;
        this.createdDate = builder.createdDate;
    }

    public long getCartId() {
        return cartId;
    }

    public Customer getId() {
        return customer;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(cartId, cart.cartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId);
    }

    @Override
    public String toString() {
        return "Cart \n" +
                "cart ID = " + cartId + '\n'+
                //"customer ID = " + customer.getId() + '\n'+
                "createdDate = " + createdDate + '\n';
    }

    public static class Builder {
        private long cartId;
        //private Customer customer;
        private LocalDate createdDate;

        public Builder setcartId(long cartId) {
            this.cartId = cartId;
            return this;
        }
        /*
                public Builder setCustomer(Customer customer) {
                    this.customer = customer;
                    return this;
                }


         */
        public Builder setCreatedDate(LocalDate createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder copy(Cart cart) {
            this.cartId = cart.cartId;
            //this.customer = cart.customer;
            this.createdDate = cart.createdDate;
            return this;
        }
        public  Cart build(){
            return  new Cart(this);
        }
    }
}
