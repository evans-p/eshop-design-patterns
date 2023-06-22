package gr.evansp.setup.order.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.order.def.models.Cart;
import gr.evansp.setup.order.def.persistence.CartRepository;
import gr.evansp.setup.order.def.questions.NextCartIdQuestion;
import gr.evansp.setup.order.def.rules.CartValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

/**
 * Tests for {@link SaveCartOperationImpl}.
 */
public class TestSaveCartOperationImpl {
  SaveCartOperationImpl sut;

  @Before
  public void setUp() {
    sut = Factory.create(SaveCartOperationImpl.class);
    sut.input = Factory.create(Cart.class);
    sut.cartValidator = mock(CartValidator.class);
    sut.question = mock(NextCartIdQuestion.class);
    sut.repository = mock(CartRepository.class);

    sut.input.setCartId(1L);
  }

  /**
   * Test for {@link SaveCartOperationImpl#getInput()}
   */
  @Test
  public void testGetInput() {
    Cart cart = mock(Cart.class);
    sut.setInput(cart);
    assertSame(cart, sut.getInput());
  }

  /**
   * Test for {@link SaveCartOperationImpl#execute()}
   * null Input.
   */
  @Test(expected = LogicException.class)
  public void testExecute_nullInput() throws DataException, LogicException, RuleException {
    sut.input = null;
    sut.execute();
  }

  /**
   * Test for {@link SaveCartOperationImpl#execute()}
   * no cart Id.
   */
  @Test
  public void testExecute_noCartID() throws DataException, LogicException, RuleException {
    sut.input.setCartId(null);
    sut.execute();
  }

  /**
   * Test for {@link SaveCartOperationImpl#execute()}
   * ok.
   */
  @Test
  public void testExecute_ok() throws DataException, LogicException, RuleException {
    sut.execute();
  }

}