package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Wishlist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long wishListId;
    private LocalDate dateCreated;
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @OneToMany(mappedBy = "wishlist")
    private List<WishlistProduct> wishlistProducts;

    protected Wishlist(){}

    private Wishlist(Builder builder) {
        this.wishListId = builder.wishListId;
        this.dateCreated = builder.dateCreated;
        this.customer = builder.customer;
    }

    public long getWishListId() {
        return wishListId;
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
        Wishlist wishlist = (Wishlist) o;
        return wishListId == wishlist.wishListId && Objects.equals(dateCreated, wishlist.dateCreated) && Objects.equals(customer, wishlist.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wishListId, dateCreated, customer);
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "wishListId=" + wishListId +
                ", dateCreated=" + dateCreated +
                ", customer=" + customer +
                '}';
    }

    public static class Builder{
        private long wishListId;
        private LocalDate dateCreated;
        private Customer customer;

        public Builder setWishListId(long wishListId) {
            this.wishListId = wishListId;
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

        public Builder copy(Wishlist wishlist){
            this.wishListId = wishlist.wishListId;
            this.dateCreated = wishlist.dateCreated;
            this.customer = wishlist.customer;
            return this;
        }

        public Wishlist build(){return new Wishlist(this);}

    }

}
