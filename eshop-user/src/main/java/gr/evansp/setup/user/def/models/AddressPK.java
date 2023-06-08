package gr.evansp.setup.user.def.models;

/**
 * Address primary key.
 */
public interface AddressPK extends UserPK {
  /**
   * Getter for address Id.
   *
   * @return address id.
   */
  public Long getAddressId();

  /**
   * Setter for address Id.
   *
   * @param addressId id to set.
   */
  public void setAddressId(Long addressId);
}
