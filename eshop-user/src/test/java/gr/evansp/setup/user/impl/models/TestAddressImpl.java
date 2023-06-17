package gr.evansp.setup.user.impl.models;

import gr.evansp.factory.Factory;
import junit.framework.TestCase;

/**
 * Tests for {@link AddressImpl}.
 */
public class TestAddressImpl extends TestCase {
  public void testToString() {
    AddressImpl sut = Factory.create(AddressImpl.class);
    assertTrue(sut.toString().length() > 0);
  }
}

