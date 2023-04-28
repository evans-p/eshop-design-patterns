package gr.evansp.setup.user.def.beans;

import gr.evansp.setup.user.def.models.Address;

import java.util.Set;

/**
 * User Addresses.
 */
public interface Addresses {
  /**
   * Getter for addresses.
   *
   * @return addresses.
   */
  public Set<Address> getAddresses();

  /**
   * Setter for addresses.
   *
   * @param addresses addresses to set.
   */
  public void setAddresses(Set<Address> addresses);
}
