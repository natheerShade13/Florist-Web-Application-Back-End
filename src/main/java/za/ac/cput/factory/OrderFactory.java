package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderLine;
import za.ac.cput.utility.OrderHelper;

import java.util.Date;
import java.util.List;

public class OrderFactory {
    public static Order buildOrder(long orderId, Date orderDate, double totalAmount, String status, List<OrderLine> orderLine){
        if(orderId < 0 ||
                OrderHelper.isDateNull(orderDate) ||
                OrderHelper.isNegative(totalAmount) ||
                OrderHelper.isNullorEmpty(status) ||
                orderLine == null)
            return null;

        return new Order.Builder()
                .setOrderId(orderId)
                .setOrderDate(orderDate)
                .setTotalAmount(totalAmount)
                .setStatus(status)
                .setOrderLine(orderLine)
                .build();
    }

    public static Order buildOrder(long orderId, Date orderDate, double totalAmount, String status){
        if(orderId < 0 ||
                OrderHelper.isDateNull(orderDate) ||
                OrderHelper.isNegative(totalAmount) ||
                OrderHelper.isNullorEmpty(status))
            return null;

        return new Order.Builder()
                .setOrderId(orderId)
                .setOrderDate(orderDate)
                .setTotalAmount(totalAmount)
                .setStatus(status)
                .build();
    }
}
