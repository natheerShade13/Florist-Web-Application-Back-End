package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Payment {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentId;
    private LocalDate paymentDate;
    private String paymentMethod;
    private double paymentAmount;
    @ManyToOne
    @JoinColumn(name = "ORDERS_ID")
    private Orders orders;

    protected Payment() {}

    private Payment(Builder builder){

    }

    public long getPaymentId() {
        return paymentId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public Orders getOrder() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return paymentId == payment.paymentId && Double.compare(paymentAmount, payment.paymentAmount) == 0 && Objects.equals(paymentDate, payment.paymentDate) && Objects.equals(paymentMethod, payment.paymentMethod) && Objects.equals(orders, payment.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, paymentDate, paymentMethod, paymentAmount, orders);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", order=" + orders +
                '}';
    }

    public static class Builder {
        private long paymentId;
        private LocalDate paymentDate;
        private String paymentMethod;
        private double paymentAmount;
        private Orders orders;

        public Builder setPaymentId(long paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setPaymentAmount(double paymentAmount) {
            this.paymentAmount = paymentAmount;
            return this;
        }

        public Builder setOrder(Orders orders) {
            this.orders = orders;
            return this;
        }

        public Builder copy(Payment payment){
            this.paymentId = payment.paymentId;
            this.paymentDate = payment.paymentDate;
            this.paymentMethod = payment.paymentMethod;
            this.paymentAmount = payment.paymentAmount;
            this.orders = payment.orders;
            return this;
        }

        public Payment build(){return  new Payment(this);}

    }

}
