package gr.evansp.common;

import gr.evansp.exceptions.LogicException;

/**
 * Transformation of an object to a different on.
 *
 * @param <T> type of input object.
 * @param <U> type of output object.
 */
public interface Transformation<T, U> extends Entity {
    /**
     * set the input.
     *
     * @param input input
     */
    void setInput(T input);

    /**
     * get the output.
     *
     * @return output.
     */
    U getOutput();

    /**
     * perform transformation
     */
    void transform() throws LogicException;
}
