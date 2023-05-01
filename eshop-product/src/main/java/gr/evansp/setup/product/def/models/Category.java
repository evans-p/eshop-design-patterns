package gr.evansp.setup.product.def.models;

import gr.evansp.beans.Description;
import gr.evansp.beans.Named;
import gr.evansp.ecb.Entity;
import gr.evansp.setup.product.def.beans.Products;

/**
 * Category of eshop {@link Product}
 */
public interface Category extends CategoryPK, Named, Description, Products, Entity {
  //EMPTY
}
