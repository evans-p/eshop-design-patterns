package gr.evansp.setup.product.def.models;

import gr.evansp.beans.Named;
import gr.evansp.beans.Value;
import gr.evansp.setup.product.def.beans.ProductDependent;

/**
 * {@link Product} Characteristic
 */
public interface Characteristic extends CharacteristicPK, ProductDependent, Named, Value {
  //EMPTY
}
