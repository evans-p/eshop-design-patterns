package gr.evansp.setup.order;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.Setup;
import gr.evansp.setup.order.def.models.Cart;
import gr.evansp.setup.order.def.models.CartItem;
import gr.evansp.setup.order.def.operations.SaveCartItemOperation;
import gr.evansp.setup.order.def.operations.SaveCartOperation;
import gr.evansp.setup.order.def.persistence.CartItemRepository;
import gr.evansp.setup.order.def.persistence.CartRepository;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.operations.SaveCategoryOperation;
import gr.evansp.setup.product.def.operations.SaveProductOperation;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.*;

/**
 * Integration test for {@link CartItem}.
 */
public class TestCRUDCartItemOperations extends Setup {

  @Test
  public void testCreateCartItem() throws DataException, LogicException, RuleException {
    Cart cart = createSampleCart(null);
    Category category = createSampleCategory(null);
    SaveCategoryOperation categoryOperation = Factory.create(SaveCategoryOperation.class);
    SaveProductOperation productOperation = Factory.create(SaveProductOperation.class);
    SaveCartOperation cartOperation = Factory.create(SaveCartOperation.class);
    SaveCartItemOperation sut = Factory.create(SaveCartItemOperation.class);
    CartItemRepository repository = Factory.create(CartItemRepository.class);
    CartRepository cartRepository = Factory.create(CartRepository.class);

    categoryOperation.setInput(category);
    categoryOperation.execute();

    Product product = createSampleProduct(null, category.getCategoryId());
    productOperation.setInput(product);
    productOperation.execute();

    cartOperation.setInput(cart);
    cartOperation.execute();

    CartItem cartItem = createSampleCartItem(cart.getCartId(), product.getProductId(), category.getCategoryId());
    sut.setInput(cartItem);
    sut.execute();

    assertEquals(cartItem, repository.get(cartItem));
    assertEquals(1, cartRepository.get(cart).getCartItems().size());

  }

  @Test
  public void testUpdateCartItem() throws DataException, LogicException, RuleException {
    Cart cart = createSampleCart(null);
    Category category = createSampleCategory(null);
    SaveCategoryOperation categoryOperation = Factory.create(SaveCategoryOperation.class);
    SaveProductOperation productOperation = Factory.create(SaveProductOperation.class);
    SaveCartOperation cartOperation = Factory.create(SaveCartOperation.class);
    SaveCartItemOperation sut = Factory.create(SaveCartItemOperation.class);
    CartItemRepository repository = Factory.create(CartItemRepository.class);

    categoryOperation.setInput(category);
    categoryOperation.execute();

    Product product = createSampleProduct(null, category.getCategoryId());
    productOperation.setInput(product);
    productOperation.execute();

    cartOperation.setInput(cart);
    cartOperation.execute();

    CartItem cartItem = createSampleCartItem(cart.getCartId(), product.getProductId(), category.getCategoryId());
    sut.setInput(cartItem);
    sut.execute();

    CartItem returned = repository.get(cartItem);
    returned.setCount(999L);

    sut.setInput(returned);
    sut.execute();

    CartItem f = repository.get(returned);
    assertEquals(Optional.of(999L).get(), f.getCount());
  }

  @Test
  public void testDeleteCartItem() throws DataException, LogicException, RuleException {
    Cart cart = createSampleCart(null);
    Category category = createSampleCategory(null);
    SaveCategoryOperation categoryOperation = Factory.create(SaveCategoryOperation.class);
    SaveProductOperation productOperation = Factory.create(SaveProductOperation.class);
    SaveCartOperation cartOperation = Factory.create(SaveCartOperation.class);
    SaveCartItemOperation sut = Factory.create(SaveCartItemOperation.class);
    CartItemRepository repository = Factory.create(CartItemRepository.class);
    CartRepository cartRepository = Factory.create(CartRepository.class);
    categoryOperation.setInput(category);
    categoryOperation.execute();

    Product product = createSampleProduct(null, category.getCategoryId());
    productOperation.setInput(product);
    productOperation.execute();

    cartOperation.setInput(cart);
    cartOperation.execute();

    CartItem cartItem = createSampleCartItem(cart.getCartId(), product.getProductId(), category.getCategoryId());
    sut.setInput(cartItem);
    sut.execute();
    repository.delete(cartItem);

    assertNull(repository.get(cartItem));
    assertEquals(0, cartRepository.get(cart).getCartItems().size());
  }

  @Test
  public void testGetAll() throws DataException {
    CartRepository cartRepository = Factory.create(CartRepository.class);
    assertTrue(cartRepository.getAll().size() > 0);
  }
}
