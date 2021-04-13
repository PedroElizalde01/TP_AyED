package PilasyColas;


public class StackNode <T> implements StackInterface<T> {
    private Node top;
    private int size;

    public StackNode() {
        this.top = null;
        this.size = 0;
    }
    @Override
    public void stack(T element) {
        Node<T> temporalNode = new Node(element);
        temporalNode.next=top;
        top=temporalNode;
        size++;
    }

    @Override
    public void pop() throws IsEmptyException {
        if(!isEmpty()){
            top = top.next;
            size--;
        }else{
            throw new IsEmptyException();
        }

    }

    @Override
    public T peek() throws IsEmptyException {
        if(!isEmpty()){
            return (T) top.data;
        }
        throw new IsEmptyException();
    }

    @Override
    public boolean isEmpty(){
        return top == null;
    }

    @Override
    public int size(){return size;}

    @Override
    public void empty() {
        this.top=null;
        this.size=0;
    }
}