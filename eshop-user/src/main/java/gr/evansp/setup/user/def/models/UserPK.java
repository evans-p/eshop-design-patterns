package gr.evansp.setup.user.def.models;

/**
 * User primary key.
 */
public interface UserPK {
  /**
   * Getter for user Id.
   *
   * @return user id.
   */
  Long getUserId();

  /**
   * Setter for user Id.
   *
   * @param userId id to set.
   */
  void setUserId(Long userId);
}
