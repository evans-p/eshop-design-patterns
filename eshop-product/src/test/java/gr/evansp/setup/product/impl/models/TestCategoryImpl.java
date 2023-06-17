package gr.evansp.setup.product.impl.models;

import gr.evansp.factory.Factory;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests for {@link CategoryImpl}
 */
@SuppressWarnings("AssertBetweenInconvertibleTypes")
public class TestCategoryImpl {

  @Test
  public void testToString() {
    CategoryImpl category = Factory.create(CategoryImpl.class);

    category.setCategoryId(1L);
    category.setName("Lala");
    category.setDescription("Description");
    assertEquals("CategoryImpl(categoryId=1, name=Lala, description=Description)", category.toString());
  }

  @Test
  public void testEquals_null() {
    CategoryImpl category = Factory.create(CategoryImpl.class);

    category.setCategoryId(1L);
    category.setName("Lala");
    category.setDescription("Description");
    assertNotEquals(null, category);
  }

  @Test
  public void testEquals_differentClass() {
    CategoryImpl category = Factory.create(CategoryImpl.class);

    category.setCategoryId(1L);
    category.setName("Lala");
    category.setDescription("Description");
    assertNotEquals(new BigDecimal(1), category);
  }

  @Test
  public void testEquals_notEqualCategories() {
    CategoryImpl category = Factory.create(CategoryImpl.class);
    CategoryImpl category2 = Factory.create(CategoryImpl.class);

    category.setCategoryId(1L);
    category.setCategoryId(2L);

    assertNotEquals(category2, category);
  }

  @Test
  public void testEquals_ok() {
    CategoryImpl category = Factory.create(CategoryImpl.class);
    CategoryImpl category2 = Factory.create(CategoryImpl.class);

    category.setCategoryId(1L);
    category2.setCategoryId(1L);

    assertEquals(category2, category);
  }

  @Test
  public void testHashcode_ok() {
    CategoryImpl category = Factory.create(CategoryImpl.class);
    CategoryImpl category2 = Factory.create(CategoryImpl.class);

    category.setCategoryId(1L);
    category2.setCategoryId(1L);

    assertEquals(category2.hashCode(), category.hashCode());
  }

  @Test
  public void testHashcode_nok() {
    CategoryImpl category = Factory.create(CategoryImpl.class);
    CategoryImpl category2 = Factory.create(CategoryImpl.class);

    category.setCategoryId(1L);
    category2.setCategoryId(2L);

    assertNotEquals(category2.hashCode(), category.hashCode());
  }
}