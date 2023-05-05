package gr.evansp.setup.user.def.rules;

import gr.evansp.common.Rule;
import gr.evansp.setup.user.def.models.User;

/**
 * Validator for {@link User}. User must follow the rules below,
 * in order to be validated:
 * <li>userId must not be null</li>
 * <li>email must not be null</li>
 * <li>email must not be empty</li>
 * <li>email must contain the '@' character just once</li>
 * <li>email must contain the '.' character, after the '@' character</li>
 * <li>password must not be null.</li>
 * <li>password must be at least 10 characters.</li>
 * <li>password must contain at least 1 number, 1 character and 1 symbol.</li>
 */
public interface UserValidator extends Rule<User> {
  //EMPTY
}
