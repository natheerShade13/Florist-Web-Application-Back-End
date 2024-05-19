package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notificationId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private String message;
    private boolean isRead;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSent;

    public Notification() {
    }

    public Notification(Builder builder) {
        this.notificationId = builder.notificationId;
        this.customer = builder.customer;
        this.message = builder.message;
        this.isRead = builder.isRead;
        this.dateSent = builder.dateSent;
    }

    // Getters
    public long getNotificationId() {
        return notificationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return isRead;
    }

    public Date getDateSent() {
        return dateSent;
    }

    // Equals, hashCode, toString methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification)) return false;
        Notification that = (Notification) o;
        return notificationId == that.notificationId &&
                isRead == that.isRead &&
                Objects.equals(customer, that.customer) &&
                Objects.equals(message, that.message) &&
                Objects.equals(dateSent, that.dateSent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationId, customer, message, isRead, dateSent);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", customer=" + customer +
                ", message='" + message + '\'' +
                ", isRead=" + isRead +
                ", dateSent=" + dateSent +
                '}';
    }

    // Builder pattern
    public static class Builder {

        private long notificationId;
        private Customer customer;
        private String message;
        private boolean isRead;
        private Date dateSent;

        public Builder setNotificationId(long notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setIsRead(boolean isRead) {
            this.isRead = isRead;
            return this;
        }

        public Builder setDateSent(Date dateSent) {
            this.dateSent = dateSent;
            return this;
        }

        public Builder copy(Notification notification) {
            this.notificationId = notification.notificationId;
            this.customer = notification.customer;
            this.message = notification.message;
            this.isRead = notification.isRead;
            this.dateSent = notification.dateSent;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}
