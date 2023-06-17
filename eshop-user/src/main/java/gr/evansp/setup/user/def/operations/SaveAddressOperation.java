package gr.evansp.setup.user.def.operations;

import gr.evansp.common.Operation;
import gr.evansp.setup.user.def.models.Address;

/**
 * An operation to either save a new address to the DB, or update an
 * existing one.
 */
public interface SaveAddressOperation extends Operation {
  /**
   * Getter for the input.
   *
   * @return input(Address).
   */
  Address getInput();

  /**
   * Setter for the input.
   *
   * @param input Address to set.
   */
  void setInput(Address input);
}
