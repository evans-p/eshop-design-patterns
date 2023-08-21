package gr.evansp.setup.product.def.ws.models;

import gr.evansp.beans.Description;
import gr.evansp.beans.Named;
import gr.evansp.common.Entity;
import gr.evansp.setup.product.def.beans.Characteristics;
import gr.evansp.setup.product.def.beans.InventoryCount;
import gr.evansp.setup.product.def.beans.Price;
import gr.evansp.setup.product.def.models.ProductPK;

/**
 * DTO for {@link gr.evansp.setup.product.def.models.Product}
 */
public interface ProductDTO extends ProductPK, Characteristics, Named, InventoryCount,
        Price, Description, Entity {
    // EMPTY.
}
