package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "order_line")
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_line_id", nullable = false)
    private long orderLineId;

    @Column(name = "item", nullable = false)
    private String item;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private double price;

    protected OrderLine(){}

    public OrderLine(Builder builder){
        this.orderLineId = builder.orderLineId;
        this.item = builder.item;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

    public long getOrderLineId() {
        return orderLineId;
    }

    public String getItem() {
        return item;
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
        OrderLine orderLine = (OrderLine) o;
        return orderLineId == orderLine.orderLineId && quantity == orderLine.quantity && Double.compare(orderLine.price, price) == 0 && Objects.equals(item, orderLine.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderLineId, item, quantity, price);
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "orderLineId=" + orderLineId +
                ", item='" + item + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public static class Builder{
        private long orderLineId;
        private String item;
        private int quantity;
        private double price;

        public Builder setOrderLineId(long orderLineId) {
            this.orderLineId = orderLineId;
            return this;
        }

        public Builder setItem(String item) {
            this.item = item;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder copy(OrderLine orderLine){
            this.orderLineId = orderLine.orderLineId;
            this.item = orderLine.item;
            this.quantity = orderLine.quantity;
            this.price = orderLine.price;
            return this;
        }

        public OrderLine build(){return new OrderLine(this);}
    }
}
