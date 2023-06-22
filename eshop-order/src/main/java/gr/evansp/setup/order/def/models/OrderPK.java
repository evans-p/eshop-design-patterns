package gr.evansp.setup.order.def.models;

import gr.evansp.setup.user.def.models.UserPK;

/**
 * Primary key of {@link Order}
 */
@SuppressWarnings("unused")
public interface OrderPK extends UserPK {
  /**
   * Getter for order Id.
   *
   * @return Id to get.
   */
  Long getOrderId();

  /**
   * Setter for Order Id.
   *
   * @param orderId Order Id to set.
   */
  void setOrderId(Long orderId);
}
