package gr.evansp.setup.order.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.order.def.models.Order;
import gr.evansp.setup.order.def.operations.SaveOrderOperation;
import gr.evansp.setup.order.def.persistence.OrderRepository;
import gr.evansp.setup.order.def.questions.NextOrderIdQuestion;
import gr.evansp.setup.order.def.rules.OrderValidator;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of {@link SaveOrderOperation}.
 */
public class SaveOrderOperationImpl implements SaveOrderOperation {
  @Setter
  @Getter
  Order input;
  OrderValidator validator = Factory.create(OrderValidator.class);
  NextOrderIdQuestion question = Factory.create(NextOrderIdQuestion.class);
  OrderRepository repository = Factory.create(OrderRepository.class);

  @Override
  public void execute() throws DataException, RuleException, LogicException {
    if (input == null) {
      throw new LogicException("Input(Order) cannot be null.");
    }

    if (input.getOrderId() == null) {
      question.ask();
      input.setOrderId(question.answer());
      validator.setInput(input);
      validator.apply();
      repository.save(input);
    }
    validator.setInput(input);
    validator.apply();
    repository.update(input);
  }
}
