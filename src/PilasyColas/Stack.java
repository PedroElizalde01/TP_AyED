package PilasyColas;

public class Stack<T> implements StackInterface {
    private int size;
    private T[] stackArray;

    public Stack() {
        this.size = 0;
        this.stackArray = (T[])new Object[size];
    }

    @Override
    public void stack(Object element){
        T[] bigStackArray = (T[]) new Object[stackArray.length + 1];
        for (int i = 0; i < stackArray.length; i++) bigStackArray[i+1] = stackArray[i];
        this.size = bigStackArray.length;
        this.stackArray = bigStackArray;
        stackArray[0] = (T) element;
    }

    @Override
    public void pop() {
        T[] smallStackArray = (T[]) new Object[size - 1];
        for (int i = 0; i < smallStackArray.length; i++) smallStackArray[i] = stackArray[i+1];
        this.size = smallStackArray.length;
        this.stackArray = smallStackArray;
    }

    @Override
    public T peek() {
        if(!isEmpty()){
                return stackArray[size-1];
        }
        return null;
    }

    @Override
    public boolean isEmpty(){
        return (size == 0);
    }

    @Override
    public int size(){
        return this.size;
    }

    @Override
    public void empty() {
        T[] emptyStack = (T[])new Object[0];
        this.stackArray = emptyStack;
    }
}
