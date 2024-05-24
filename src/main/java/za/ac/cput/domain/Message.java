package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private long messageId;

    @Column(name = "subject")
    private String subject;

    @Column(name = "message_content")
    private String messageContent;

    @Column(name = "is_read")
    private boolean isRead;

    @Column(name = "date_sent")
    private Date dateSent;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Private constructor to enforce the use of the builder
    public Message(Builder builder) {
        this.messageId = builder.messageId;
        this.subject = builder.subject;
        this.messageContent = builder.messageContent;
        this.isRead = builder.isRead;
        this.dateSent = builder.dateSent;
        this.customer = builder.customer;
        this.employee = builder.employee;
    }

    // Default constructor for JPA
    public Message() {}

    // Getters for each field
    public long getMessageId() {
        return messageId;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public boolean isRead() {
        return isRead;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return isRead == message.isRead &&
                Objects.equals(messageId, message.messageId) &&
                Objects.equals(subject, message.subject) &&
                Objects.equals(messageContent, message.messageContent) &&
                Objects.equals(dateSent, message.dateSent) &&
                Objects.equals(customer, message.customer) &&
                Objects.equals(employee, message.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, subject, messageContent, isRead, dateSent, customer, employee);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId='" + messageId + '\'' +
                ", subject='" + subject + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", isRead=" + isRead +
                ", dateSent=" + dateSent +
                ", customer=" + customer +
                ", employee=" + employee +
                '}';
    }

    // Builder class
    public static class Builder {
        private long messageId;
        private String subject;
        private String messageContent;
        private boolean isRead;
        private Date dateSent;
        private Customer customer;
        private Employee employee;

        // Setter methods for each field returning Builder for chaining
        public Builder setMessageId(long messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder setMessageContent(String messageContent) {
            this.messageContent = messageContent;
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

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Builder copy(Message message) {
            this.messageId = message.messageId;
            this.subject = message.subject;
            this.messageContent = message.messageContent;
            this.isRead = message.isRead;
            this.dateSent = message.dateSent;
            this.customer = message.customer;
            this.employee = message.employee;
            return this;
        }

        // Build method to create an instance of Message
        public Message build() {
            return new Message(this);
        }
    }
}
