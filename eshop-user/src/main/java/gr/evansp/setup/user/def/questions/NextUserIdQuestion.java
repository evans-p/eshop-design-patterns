package gr.evansp.setup.user.def.questions;

import gr.evansp.common.Question;
import gr.evansp.setup.user.def.models.User;

/**
 * Interface to get the {@link User} Id from the DB sequence.
 */
public interface NextUserIdQuestion extends Question<Long> {
}
