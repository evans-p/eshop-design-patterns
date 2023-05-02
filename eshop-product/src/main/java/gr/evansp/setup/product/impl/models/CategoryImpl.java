package gr.evansp.setup.product.impl.models;

import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.models.Product;

import java.util.Set;

/**
 * Implementation of {@link Category}
 */
public class CategoryImpl implements Category {
  private Long categoryId;
  private String name;
  private String description;
  private Set<Product> products;

  @Override
  public int hashCode() {
    return categoryId.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CategoryImpl category = (CategoryImpl) o;

    return categoryId.equals(category.categoryId);
  }

  @Override
  public String toString() {
    return "Category{" +
        "categoryId=" + categoryId +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        '}';
  }

  @Override
  public Long getCategoryId() {
    return categoryId;
  }

  @Override
  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
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
  public String getDescription() {
    return description;
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public Set<Product> getProducts() {
    return products;
  }

  @Override
  public void setProducts(Set<Product> products) {
    this.products = products;
  }
}
