package gr.evansp.beans;

import java.util.Date;

/**
 * Date something was last modified.
 */
public interface DateLastModified {
  /**
   * Get the date.
   *
   * @return the date.
   */
  Date getDateLastModified();

  /**
   * Set the date.
   *
   * @param dateLastModified the date to set.
   */
  void setDateLastModified(Date dateLastModified);
}
