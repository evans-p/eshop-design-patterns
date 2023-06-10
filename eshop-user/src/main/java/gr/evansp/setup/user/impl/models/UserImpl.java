package gr.evansp.setup.user.impl.models;

import gr.evansp.constants.StringConstants;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.models.UserProfile;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Implementation of {@link User}
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserImpl implements User {

  @EqualsAndHashCode.Include
  private Long userId;

  private String email = StringConstants.EMPTY;
  private String password = StringConstants.EMPTY;
  private UserProfile userProfile;
}
