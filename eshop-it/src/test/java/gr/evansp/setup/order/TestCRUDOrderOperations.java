package gr.evansp.setup.order;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.Setup;
import gr.evansp.setup.order.def.models.Order;
import gr.evansp.setup.order.def.operations.SaveOrderOperation;
import gr.evansp.setup.order.def.persistence.OrderRepository;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.operations.SaveCategoryOperation;
import gr.evansp.setup.product.def.operations.SaveProductOperation;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.operations.SaveUserOperation;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Integration tests for {@link Order}.
 */
public class TestCRUDOrderOperations extends Setup {

  @Test
  public void testCreateNewOrder() throws DataException, LogicException, RuleException {

    User user = createSampleUser();
    SaveUserOperation userOperation = Factory.create(SaveUserOperation.class);
    userOperation.setInput(user);
    userOperation.execute();

    Category category = createSampleCategory(null);
    SaveCategoryOperation categoryOperation = Factory.create(SaveCategoryOperation.class);
    categoryOperation.setInput(category);
    categoryOperation.execute();

    Product product = createSampleProduct(null, category.getCategoryId());

    SaveProductOperation productOperation = Factory.create(SaveProductOperation.class);
    productOperation.setInput(product);
    productOperation.execute();

    Order order = createSampleOrder(null, user.getUserId());

    order.setOrderItems(Set.of(createSampleOrderItem(null, user.getUserId(), category.getCategoryId(),
        product.getProductId())));
    SaveOrderOperation sut = Factory.create(SaveOrderOperation.class);
    sut.setInput(order);
    sut.execute();

    assertNotNull(Factory.create(OrderRepository.class).get(order));
  }


  @Test
  public void testUpdateOrder() throws DataException, LogicException, RuleException {

    User user = createSampleUser();
    SaveUserOperation userOperation = Factory.create(SaveUserOperation.class);
    userOperation.setInput(user);
    userOperation.execute();

    Category category = createSampleCategory(null);
    SaveCategoryOperation categoryOperation = Factory.create(SaveCategoryOperation.class);
    categoryOperation.setInput(category);
    categoryOperation.execute();

    Product product = createSampleProduct(null, category.getCategoryId());

    SaveProductOperation productOperation = Factory.create(SaveProductOperation.class);
    productOperation.setInput(product);
    productOperation.execute();

    Order order = createSampleOrder(null, user.getUserId());

    order.setOrderItems(Set.of(createSampleOrderItem(null, user.getUserId(), category.getCategoryId(),
        product.getProductId())));
    SaveOrderOperation sut = Factory.create(SaveOrderOperation.class);
    sut.setInput(order);
    sut.execute();

    order.setPostalCode("999");
    sut.execute();
    OrderRepository repository = Factory.create(OrderRepository.class);
    assertEquals("999", repository.get(order).getPostalCode());
  }

  @Test
  public void tesDeleteOrder() throws DataException, LogicException, RuleException {

    User user = createSampleUser();
    SaveUserOperation userOperation = Factory.create(SaveUserOperation.class);
    userOperation.setInput(user);
    userOperation.execute();

    Category category = createSampleCategory(null);
    SaveCategoryOperation categoryOperation = Factory.create(SaveCategoryOperation.class);
    categoryOperation.setInput(category);
    categoryOperation.execute();

    Product product = createSampleProduct(null, category.getCategoryId());

    SaveProductOperation productOperation = Factory.create(SaveProductOperation.class);
    productOperation.setInput(product);
    productOperation.execute();

    Order order = createSampleOrder(null, user.getUserId());

    order.setOrderItems(Set.of(createSampleOrderItem(null, user.getUserId(), category.getCategoryId(),
        product.getProductId())));
    SaveOrderOperation sut = Factory.create(SaveOrderOperation.class);
    sut.setInput(order);
    sut.execute();

    OrderRepository repository = Factory.create(OrderRepository.class);
    repository.delete(order);
    assertNull(repository.get(order));
  }


  @Test
  public void tesGetAllOrders() throws DataException {

    OrderRepository repository = Factory.create(OrderRepository.class);
    assertTrue(repository.getAll().size() > 0);
  }
}
