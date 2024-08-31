package za.ac.cput.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;
    private double amount;
    private LocalDate orderDate;
    private String status;
    @ManyToOne //(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @OneToOne // @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COUPON_ID", nullable = true)
    private Coupon coupon;
    @OneToMany(mappedBy = "orders")
    @JsonManagedReference
    private List<OrderLine> orderLines;
    @OneToMany(mappedBy = "orders")
    private List<Payment> payments;

    protected Orders(){}

    private Orders(Builder builder){
        this.orderId = builder.orderId;
        this.amount = builder.amount;
        this.orderDate = builder.orderDate;
        this.status = builder.status;
        this.customer = builder.customer;
        this.coupon = builder.coupon;
    }

    public long getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public Orders setOrderId(long orderId) {
        this.orderId = orderId;
        return this;
    }

    public Orders setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public Orders setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public Orders setStatus(String status) {
        this.status = status;
        return this;
    }

    public Orders setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Orders setCoupon(Coupon coupon) {
        this.coupon = coupon;
        return this;
    }

    public Orders setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderId == orders.orderId && Double.compare(amount, orders.amount) == 0 && Objects.equals(orderDate, orders.orderDate) && Objects.equals(status, orders.status) && Objects.equals(customer, orders.customer) && Objects.equals(coupon, orders.coupon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, amount, orderDate, status, customer, coupon);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", amount=" + amount +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", customer=" + customer +
                ", coupon=" + coupon +
                '}';
    }

    public static class Builder{

        private long orderId;
        private double amount;
        private LocalDate orderDate;
        private String status;
        private Customer customer;
        private Coupon coupon;

        public Builder setOrderId(long orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setCoupon(Coupon coupon) {
            this.coupon = coupon;
            return this;
        }

        public Builder copy(Orders order){
            this.orderId = order.orderId;
            this.amount = order.amount;
            this.orderDate = order.orderDate;
            this.status = order.status;
            this.customer = order.customer;
            this.coupon = order.coupon;
            return this;
        }

        public Orders build(){return new Orders(this);}

    }

}
