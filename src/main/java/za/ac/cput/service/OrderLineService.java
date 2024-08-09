package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.OrderLine;
import za.ac.cput.repository.OrderLineRepository;

import java.util.List;

@Service
public class OrderLineService implements IService<OrderLine, Long>{

    @Autowired
    private final OrderLineRepository orderLineRepository;

    public OrderLineService(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public OrderLine create(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    @Override
    public OrderLine read(Long aLong) {
        return orderLineRepository.findById(aLong).orElseThrow(() -> new IllegalStateException("OrderLine with " +
                "id " + aLong + " does not exist"));
    }

    @Override
    public OrderLine update(OrderLine orderLine) {
        if (orderLineRepository.existsById(orderLine.getOrderLineId())){
            return orderLineRepository.save(orderLine);
        } else {
            throw new IllegalStateException("OrderLine with id " + orderLine.getOrderLineId() + " does not exist");
        }
    }

    @Override
    public boolean delete(Long d) {
        if (orderLineRepository.existsById(d)){
            orderLineRepository.deleteById(d);
            return true;
        } else {
            throw new IllegalStateException("OrderLine with id " + d + " does not exist");
        }
    }

    @Override
    public List<OrderLine> getAll() {
        return orderLineRepository.findAll();
    }
}
