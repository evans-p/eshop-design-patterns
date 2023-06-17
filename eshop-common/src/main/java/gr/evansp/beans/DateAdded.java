package gr.evansp.beans;

import java.util.Date;

/**
 * Date Something was added to the DB.
 */
public interface DateAdded {
  /**
   * Get the date.
   *
   * @return the date.
   */
  Date getDateAdded();

  /**
   * Set the date.
   *
   * @param dateAdded the date to set.
   */
  void setDateAdded(Date dateAdded);
}
