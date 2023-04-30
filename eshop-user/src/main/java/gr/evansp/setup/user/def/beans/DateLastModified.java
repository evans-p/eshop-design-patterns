package gr.evansp.setup.user.def.beans;

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
  public Date getDateLastModified();

  /**
   * Set the date.
   *
   * @param dateLastModified the date to set.
   */
  public void setDateLastModified(Date dateLastModified);
}
