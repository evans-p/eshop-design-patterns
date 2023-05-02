package gr.evansp.setup.user.def.models;

import gr.evansp.common.Entity;
import gr.evansp.setup.user.def.beans.Email;
import gr.evansp.setup.user.def.beans.Password;
import gr.evansp.setup.user.def.beans.UserProfileDependent;

/**
 * User.
 */
public interface User extends UserPK, Email, Password, UserProfileDependent, Entity {
  //EMPTY
}
