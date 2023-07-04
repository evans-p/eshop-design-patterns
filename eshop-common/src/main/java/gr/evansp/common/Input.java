package gr.evansp.common;

/**
 * Something with an input
 *
 * @param <M> input parameter
 */
public interface Input<M extends Entity> {
    /**
     * Getter for the input.
     *
     * @return input.
     */
    M getInput();

    /**
     * Setter for the input.
     *
     * @param input Input to set.
     */
    void setInput(M input);
}
