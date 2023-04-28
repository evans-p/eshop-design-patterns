package gr.evansp.setup.user.impl.models;

import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.models.UserProfile;

/**
 * Implementation of {@link User}
 */
public class UserImpl implements User {
  private Long userId;
  private String email;
  private String password;
  private UserProfile userProfile;

  @Override
  public Long getUserId() {
    return userId;
  }

  @Override
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public void setPassword(String password) {
    this.password = password;
  }

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
    return userId.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserImpl user = (UserImpl) o;

    return userId.equals(user.userId);
  }

  @Override
  public String toString() {
    return "User{" +
        "userId=" + userId +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", userProfile=" + userProfile +
        '}';
  }
}
