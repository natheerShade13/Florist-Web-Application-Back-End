package za.ac.cput.service;

import za.ac.cput.domain.OrderLine;

import java.util.List;

public interface IOrderLineService extends IService <OrderLine, Long> {
    List<OrderLine> getAll();
}
