package gr.evansp.setup.user.def.models;

import gr.evansp.common.Entity;
import gr.evansp.setup.user.def.beans.*;

/**
 * User address.
 */
public interface Address extends AddressPK, StreetName, StreetNumber, PostalCode,
    City, Country, Entity {
  //EMPTY
}
