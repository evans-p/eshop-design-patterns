package gr.evansp.setup.order.impl.operations;

import gr.evansp.exceptions.LogicException;
import gr.evansp.setup.order.def.models.Order;
import gr.evansp.setup.order.def.operations.SaveOrderOperation;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of {@link SaveOrderOperation}.
 */
public class SaveOrderOperationImpl implements SaveOrderOperation {
    @Setter
    @Getter
    Order input;


    @Override
    public void execute() throws LogicException {
        if (input == null) {
            throw new LogicException("Input(Order) cannot be null.");
            //TODO
        }
    }
}
