package gr.evansp.product;

import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;

public class Setup {
  public Category createSampleCategory() {

    Category category = Factory.create(Category.class);
    category.setName("Category");
    category.setDescription("Category Description");
    return category;
  }
}
