package gr.evansp.setup.order.impl.models;

import gr.evansp.constants.StringConstants;
import gr.evansp.setup.order.def.enums.OrderStatus;
import gr.evansp.setup.order.def.models.Order;
import gr.evansp.setup.order.def.models.OrderItem;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link Order}.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderImpl implements Order {
    @EqualsAndHashCode.Include
    private Long orderId;

    @EqualsAndHashCode.Include
    private Long userId;

    private Date dateAdded = Calendar.getInstance().getTime();
    private Date dateLastModified = Calendar.getInstance().getTime();
    private OrderStatus status = OrderStatus.PENDING;
    private String streetName = StringConstants.EMPTY;
    private String streetNumber = StringConstants.EMPTY;
    private String postalCode = StringConstants.EMPTY;
    private String city = StringConstants.EMPTY;
    private String country = StringConstants.EMPTY;
    private Set<OrderItem> orderItems = new HashSet<>();
}
