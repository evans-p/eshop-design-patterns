package gr.evansp.setup.user.def.models;

import gr.evansp.beans.DateAdded;
import gr.evansp.beans.DateLastModified;
import gr.evansp.common.Entity;
import gr.evansp.setup.user.def.beans.Addresses;
import gr.evansp.setup.user.def.beans.FirstName;
import gr.evansp.setup.user.def.beans.LastName;
import gr.evansp.setup.user.def.beans.PhoneNo;

/**
 * User profile.
 */
public interface UserProfile extends UserPK, FirstName, LastName, PhoneNo, DateAdded,
    DateLastModified, Addresses, Entity {
  //EMPTY
}
