package gr.evansp.setup.user.def.models;

import gr.evansp.ecb.Entity;
import gr.evansp.setup.user.def.beans.*;

/**
 * User address.
 */
public interface Address extends AddressPK, StreetName, StreetNumber, PostalCode, City, Country,
    UserProfileDependent, Entity {
  //EMPTY
}
