package gr.evansp.setup.user;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.Setup;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.operations.SaveUserOperation;
import gr.evansp.setup.user.def.persistence.UserRepository;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Integration test class for {@link User}.
 */
public class TestCRUDUserOperationsIT extends Setup {
  User user;

  @Test
  public void testSaveNewUser() throws DataException, LogicException, RuleException {
    user = createSampleUser();
    SaveUserOperation sut = Factory.create(SaveUserOperation.class);
    sut.setInput(user);
    sut.execute();
  }

  @Test
  public void testUpdateUser() throws DataException, LogicException, RuleException {
    user = createSampleUser();
    SaveUserOperation sut = Factory.create(SaveUserOperation.class);
    UserRepository repository = Factory.create(UserRepository.class);
    sut.setInput(user);
    sut.execute();

    user.setPassword("new1@new.com");
    sut.execute();

    assertEquals("new1@new.com", repository.get(user).getPassword());
  }


  @Test
  public void testDeleteUser() throws DataException, LogicException, RuleException {
    user = createSampleUser();
    SaveUserOperation sut = Factory.create(SaveUserOperation.class);
    UserRepository repository = Factory.create(UserRepository.class);
    sut.setInput(user);
    sut.execute();

    repository.delete(user);

    assertNull(repository.get(user));
  }


  @Test
  public void testGetAll() throws DataException {
    UserRepository repository = Factory.create(UserRepository.class);

    assertTrue(repository.getAll().size() > 0);
  }
}
