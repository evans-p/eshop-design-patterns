package gr.evansp.setup.user.impl.models;

import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.models.UserProfile;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

/**
 * Implementation of {@link UserProfile}
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserProfileImpl implements UserProfile {

  @EqualsAndHashCode.Include
  private Long userId;

  private String firstName;
  private String lastName;
  private String phoneNo;
  private Date dateAdded;
  private Date dateLastModified;
  private Set<Address> addresses;
}
