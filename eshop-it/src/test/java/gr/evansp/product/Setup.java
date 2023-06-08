package gr.evansp.product;

import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Set;

public class Setup {
  public Category createSampleCategory() {
    Category category = Factory.create(Category.class);
    category.setName("Category");
    category.setDescription("Category Description");
    return category;
  }

  public Product createSampleProduct(Category category) {
    Product product = Factory.create(Product.class);
    Characteristic characteristic = Factory.create(Characteristic.class);

    characteristic.setName("characteristic");
    characteristic.setValue("Value");

    product.setDescription("Description");
    product.setPrice(BigDecimal.TEN);
    product.setName("Product");
    product.setInventoryLimit(100);
    product.setInventoryCount(100);
    product.setDateAdded(Calendar.getInstance().getTime());
    product.setDateLastModified(Calendar.getInstance().getTime());
    product.setSKU("SKU");
    product.setCategory(category);

    characteristic.setProduct(product);
    product.setCharacteristics(Set.of(characteristic));

    return product;
  }

  public Characteristic createSampleCharacteristic(Product product) {
    Characteristic characteristic = Factory.create(Characteristic.class);

    characteristic.setName("characteristic");
    characteristic.setValue("Value");
    characteristic.setProduct(product);

    return characteristic;
  }
}
