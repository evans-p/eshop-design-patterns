package gr.evansp.setup.user.def.models;

import gr.evansp.setup.user.def.beans.*;

/**
 * User profile.
 */
public interface UserProfile extends UserPK, FirstName, LastName, PhoneNo, DateAdded,
    DateLastModified, Addresses {
  //EMPTY
}
