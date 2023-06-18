package gr.evansp.setup.order.impl.models;

import gr.evansp.setup.order.def.models.CartItem;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Implementation of {@link CartItem}.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CartItemImpl implements CartItem {
    @EqualsAndHashCode.Include
    private Long categoryId;

    @EqualsAndHashCode.Include
    private Long productId;

    @EqualsAndHashCode.Include
    private Long cartId;

    @EqualsAndHashCode.Include
    private Long userId;

    @EqualsAndHashCode.Include
    
    private Long count;
}
