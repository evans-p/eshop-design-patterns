package gr.evansp.setup.order.impl.models;

import gr.evansp.setup.order.def.models.Cart;
import gr.evansp.setup.order.def.models.CartItem;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link Cart}.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CartImpl implements Cart {
    @EqualsAndHashCode.Include
    private Long cartId;

    private Set<CartItem> cartItems = new HashSet<>();
}
