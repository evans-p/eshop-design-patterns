package gr.evansp.setup.product.def.beans;

import gr.evansp.setup.product.def.models.Characteristic;

import java.util.Set;

/**
 * Set of all product Characteristics.
 */
public interface Characteristics {
  /**
   * Getter for product characteristics.
   *
   * @return set of characteristics
   */
  public Set<Characteristic> getCharacteristics();

  /**
   * Setter for product Characteristics.
   *
   * @param characteristics characteristics to set.
   */
  public void setCharacteristics(Set<Characteristic> characteristics);
}
