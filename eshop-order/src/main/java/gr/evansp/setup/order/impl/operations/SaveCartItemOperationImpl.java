package gr.evansp.setup.order.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.order.def.models.CartItem;
import gr.evansp.setup.order.def.operations.SaveCartItemOperation;
import gr.evansp.setup.order.def.persistence.CartItemRepository;
import gr.evansp.setup.order.def.rules.CartItemValidator;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of {@link SaveCartItemOperation}.
 */
public class SaveCartItemOperationImpl implements SaveCartItemOperation {
    @Setter
    @Getter
    CartItem input;
    CartItemValidator validator = Factory.create(CartItemValidator.class);
    CartItemRepository repository = Factory.create(CartItemRepository.class);


    @Override
    public void execute() throws DataException, RuleException, LogicException {
        if (input == null) {
            throw new LogicException("Input(CartItem) cannot be null.");
        }
        validator.setInput(input);
        validator.apply();
        repository.save(input);
    }
}
