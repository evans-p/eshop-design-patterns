package gr.evansp.setup.user.impl.models;

import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.models.UserProfile;

import java.util.Date;
import java.util.Set;

public class UserProfileImpl implements UserProfile {
  private Long userId;
  private String firstName;
  private String lastName;
  private String phoneNo;
  private Date dateAdded;
  private Date dateLastModified;
  private Set<Address> addresses;


  @Override
  public int hashCode() {
    return userId.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserProfileImpl that = (UserProfileImpl) o;

    return userId.equals(that.userId);
  }

  @Override
  public String toString() {
    return "UserProfile{" +
        "userId=" + userId +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", phoneNo='" + phoneNo + '\'' +
        ", dateAdded=" + dateAdded +
        ", dateLastModified=" + dateLastModified +
        ", addresses=" + addresses +
        '}';
  }

  @Override
  public Long getUserId() {
    return userId;
  }

  @Override
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  @Override
  public String getFirstName() {
    return firstName;
  }

  @Override
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public String getLastName() {
    return lastName;
  }

  @Override
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String getPhoneNo() {
    return phoneNo;
  }

  @Override
  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  @Override
  public Date getDateAdded() {
    return dateAdded;
  }

  @Override
  public void setDateAdded(Date dateAdded) {
    this.dateAdded = dateAdded;
  }

  @Override
  public Date getDateLastModified() {
    return dateLastModified;
  }

  @Override
  public void setDateLastModified(Date dateLastModified) {
    this.dateLastModified = dateLastModified;
  }

  @Override
  public Set<Address> getAddresses() {
    return addresses;
  }

  @Override
  public void setAddresses(Set<Address> addresses) {
    this.addresses = addresses;
  }
}
