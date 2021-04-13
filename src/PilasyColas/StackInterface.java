package PilasyColas;

public interface StackInterface<T> {
    
    boolean isEmpty();
    T peek() throws IsEmptyException;
    void pop() throws IsEmptyException;
    void stack(T element);
    int size();
    void empty();

}
