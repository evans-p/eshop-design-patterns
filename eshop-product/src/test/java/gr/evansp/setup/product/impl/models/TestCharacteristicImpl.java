package gr.evansp.setup.product.impl.models;

import gr.evansp.factory.Factory;
import junit.framework.TestCase;

/**
 * Tests for {@link CharacteristicImpl}
 */
public class TestCharacteristicImpl extends TestCase {

  public void testToString() {
    CharacteristicImpl sut = Factory.create(CharacteristicImpl.class);
    assertTrue(sut.toString().length() > 0);
  }

}