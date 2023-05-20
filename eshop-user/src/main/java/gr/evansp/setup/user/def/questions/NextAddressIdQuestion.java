package gr.evansp.setup.user.def.questions;

import gr.evansp.common.Question;
import gr.evansp.setup.user.def.models.Address;

/**
 * Interface to get the {@link Address} Id from the DB sequence.
 */
public interface NextAddressIdQuestion extends Question<Long> {
  //EMPTY
}
