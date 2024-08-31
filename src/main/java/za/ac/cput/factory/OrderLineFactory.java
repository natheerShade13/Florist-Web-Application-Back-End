package za.ac.cput.factory;

import za.ac.cput.domain.OrderLine;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.Product;
import za.ac.cput.util.OrderLineHelper;

public class OrderLineFactory {

    public static OrderLine buildOrderLine(Orders orders, Product product, int quantity
            , double quotedPrice){
        if(orders == null || product == null
                || OrderLineHelper.isLessThanZero(quantity) || OrderLineHelper.isNegative(quotedPrice)){
            return null;
        }

        return new OrderLine.Builder().setOrders(orders).setProduct(product)
                .setQuantity(quantity).setQuotedPrice(quotedPrice).build();
    }
}
