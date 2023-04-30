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
  public Long getUserId();

  /**
   * Setter for user Id.
   *
   * @param userId id to set.
   */
  public void setUserId(Long userId);
}
