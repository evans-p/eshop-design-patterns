package gr.evansp.setup.product.def.beans;

import gr.evansp.setup.product.def.models.Characteristic;

/**
 * Something that depends on {@link Characteristic}
 */
public interface CharacteristicDependent {
  /**
   * Getter for Characteristic.
   *
   * @return Characteristic
   */
  public Characteristic getCharacteristic();

  /**
   * Setter for Characteristic.
   *
   * @param characteristic Characteristic to set.
   */
  public void setCharacteristic(Characteristic characteristic);
}
