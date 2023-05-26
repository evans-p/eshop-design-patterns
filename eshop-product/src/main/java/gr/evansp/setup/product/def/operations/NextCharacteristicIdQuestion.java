package gr.evansp.setup.product.def.operations;

import gr.evansp.common.Question;
import gr.evansp.setup.product.def.models.Characteristic;

/**
 * Saves a new {@link Characteristic} to the DB, or
 * updates an existing one.
 */
public interface NextCharacteristicIdQuestion extends Question<Long> {
  //EMPTY
}
