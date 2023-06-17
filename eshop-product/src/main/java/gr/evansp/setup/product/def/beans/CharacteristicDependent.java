package gr.evansp.setup.product.def.beans;

import gr.evansp.setup.product.def.models.Characteristic;

/**
 * Something that depends on {@link Characteristic}
 */
@SuppressWarnings("unused")
public interface CharacteristicDependent {
  /**
   * Getter for Characteristic.
   *
   * @return Characteristic
   */
  Characteristic getCharacteristic();

  /**
   * Setter for Characteristic.
   *
   * @param characteristic Characteristic to set.
   */
  void setCharacteristic(Characteristic characteristic);
}
