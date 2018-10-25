package Structural.TransactionalStack;

public interface IntStackTransactional {
    /**
     * @param value Adds to transaction, if no transaction then directly into the stack.
     * @return the value input.
     */
    int push(int value);

    /**
     * Removes the last inserted value in the transaction, if no transaction, then directly removes the last one inserted in the stack.
     * @return
     */
    int pop();

    /**
     * @return if the stack is empty or not
     */
    boolean empty();

    /**
     * Open a new transaction, can be used nested
     */
    void open();

    /**
     * Commits the transaction
     * @return true if successfully committed the transaction, if no transaction then false
     */
    boolean commit();

    /**
     * Rollbacks the transaction
     * @return true if successfully rollback the transaction, if no transaction then false
     */
    boolean rollback();
}
