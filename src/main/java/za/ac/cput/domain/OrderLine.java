package za.ac.cput.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderLineId;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    @JsonBackReference
    private Orders orders;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    private int quantity;
    private double quotedPrice;

    protected OrderLine(){}

    private OrderLine(Builder builder){
        this.orderLineId = builder.orderLineId;
        this.orders = builder.orders;
        this.product = builder.product;
        this.quantity = builder.quantity;
        this.quotedPrice = builder.quotedPrice;
    }

    public long getOrderLineId() {
        return orderLineId;
    }

    public Orders getOrders() {
        return orders;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getQuotedPrice() {
        return quotedPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return orderLineId == orderLine.orderLineId && quantity == orderLine.quantity && Double.compare(quotedPrice, orderLine.quotedPrice) == 0 && Objects.equals(orders, orderLine.orders) && Objects.equals(product, orderLine.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderLineId, orders, product, quantity, quotedPrice);
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "orderLineId=" + orderLineId +
                ", orders=" + orders +
                ", product=" + product +
                ", quantity=" + quantity +
                ", quotedPrice=" + quotedPrice +
                '}';
    }

    public static class Builder{

        private long orderLineId;
        private Orders orders;
        private Product product;
        private int quantity;
        private double quotedPrice;

        public Builder setOrderLineId(long orderLineId) {
            this.orderLineId = orderLineId;
            return this;
        }

        public Builder setOrders(Orders orders) {
            this.orders = orders;
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

        public Builder setQuotedPrice(double quotedPrice) {
            this.quotedPrice = quotedPrice;
            return this;
        }

        public Builder copy(OrderLine orderLine){
            this.orderLineId = orderLine.orderLineId;
            this.orders = orderLine.orders;
            this.product = orderLine.product;
            this.quantity = orderLine.quantity;
            this.quotedPrice = orderLine.quotedPrice;
            return this;
        }

        public OrderLine build(){return new OrderLine(this);}

    }

}
