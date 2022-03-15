package framework.strategy;

public interface TransactionAlertStrategy<T> {

    void checkForAlert(T t);
}
