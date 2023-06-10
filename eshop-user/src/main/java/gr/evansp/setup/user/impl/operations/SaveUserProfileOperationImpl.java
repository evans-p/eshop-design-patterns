package gr.evansp.setup.user.impl.operations;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.UserProfile;
import gr.evansp.setup.user.def.operations.SaveUserProfileOperation;
import gr.evansp.setup.user.def.rules.UserProfileValidator;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of {@link SaveUserProfileOperation}.
 */
public class SaveUserProfileOperationImpl implements SaveUserProfileOperation {
  UserProfileValidator validator = Factory.create(UserProfileValidator.class);
  DAO<UserProfile> dao = Factory.createPersistence(UserProfile.class);
  @Setter
  @Getter
  UserProfile input;

  @Override
  public void execute() throws DataException, RuleException, LogicException {
    if (input == null) {
      throw new LogicException("Input(UserProfile) cannot be null.");
    }

    validator.setInput(input);
    validator.apply();

    dao.update(input);
  }
}
