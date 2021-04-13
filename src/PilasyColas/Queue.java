package PilasyColas;

public class Queue <T> implements QueueInterface<T> {
    private int size;
    private T[] stackArray;

    public Queue() {
        this.size = 0;
        this.stackArray =(T[]) new Object[size];
    }
    @Override
    public void enqueue(Object element){
        T[] bigStackArray = (T[])new Object[stackArray.length + 1];
        for (int i = 0; i < stackArray.length; i++) bigStackArray[i+1] = stackArray[i];
        this.size = bigStackArray.length;
        this.stackArray =(T[]) bigStackArray;
        stackArray[0] = (T)element;
    }
    @Override
    public T dequeue() throws IsEmptyException {
        if(!isEmpty()) {

            T result = stackArray[size-1];
            T[] smallStackArray =(T[]) new Object[size - 1];
            for (int i = 0; i < stackArray.length-1; i++) smallStackArray[i] = stackArray[i];
            this.size = smallStackArray.length;
            this.stackArray = smallStackArray;
            return result;
        }
        throw new IsEmptyException();
    }

    @Override
    public boolean isEmpty(){
        return (size == 0);
    }

    @Override
    public int size(){
        return this.size;
    }
}