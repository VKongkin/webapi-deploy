package kongkin.bbu.edu.webapideploy.models.services;


import kongkin.bbu.edu.webapideploy.exceptions.AppException;
import kongkin.bbu.edu.webapideploy.models.Order;
import kongkin.bbu.edu.webapideploy.models.OrderItem;
import kongkin.bbu.edu.webapideploy.models.request.OrderRequest;

import java.util.List;

public interface OrderService {
    List<Order> getAll() throws AppException;
    List<OrderItem> getOrderItemByOrderId(Integer id) throws AppException;
    void createOrder(OrderRequest req) throws AppException;

}
