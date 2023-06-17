package gr.evansp.setup.user.impl.models;

import gr.evansp.factory.Factory;
import junit.framework.TestCase;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotEquals;

/**
 * Tests for {@link UserProfileImpl}.
 */
@SuppressWarnings("AssertBetweenInconvertibleTypes")
public class TestUserProfileImpl extends TestCase {


  public void testToString() {
    UserProfileImpl category = Factory.create(UserProfileImpl.class);

    assertTrue(category.toString().length() > 0);
  }


  public void testEquals_null() {
    UserProfileImpl category = Factory.create(UserProfileImpl.class);
    assertNotEquals(null, category);
  }


  public void testEquals_differentClass() {
    UserProfileImpl category = Factory.create(UserProfileImpl.class);
    assertNotEquals(new BigDecimal(1), category);
  }


  public void testEquals_notEqual() {
    UserProfileImpl userProfile = Factory.create(UserProfileImpl.class);
    UserProfileImpl userProfile1 = Factory.create(UserProfileImpl.class);

    userProfile1.setUserId(1L);
    userProfile.setUserId(2L);

    assertNotEquals(userProfile1, userProfile);
  }


  public void testEquals_ok() {
    UserProfileImpl category = Factory.create(UserProfileImpl.class);
    UserProfileImpl category2 = Factory.create(UserProfileImpl.class);

    category.setUserId(1L);
    category2.setUserId(1L);

    assertEquals(category2, category);
  }


  public void testHashcode_ok() {
    UserProfileImpl category = Factory.create(UserProfileImpl.class);
    UserProfileImpl category2 = Factory.create(UserProfileImpl.class);

    category.setUserId(1L);
    category2.setUserId(1L);

    assertEquals(category2.hashCode(), category.hashCode());
  }


  public void testHashcode_nok() {
    UserProfileImpl category = Factory.create(UserProfileImpl.class);
    UserProfileImpl category2 = Factory.create(UserProfileImpl.class);

    category.setUserId(1L);
    category2.setUserId(2L);

    assertNotEquals(category2.hashCode(), category.hashCode());
  }
}