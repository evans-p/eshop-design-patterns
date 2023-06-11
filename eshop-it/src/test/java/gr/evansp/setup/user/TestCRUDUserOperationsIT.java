package gr.evansp.setup.user;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.Setup;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.operations.SaveUserOperation;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Integration test class for {@link User}.
 */
public class TestCRUDUserOperationsIT extends Setup {
  User user;

  @Ignore
  @Test
  public void testSaveNewUser() throws DataException, LogicException, RuleException {
    user = createSampleUser();
    SaveUserOperation sut = Factory.create(SaveUserOperation.class);
    sut.setInput(user);
    sut.execute();
  }
}
