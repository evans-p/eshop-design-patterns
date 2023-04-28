package gr.evansp.setup.user.impl.models;

import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.models.UserProfile;

/**
 * Implementation of {@link Address}.
 */
public class AddressImpl implements Address {
  private Long addressId;
  private String streetName;
  private String streetNumber;
  private String postalCode;
  private UserProfile userProfile;
  private String city;
  private String country;

  @Override
  public UserProfile getUserProfile() {
    return userProfile;
  }

  @Override
  public void setUserProfile(UserProfile userProfile) {
    this.userProfile = userProfile;
  }

  @Override
  public int hashCode() {
    return addressId.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AddressImpl address = (AddressImpl) o;

    return addressId.equals(address.addressId);
  }

  @Override
  public String toString() {
    return "Address{" +
        "addressId=" + addressId +
        ", streetName='" + streetName + '\'' +
        ", streetNumber='" + streetNumber + '\'' +
        ", postalCode='" + postalCode + '\'' +
        ", city='" + city + '\'' +
        ", country='" + country + '\'' +
        '}';
  }

  @Override
  public Long getAddressId() {
    return addressId;
  }

  @Override
  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }

  @Override
  public String getStreetName() {
    return streetName;
  }

  @Override
  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  @Override
  public String getStreetNumber() {
    return streetNumber;
  }

  @Override
  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }

  @Override
  public String getPostalCode() {
    return postalCode;
  }

  @Override
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  @Override
  public String getCity() {
    return city;
  }

  @Override
  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public String getCountry() {
    return country;
  }

  @Override
  public void setCountry(String country) {
    this.country = country;
  }
}
