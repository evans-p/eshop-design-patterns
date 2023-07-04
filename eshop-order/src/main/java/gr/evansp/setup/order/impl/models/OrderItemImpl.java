package gr.evansp.setup.order.impl.models;

import gr.evansp.setup.order.def.models.OrderItem;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderItemImpl implements OrderItem {
    @EqualsAndHashCode.Include
    private Long orderId;

    @EqualsAndHashCode.Include
    private Long userId;

    @EqualsAndHashCode.Include
    private Long categoryId;

    @EqualsAndHashCode.Include
    private Long productId;

    private Long count;
}
