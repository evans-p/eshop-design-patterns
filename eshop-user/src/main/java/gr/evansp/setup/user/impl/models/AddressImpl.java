package gr.evansp.setup.user.impl.models;

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

  private String streetName;
  private String streetNumber;
  private String postalCode;
  private String city;
  private String country;
}
