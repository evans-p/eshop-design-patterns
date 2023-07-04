package gr.evansp.setup.order.def.models;

import gr.evansp.beans.DateAdded;
import gr.evansp.beans.DateLastModified;
import gr.evansp.common.Entity;
import gr.evansp.setup.order.def.beans.OrderItems;
import gr.evansp.setup.order.def.beans.Status;
import gr.evansp.setup.user.def.beans.*;

/**
 * Eshop Order.
 */
public interface Order extends OrderPK, Status, OrderItems, DateAdded, DateLastModified, StreetName,
        StreetNumber, PostalCode, City, Country, Entity {
    //EMPTY
}
