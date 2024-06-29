package kongkin.bbu.edu.webapideploy.models.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequest {
    private int id;
    private int orderId;
    private int productId;
    private int unitTypeId;
    private double price;
    private double qty;
    private int discount;
}
