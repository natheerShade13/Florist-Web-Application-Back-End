package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.OrderLine;
import za.ac.cput.repository.OrderLineRepository;

import java.util.List;

@Service
public class OrderLineService implements IOrderLineService{
    private OrderLineRepository repository;

    @Autowired
    OrderLineService(OrderLineRepository repository){
        this.repository = repository;
    }

    @Override
    public OrderLine create(OrderLine orderLine) {
        return repository.save(orderLine);
    }

    @Override
    public OrderLine read(Long Id) {
        return repository.findById(Id).orElse(null);
    }

    @Override
    public OrderLine update(OrderLine orderLine) {
        return repository.save(orderLine);
    }

    @Override
    public List<OrderLine> getAll() {
        return repository.findAll();
    }
}
