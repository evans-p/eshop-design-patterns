package gr.evansp.setup.user.impl.models;

import gr.evansp.factory.Factory;
import junit.framework.TestCase;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotEquals;

/**
 * Tests for {@link UserImpl}.
 */
@SuppressWarnings("AssertBetweenInconvertibleTypes")
public class TestUserImpl extends TestCase {

  public void testToString() {
    UserImpl sut = Factory.create(UserImpl.class);
    assertTrue(sut.toString().length() > 0);
  }


  public void testEquals_null() {
    UserImpl user = Factory.create(UserImpl.class);
    assertNotEquals(null, user);
  }


  public void testEquals_differentClass() {
    UserImpl user = Factory.create(UserImpl.class);

    assertNotEquals(new BigDecimal(1), user);
  }


  public void testEquals_notEqualUsers() {
    UserImpl user = Factory.create(UserImpl.class);
    UserImpl user2 = Factory.create(UserImpl.class);

    user.setUserId(1L);
    user.setUserId(2L);

    assertNotEquals(user2, user);
  }


  public void testEquals_ok() {
    UserImpl user = Factory.create(UserImpl.class);
    UserImpl user2 = Factory.create(UserImpl.class);

    user.setUserId(1L);
    user2.setUserId(1L);

    assertEquals(user2, user);
  }


  public void testHashcode_ok() {
    UserImpl user = Factory.create(UserImpl.class);
    UserImpl user2 = Factory.create(UserImpl.class);

    user.setUserId(1L);
    user2.setUserId(1L);

    assertEquals(user2.hashCode(), user.hashCode());
  }


  public void testHashcode_nok() {
    UserImpl user = Factory.create(UserImpl.class);
    UserImpl user2 = Factory.create(UserImpl.class);

    user.setUserId(1L);
    user2.setUserId(2L);

    assertNotEquals(user2.hashCode(), user.hashCode());
  }
}