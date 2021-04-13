package PilasyColas;


public class QueueNode <T> implements QueueInterface<T> {
    private Node top;
    private Node bot;
    private int size;

    public QueueNode(){
        this.top = null;
        this.bot = null;
        this.size = 0;
    }


    @Override
    public void enqueue(T element) {
        if(isEmpty()){
            bot = new Node();
            bot.data = element;
            top = bot;
        } else {
            Node temporalNode = new Node();
            temporalNode.data = element;
            bot.next = temporalNode;
            bot = temporalNode;
        }
        size++;
    }

    @Override
    public T dequeue() throws IsEmptyException {
        if(!isEmpty()){
            T data = (T) top.data;
            if(top == bot){
                top=null;
                bot=null;
            }else{
                top=top.next;
            }
            size--;
            return data;
        }else{
            throw new IsEmptyException();
        }

    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }
}
