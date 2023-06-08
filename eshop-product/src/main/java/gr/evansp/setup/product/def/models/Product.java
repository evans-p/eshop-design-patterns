package gr.evansp.setup.product.def.models;


import gr.evansp.beans.DateAdded;
import gr.evansp.beans.DateLastModified;
import gr.evansp.beans.Description;
import gr.evansp.beans.Named;
import gr.evansp.common.Entity;
import gr.evansp.setup.product.def.beans.*;

/**
 * Product of the eshop.
 */
public interface Product extends ProductPK, SKU, Named, InventoryCount, InventoryLimit,
    Characteristics, Price, Description, DateAdded, DateLastModified,
    Entity {
  //EMPTY
}
