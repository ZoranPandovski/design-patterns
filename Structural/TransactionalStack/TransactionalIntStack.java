package Structural.TransactionalStack;

import java.util.Stack;

public class TransactionalIntStack implements IntStackTransactional {
    Stack<TransactionalIntStack> transactions;
    Stack<Integer> integers;

    @Override
    public int push(int value) {
        if(transactions.empty()) {
            return integers.push(value);
        }
        return transactions.peek().push(value);
    }

    @Override
    public int pop() {
        if(transactions.empty()) {
            return integers.pop();
        }
        return transactions.peek().pop();
    }

    @Override
    public boolean empty() {
        return integers.empty();
    }

    @Override
    public void open() {
        transactions.push(new TransactionalIntStack());
    }

    @Override
    public boolean commit() {
        if(!transactions.empty()) {
            TransactionalIntStack lastTransaction = transactions.pop();
            return transactions.peek().integers.addAll(lastTransaction.integers);
        }
        return false;
    }

    @Override
    public boolean rollback() {
        if(!transactions.empty()) {
            transactions.pop();
            return true;
        }
        return false;
    }
}
