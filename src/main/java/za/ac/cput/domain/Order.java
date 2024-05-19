package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private long orderId;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "order_line")
    private String orderLine;

    protected Order() {}

    public Order(Builder builder) {
        this.orderId = builder.orderId;
        this.orderDate = builder.orderDate;
        this.totalAmount = builder.totalAmount;
        this.status = builder.status;
        this.orderLine = builder.orderLine;
    }

    // Getters
    public long getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public String getOrderLine() {
        return orderLine;
    }

    // Setters
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderLine(String orderLine) {
        this.orderLine = orderLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && Double.compare(order.totalAmount, totalAmount) == 0 && Objects.equals(orderDate, order.orderDate) && Objects.equals(status, order.status) && Objects.equals(orderLine, order.orderLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderDate, totalAmount, status, orderLine);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                ", orderLine='" + orderLine + '\'' +
                '}';
    }

    public static class Builder {
        private long orderId;
        private Date orderDate;
        private double totalAmount;
        private String status;
        private String orderLine;

        public Builder setOrderId(long orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setOrderDate(Date orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setOrderLine(String orderLine) {
            this.orderLine = orderLine;
            return this;
        }

        public Builder copy(Order order) {
            this.orderId = order.orderId;
            this.orderDate = order.orderDate;
            this.totalAmount = order.totalAmount;
            this.status = order.status;
            this.orderLine = order.orderLine;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
