package gr.evansp.setup.order;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.Setup;
import gr.evansp.setup.order.def.models.Cart;
import gr.evansp.setup.order.def.operations.SaveCartOperation;
import gr.evansp.setup.order.def.persistence.CartRepository;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.*;

/**
 * Itegration tests for {@link Cart}
 */
public class TestCRUDCartOperations extends Setup {

  @Test
  public void testSaveCart() throws DataException, LogicException, RuleException {
    Cart cart = createSampleCart(null);
    SaveCartOperation sut = Factory.create(SaveCartOperation.class);
    sut.setInput(cart);
    sut.execute();

    CartRepository repository = Factory.create(CartRepository.class);

    Cart returned = repository.get(cart);

    assertEquals(cart.getCartId(), returned.getCartId());
    assertEquals(0, returned.getCartItems().size());
  }

  @Test
  public void testGetAll() throws DataException {
    CartRepository repository = Factory.create(CartRepository.class);

    List<Cart> returned = repository.getAll();
    assertTrue(returned.size() > 0);
  }


  @Test
  public void testDeleteCart() throws DataException, LogicException, RuleException {
    Cart cart = createSampleCart(null);
    SaveCartOperation sut = Factory.create(SaveCartOperation.class);
    sut.setInput(cart);
    sut.execute();

    CartRepository repository = Factory.create(CartRepository.class);

    repository.delete(cart);
    assertNull(repository.get(cart));
  }
}
