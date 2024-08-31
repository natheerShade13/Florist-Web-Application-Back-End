package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.*;
import za.ac.cput.repository.CartProductRepository;
import za.ac.cput.repository.CartRepository;
import za.ac.cput.repository.OrdersRepository;
import za.ac.cput.repository.ProductRepository;
import za.ac.cput.service.OrderLineService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersCheckout {

    private Orders order;

    private final OrdersRepository ordersRepository;

    private final CartProductRepository cartProductRepository;

    private final CartRepository cartRepository;

    private final ProductRepository productRepository; // Add the ProductRepository

    private final OrderLineService orderLineService;

    @Autowired
    public OrdersCheckout(OrdersRepository ordersRepository, CartProductRepository cartProductRepository, CartRepository cartRepository,
                          ProductRepository productRepository, OrderLineService orderLineService) {
        this.ordersRepository = ordersRepository;
        this.cartProductRepository = cartProductRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.orderLineService = orderLineService;
    }

    @Transactional
    public Orders checkout(Customer customer) {
        Cart cart = cartRepository.findByCustomer(customer);
        List<CartProduct> cartProducts = cartProductRepository.findByCart(cart);
        List<OrderLine> orderLines = new ArrayList<>();
        double totalAmount = 0;

        if (cartProducts.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        order = new Orders.Builder()
                .setCustomer(customer)
                .setOrderDate(LocalDate.now())
                .setStatus("PENDING")
                .build();

        for (CartProduct cartProduct : cartProducts) {
            int orderedQuantity = cartProduct.getQuantity();
            double unitPrice = cartProduct.getUnitPrice();

            totalAmount += orderedQuantity * unitPrice;

        }

        //Add this in the builder
        order.setAmount(totalAmount);
        ordersRepository.save(order);


        for (CartProduct cartProduct : cartProducts) {
            Product product = cartProduct.getProduct();
            int orderedQuantity = cartProduct.getQuantity();

            // Decrement the product quantity
            int updatedQuantity = product.getStockQuantity() - orderedQuantity;
            if (updatedQuantity < 0) {
                throw new IllegalStateException("Product " + product.getName() + " is out of stock.");
            }
            product.setStockQuantity(updatedQuantity);

            // Save the updated product
            productRepository.save(product);

            OrderLine orderLine = new OrderLine.Builder()
                    .setOrders(order)
                    .setProduct(product)
                    .setQuantity(orderedQuantity)
                    .setQuotedPrice(cartProduct.getUnitPrice() * orderedQuantity)
                    .build();

            //order.getOrderLines().add(orderLine);
            orderLineService.create(orderLine);
            //Adding all the orderLines to an array
            orderLines.add(orderLine);
        }

        order.setOrderLines(orderLines);

        // Clear the cart after checkout
        cartProductRepository.deleteAll(cartProducts);

        return order;
    }

    public List<Orders> getAllOrdersByCustomer(Customer customer) {
        return ordersRepository.findByCustomer(customer);
    }

//    public List<Orders> getAllOrdersWithOrderLinesByCustomer(Customer customer) {
//        List<Orders> orders = ordersRepository.findByCustomer(customer);
//
//        // Eagerly fetch OrderLines, if not already fetched
//        for (Orders order : orders) {
//            order.getOrderLines().size(); // This forces the loading of OrderLines if it's a lazy fetch
//        }
//
//        return orders;
//    }

}
