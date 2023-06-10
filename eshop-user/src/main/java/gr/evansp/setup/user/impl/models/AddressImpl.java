package gr.evansp.setup.user.impl.models;

import gr.evansp.constants.StringConstants;
import gr.evansp.setup.user.def.models.Address;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Implementation of {@link Address}.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AddressImpl implements Address {

  @EqualsAndHashCode.Include
  private Long addressId;

  @EqualsAndHashCode.Include
  private Long userId;

  private String streetName = StringConstants.EMPTY;
  private String streetNumber = StringConstants.EMPTY;
  private String postalCode = StringConstants.EMPTY;
  private String city = StringConstants.EMPTY;
  private String country = StringConstants.EMPTY;
}
