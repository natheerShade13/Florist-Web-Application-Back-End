package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Orders;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    //double findByAmount(double amount);

    //double findByCoupon_DiscountAmount(double amount);

    List<Orders> findByCustomer(Customer customer);

}
