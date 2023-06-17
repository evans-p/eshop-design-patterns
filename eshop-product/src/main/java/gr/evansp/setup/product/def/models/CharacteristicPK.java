package gr.evansp.setup.product.def.models;

/**
 * Primary key for {@link Characteristic}
 */
public interface CharacteristicPK extends ProductPK {
  /**
   * Getter for Characteristic id.
   *
   * @return Id.
   */
  Long getCharacteristicId();

  /**
   * Setter for Characteristic Id.
   *
   * @param characteristicId Id to set.
   */
  void setCharacteristicId(Long characteristicId);
}
