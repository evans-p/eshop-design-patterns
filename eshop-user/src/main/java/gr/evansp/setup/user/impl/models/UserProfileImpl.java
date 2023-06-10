package gr.evansp.setup.user.impl.models;

import gr.evansp.constants.StringConstants;
import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.models.UserProfile;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link UserProfile}.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserProfileImpl implements UserProfile {

  @EqualsAndHashCode.Include
  private Long userId;

  private String firstName = StringConstants.EMPTY;
  private String lastName = StringConstants.EMPTY;
  private String phoneNo = StringConstants.EMPTY;
  private Date dateAdded = Calendar.getInstance().getTime();
  private Date dateLastModified = Calendar.getInstance().getTime();
  private Set<Address> addresses = new HashSet<>();
}
