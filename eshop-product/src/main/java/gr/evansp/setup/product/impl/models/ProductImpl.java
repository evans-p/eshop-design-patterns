package gr.evansp.setup.product.impl.models;

import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Implementation of {@link Product}.
 */
public class ProductImpl implements Product {
  private Long productId;
  private String SKU;
  private String name;
  private Integer inventoryCount;
  private Integer inventoryLimit;
  private Category category;
  private Set<Characteristic> characteristics;
  private BigDecimal price;
  private String description;
  private Date dateAdded;
  private Date dateLastModified;

  @Override
  public Long getProductId() {
    return productId;
  }

  @Override
  public void setProductId(Long productId) {
    this.productId = productId;
  }

  @Override
  public String getSKU() {
    return SKU;
  }

  @Override
  public void setSKU(String SKU) {
    this.SKU = SKU;
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
  public Integer getInventoryCount() {
    return inventoryCount;
  }

  @Override
  public void setInventoryCount(Integer inventoryCount) {
    this.inventoryCount = inventoryCount;
  }

  @Override
  public Integer getInventoryLimit() {
    return inventoryLimit;
  }

  @Override
  public void setInventoryLimit(Integer inventoryLimit) {
    this.inventoryLimit = inventoryLimit;
  }

  @Override
  public Category getCategory() {
    return category;
  }

  @Override
  public void setCategory(Category category) {
    this.category = category;
  }

  @Override
  public Set<Characteristic> getCharacteristics() {
    return characteristics;
  }

  @Override
  public void setCharacteristics(Set<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

  @Override
  public BigDecimal getPrice() {
    return price;
  }

  @Override
  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public Date getDateAdded() {
    return dateAdded;
  }

  @Override
  public void setDateAdded(Date dateAdded) {
    this.dateAdded = dateAdded;
  }

  @Override
  public Date getDateLastModified() {
    return dateLastModified;
  }

  @Override
  public void setDateLastModified(Date dateLastModified) {
    this.dateLastModified = dateLastModified;
  }

  @Override
  public int hashCode() {
    return productId.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ProductImpl product = (ProductImpl) o;

    return productId.equals(product.productId);
  }

  @Override
  public String toString() {
    return "Product" +
        "productId=" + productId +
        ", SKU='" + SKU + '\'' +
        ", name='" + name + '\'' +
        ", inventoryCount=" + inventoryCount +
        ", inventoryLimit=" + inventoryLimit +
        ", category=" + category +
        ", characteristics=" + characteristics +
        ", price=" + price +
        ", description='" + description + '\'' +
        ", dateAdded=" + dateAdded +
        ", dateLastModified=" + dateLastModified +
        '}';
  }
}
