package TP_Hash.Util;

public class DynamicList<T> implements ListInterface<T> {
    private Node<T> head, window, sentinel;
    private int size;
    public DynamicList(){
        head = new Node<>();
        sentinel = new Node<>();
        head.next = sentinel;
        window = head;
        size = 0;
    }
    @Override
    public T getActual() {
        return window.obj;
    }
    @Override
    public int getActualPosition() {
        int pos = 0;
        if (!isVoid()) {
            Node<T> aux = head;
            for (; aux.next != window; pos++) aux = aux.next;
        }
        return pos;
    }
    public boolean isVoid() {
        return head.next == sentinel;
    }
    @Override
    public boolean endList() {
        return window.next == sentinel;
    }
    public void insertPrev(T obj) {
        if (!isVoid()) {
            goBack();
        }
        insertNext(obj);
    }
    @Override
    public void insertNext(T obj) {
        window.next = new Node<>(obj, window.next);
        window = window.next;
        size++;
    }

    @Override
    public void insertBefore(T obj) {

    }

    @Override
    public void goNext() {
        if(window.next == sentinel) throw new IndexOutOfBoundsException("Reached the end of this List");
        window = window.next;
    }
    @Override
    public void goPrev() {
        if(window == head.next) throw new IndexOutOfBoundsException("Reached the beginning of this List");
        goBack();
    }
    private void goBack(){
        Node<T> aux = head;
        while(window != aux.next){
            aux = aux.next;
        }
        window = aux;
    }
    @Override
    public void goTo(int index) {
        window = head.next;
        for(int i = 0; i < index; i++){
            window = window.next;
        }
    }
    public void goFirst(){
        window=head.next;
    }
    @Override
    public void remove() {
        if(isVoid()) throw new NullPointerException("This List is empty");
        goBack();
        window.next = window.next.next;
        window = window.next;
        if(window == sentinel) goBack();
        size--;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private static class Node<E> {
        E obj;
        Node<E> next;
        Node() {
            obj = null;
            next = null;
        }
        Node(E o) {
            obj = o;
            next = null;
        }
        Node(E o, Node<E> next) {
            this(o);
            this.next = next;
        }
        boolean hasNoObj() {
            return obj == null;
        }
    }
}
