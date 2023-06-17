package gr.evansp.setup.product.impl.models;

import gr.evansp.factory.Factory;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests for {@link ProductImpl}.
 */
@SuppressWarnings("AssertBetweenInconvertibleTypes")
public class TestProductImpl {

  @Test
  public void testToString() {
    ProductImpl product = Factory.create(ProductImpl.class);

    product.setCategoryId(1L);
    product.setName("Lala");
    product.setDescription("Description");
    assertEquals(String.class, product.toString().getClass());
    Assert.assertTrue(product.toString().length() > 0);
  }

  @Test
  public void testEquals_null() {
    ProductImpl product = Factory.create(ProductImpl.class);

    product.setCategoryId(1L);
    product.setName("Lala");
    product.setDescription("Description");
    assertNotEquals(null, product);
  }

  @Test
  public void testEquals_differentClass() {
    ProductImpl category = Factory.create(ProductImpl.class);

    category.setCategoryId(1L);
    category.setName("Lala");
    category.setDescription("Description");
    assertNotEquals(new BigDecimal(1), category);
  }

  @Test
  public void testEquals_notEqualCategories() {
    ProductImpl product1 = Factory.create(ProductImpl.class);
    ProductImpl product2 = Factory.create(ProductImpl.class);

    product2.setCategoryId(1L);
    product2.setProductId(2L);

    product1.setCategoryId(2L);
    product1.setProductId(2L);

    assertNotEquals(product2, product1);
  }

  @Test
  public void testEquals_ok() {
    ProductImpl product1 = Factory.create(ProductImpl.class);
    ProductImpl product2 = Factory.create(ProductImpl.class);

    product1.setCategoryId(1L);
    product1.setProductId(1L);
    product2.setProductId(1L);
    product2.setCategoryId(1L);

    assertEquals(product2, product1);
  }

  @Test
  public void testHashcode_ok() {
    ProductImpl product1 = Factory.create(ProductImpl.class);
    ProductImpl product2 = Factory.create(ProductImpl.class);

    product1.setCategoryId(1L);
    product1.setProductId(1L);
    product2.setProductId(1L);
    product2.setCategoryId(1L);

    assertEquals(product2, product1);

    assertEquals(product2.hashCode(), product1.hashCode());
  }

  @Test
  public void testHashcode_nok() {
    ProductImpl product1 = Factory.create(ProductImpl.class);
    ProductImpl product2 = Factory.create(ProductImpl.class);

    product1.setCategoryId(2L);
    product1.setProductId(1L);
    product2.setProductId(1L);
    product2.setCategoryId(1L);


    assertNotEquals(product2.hashCode(), product1.hashCode());
  }

}