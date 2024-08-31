package za.ac.cput.factory;

import za.ac.cput.domain.Coupon;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Orders;
import za.ac.cput.util.OrdersHelper;

import java.time.LocalDate;

public class OrdersFactory {

    public static Orders buildOrder(double amount, LocalDate orderDate, String status
            , Customer customer, Coupon coupon){
        if (OrdersHelper.isNegative(amount) || OrdersHelper.isNull(orderDate)
                || OrdersHelper.isNullOrEmpty(status) || customer == null /*|| coupon == null */){
            return null;
        }

        return new Orders.Builder().setAmount(amount).setOrderDate(orderDate)
                .setStatus(status).setCustomer(customer).setCoupon(coupon).build();
    }

    //Add order without coupon as a coupon is optional

}
