package gr.evansp.setup.product.def.models;


import gr.evansp.beans.Description;
import gr.evansp.ecb.Entity;
import gr.evansp.setup.product.def.beans.*;

/**
 * Product of the eshop.
 */
public interface Product extends ProductPK, SKU, InventoryCount, InventoryLimit,
    CategoryDependent, Characteristics, Price, Description, Entity {
  //EMPTY
}
