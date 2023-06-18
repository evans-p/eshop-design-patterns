package gr.evansp.setup.order.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.order.def.models.Cart;
import gr.evansp.setup.order.def.operations.SaveCartOperation;
import gr.evansp.setup.order.def.questions.NextCartIdQuestion;
import gr.evansp.setup.order.def.rules.CartValidator;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of {@link SaveCartOperation}.
 */
public class SaveCartOperationImpl implements SaveCartOperation {
    @Setter
    @Getter
    Cart input;
    CartValidator cartValidator = Factory.create(CartValidator.class);
    NextCartIdQuestion question = Factory.create(NextCartIdQuestion.class);

    @Override
    public void execute() throws DataException, RuleException, LogicException {
        if (input == null) {
            throw new LogicException("Input(Cart) cannot be null.");
        }

        if (input.getCartId() == null) {
            question.ask();
            input.setCartId(question.answer());
            cartValidator.setInput(input);
            cartValidator.apply();
            //TODO: Save
        }
        cartValidator.setInput(input);
        cartValidator.apply();
        //TODO: update
    }
}
