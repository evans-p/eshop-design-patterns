package gr.evansp.setup.product.impl.ws.models;

import gr.evansp.constants.StringConstants;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.ws.models.ProductDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link ProductDTO}.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductDTOImpl implements ProductDTO {
    @EqualsAndHashCode.Include
    private Long productId;

    @EqualsAndHashCode.Include
    private Long categoryId;

    private String name = StringConstants.EMPTY;
    private Integer inventoryCount;
    private BigDecimal price = BigDecimal.ZERO;
    private String description = StringConstants.EMPTY;
    private Set<Characteristic> characteristics = new HashSet<>();
}
