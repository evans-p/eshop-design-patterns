package gr.evansp.setup.user.def.rules;

import gr.evansp.common.Rule;
import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.models.UserProfile;

/**
 * Validator for {@link UserProfile}. The profile must follow the rules
 * below, in order to be validated:
 * <li>userId must not be null</li>
 * <li>first name must not be null or empty</li>
 * <li>last name must not be null or empty</li>
 * <li>phone name must not be null or empty</li>
 * <li>phone name must only contain digits</li>
 * <li>phone name must contain exactly ten(10) digits</li>
 * <li>dateAdded must not be null</li>
 * <li>dateLastModified must be greater than or equal to dateAdded</li>
 * <li>Each {@link Address} of the profile must follow the rules of {@link AddressValidator}</li>
 */
public interface UserProfileValidator extends Rule<UserProfile> {
  //EMPTY
}
