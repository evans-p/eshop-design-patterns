package gr.evansp.setup.order;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.Setup;
import gr.evansp.setup.order.def.models.Order;
import gr.evansp.setup.order.def.models.OrderItem;
import gr.evansp.setup.order.def.operations.SaveOrderItemOperation;
import gr.evansp.setup.order.def.operations.SaveOrderOperation;
import gr.evansp.setup.order.def.persistence.OrderItemRepository;
import gr.evansp.setup.order.def.persistence.OrderRepository;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.operations.SaveCategoryOperation;
import gr.evansp.setup.product.def.operations.SaveProductOperation;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.operations.SaveUserOperation;
import org.junit.Test;

import java.util.Optional;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Integration tests for {@link OrderItem}.
 */
public class TestCRUDOrderItemOperations extends Setup {

  @Test
  public void testCreateNewOrderItem() throws DataException, LogicException, RuleException {
    User user = createSampleUser();
    SaveUserOperation userOperation = Factory.create(SaveUserOperation.class);
    userOperation.setInput(user);
    userOperation.execute();

    Category category = createSampleCategory(null);
    SaveCategoryOperation categoryOperation = Factory.create(SaveCategoryOperation.class);
    categoryOperation.setInput(category);
    categoryOperation.execute();

    Product product1 = createSampleProduct(null, category.getCategoryId());
    Product product2 = createSampleProduct(null, category.getCategoryId());

    SaveProductOperation productOperation = Factory.create(SaveProductOperation.class);
    productOperation.setInput(product1);
    productOperation.execute();

    productOperation.setInput(product2);
    productOperation.execute();

    Order order = createSampleOrder(null, user.getUserId());

    order.setOrderItems(Set.of(createSampleOrderItem(null, user.getUserId(), category.getCategoryId(),
        product1.getProductId())));
    SaveOrderOperation orderOperation = Factory.create(SaveOrderOperation.class);
    orderOperation.setInput(order);
    orderOperation.execute();

    SaveOrderItemOperation sut = Factory.create(SaveOrderItemOperation.class);

    OrderItem orderItem = createSampleOrderItem(order.getOrderId(), user.getUserId(), category.getCategoryId(),
        product2.getProductId());

    sut.setInput(orderItem);
    sut.execute();
    assertNotNull(Factory.create(OrderItemRepository.class).get(orderItem));

    assertEquals(2, Factory.create(OrderRepository.class).get(order).getOrderItems().size());
  }


  @Test
  public void testUpdateOrderItem() throws DataException, LogicException, RuleException {
    User user = createSampleUser();
    SaveUserOperation userOperation = Factory.create(SaveUserOperation.class);
    userOperation.setInput(user);
    userOperation.execute();

    Category category = createSampleCategory(null);
    SaveCategoryOperation categoryOperation = Factory.create(SaveCategoryOperation.class);
    categoryOperation.setInput(category);
    categoryOperation.execute();

    Product product1 = createSampleProduct(null, category.getCategoryId());
    Product product2 = createSampleProduct(null, category.getCategoryId());

    SaveProductOperation productOperation = Factory.create(SaveProductOperation.class);
    productOperation.setInput(product1);
    productOperation.execute();

    productOperation.setInput(product2);
    productOperation.execute();

    Order order = createSampleOrder(null, user.getUserId());

    OrderItem orderItem = createSampleOrderItem(null, user.getUserId(), category.getCategoryId(),
        product1.getProductId());

    order.setOrderItems(Set.of(orderItem));
    SaveOrderOperation orderOperation = Factory.create(SaveOrderOperation.class);
    orderOperation.setInput(order);
    orderOperation.execute();

    assertNotNull(Factory.create(OrderItemRepository.class).get(orderItem));

    orderItem.setCount(999L);
    SaveOrderItemOperation sut = Factory.create(SaveOrderItemOperation.class);
    sut.setInput(orderItem);
    sut.execute();

    assertEquals(Optional.of(999L).get(), Factory.create(OrderItemRepository.class).get(orderItem).getCount());
  }

  @Test
  public void testGetAll() throws DataException {
    OrderItemRepository repository = Factory.create(OrderItemRepository.class);

    assertTrue(repository.getAll().size() > 0);
  }


  @Test
  public void testDeleteOrderItem() throws DataException, LogicException, RuleException {
    User user = createSampleUser();
    SaveUserOperation userOperation = Factory.create(SaveUserOperation.class);
    userOperation.setInput(user);
    userOperation.execute();

    Category category = createSampleCategory(null);
    SaveCategoryOperation categoryOperation = Factory.create(SaveCategoryOperation.class);
    categoryOperation.setInput(category);
    categoryOperation.execute();

    Product product1 = createSampleProduct(null, category.getCategoryId());
    Product product2 = createSampleProduct(null, category.getCategoryId());

    SaveProductOperation productOperation = Factory.create(SaveProductOperation.class);
    productOperation.setInput(product1);
    productOperation.execute();

    productOperation.setInput(product2);
    productOperation.execute();

    Order order = createSampleOrder(null, user.getUserId());

    OrderItem orderItem = createSampleOrderItem(null, user.getUserId(), category.getCategoryId(),
        product1.getProductId());

    order.setOrderItems(Set.of(orderItem));
    SaveOrderOperation orderOperation = Factory.create(SaveOrderOperation.class);
    orderOperation.setInput(order);
    orderOperation.execute();

    assertNotNull(Factory.create(OrderItemRepository.class).get(orderItem));
    OrderItemRepository repository = Factory.create(OrderItemRepository.class);
    repository.delete(orderItem);
    assertNull(repository.get(orderItem));


    OrderRepository orderRepository = Factory.create(OrderRepository.class);
    assertEquals(0, orderRepository.get(order).getOrderItems().size());
  }
}
