package gr.evansp.setup.product.def.rules;

import gr.evansp.common.Rule;
import gr.evansp.setup.product.def.models.Characteristic;

/**
 * Validator for {@link Characteristic}. Said characteristic
 * is valid only if it follows the rules below:
 * <li>characteristic cannot be null</li>
 * <li>name cannot be null or empty.</li>
 * <li>value cannot be null or empty</li>
 * <li>product cannot be null.</li>
 */
public interface CharacteristicValidator extends Rule<Characteristic> {
  //EMPTY
}
