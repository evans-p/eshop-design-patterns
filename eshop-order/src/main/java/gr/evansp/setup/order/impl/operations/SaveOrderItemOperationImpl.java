package gr.evansp.setup.order.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.order.def.models.OrderItem;
import gr.evansp.setup.order.def.operations.SaveOrderItemOperation;
import gr.evansp.setup.order.def.persistence.OrderItemRepository;
import gr.evansp.setup.order.def.rules.OrderItemValidator;
import lombok.Getter;
import lombok.Setter;

public class SaveOrderItemOperationImpl implements SaveOrderItemOperation {
  @Setter
  @Getter
  OrderItem input;
  OrderItemValidator validator = Factory.create(OrderItemValidator.class);
  OrderItemRepository repository = Factory.create(OrderItemRepository.class);

  @Override
  public void execute() throws DataException, RuleException, LogicException {
    if (input == null) {
      throw new LogicException("Input(OrderItem) cannot be null.");
    }
    validator.setInput(input);
    validator.apply();
    repository.save(input);
  }
}
