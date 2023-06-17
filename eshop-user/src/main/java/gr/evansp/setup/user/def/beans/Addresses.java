package gr.evansp.setup.user.def.beans;

import gr.evansp.setup.user.def.models.Address;

import java.util.Set;

/**
 * User Addresses.
 */
@SuppressWarnings("unused")
public interface Addresses {
  /**
   * Getter for addresses.
   *
   * @return addresses.
   */
  Set<Address> getAddresses();

  /**
   * Setter for addresses.
   *
   * @param addresses addresses to set.
   */
  void setAddresses(Set<Address> addresses);
}
