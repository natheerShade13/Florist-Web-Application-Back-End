package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.utility.OrderHelper;

import java.util.Date;

public class OrderFactory {
    public static Order buildOrder(long orderId, Date orderDate, double totalAmount, String status, String orderLine){
        if(orderId < 0 || OrderHelper.isDateNull(orderDate) ||
                OrderHelper.isNegative(totalAmount) ||
                OrderHelper.isNullorEmpty(status) ||
                OrderHelper.isNullorEmpty(orderLine))
            return null;

        return new Order.Builder()
                .setOrderId(orderId)
                .setOrderDate(orderDate)
                .setTotalAmount(totalAmount)
                .setStatus(status)
                .setOrderLine(orderLine)
                .build();
    }
}
