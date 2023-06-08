package gr.evansp.setup.user.def.rules;

import gr.evansp.common.Rule;
import gr.evansp.setup.user.def.models.Address;

/**
 * Validator for {@link Address}. The address must follow the rules
 * below, in order to be validated:
 * <li>addressId must not be null</li>
 * <li>streetName must not be null</li>
 * <li>streetName must contain only letters</li>
 * <li>streetNumber must not be null</li>
 * <li>streetNumber must only contain numbers</li>
 * <li>postalCode must not be null</li>
 * <li>postalCode must only contain numbers</li>
 * <li>city must not be null</li>
 * <li>city must contain only letters</li>
 * <li>Country must not be null</li>
 * <li>Country must contain only letters</li>
 */
public interface AddressValidator extends Rule<Address> {
  //EMPTY
}
