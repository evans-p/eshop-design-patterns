package gr.evansp.setup.product.impl.models;

import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;

public class CharacteristicImpl implements Characteristic {
  private Long characteristicId;
  private String name;
  private String value;
  private Product product;

  @Override
  public int hashCode() {
    return characteristicId.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CharacteristicImpl that = (CharacteristicImpl) o;

    return characteristicId.equals(that.characteristicId);
  }

  @Override
  public String toString() {
    return "Characteristic{" +
        "characteristicId=" + characteristicId +
        ", name='" + name + '\'' +
        ", value='" + value + '\'' +
        '}';
  }

  @Override
  public Long getCharacteristicId() {
    return characteristicId;
  }

  @Override
  public void setCharacteristicId(Long characteristicId) {
    this.characteristicId = characteristicId;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public Product getProduct() {
    return product;
  }

  @Override
  public void setProduct(Product product) {
    this.product = product;
  }
}
