package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Message;
import za.ac.cput.domain.Employee;
import za.ac.cput.utility.MessageHelper;

import java.util.Date;

public class MessageFactory {

    public static Message buildMessage(long messageId, String subject, String messageContent, boolean isRead, Date dateSent, Customer customer, Employee employee) {
        if (MessageHelper.isNullOrEmpty(subject) || MessageHelper.isNullOrEmpty(messageContent) || dateSent == null
                || customer == null || employee == null) {
            return null;
        }

        return new Message.Builder()
                .setMessageId(messageId)
                .setSubject(subject)
                .setMessageContent(messageContent)
                .setIsRead(isRead)
                .setDateSent(dateSent)
                .setCustomer(customer)
                .setEmployee(employee)
                .build();
    }

    /*
    public static Message buildMessage(String subject, String messageContent, boolean isRead, Date dateSent, Customer, Employee) {
        if (Helper.isNullOrEmpty(subject) || Helper.isNullOrEmpty(messageContent) || dateSent == null
                || customer == null || employee == null) {
            return null;
        }

        long messageId = Helper.generateID();

        return new Message.Builder()
                .setMessageId(messageId)
                .setSubject(subject)
                .setMessageContent(messageContent)
                .setIsRead(isRead)
                .setDateSent(dateSent)
                .setCustomer(customer)
                .setEmployee(employee)
                .build();
    }
    */
}
