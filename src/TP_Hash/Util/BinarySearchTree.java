package TP_Hash.Util;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 20/04/2021
 **************************************/

public class BinarySearchTree<T> {

    private NodoDoble<T> root;

    public BinarySearchTree(){
        root = null;
    }

    // precondicion: elemento a insertar no pertenece al árbol
    public void insert(Comparable x) throws DuplicatedObjectException {
        root = insert(root, x);
    }


    // precondicion: elemento a eliminar pertenece al árbol
    public void delete(Comparable x) throws DuplicatedObjectException {
        if(exists(x)){
            throw new DuplicatedObjectException();
        }
        root = delete(root, x);
    }

    // precondicion: árbol distinto de vacío
    public T getMin() throws EmptyException {
        if(isEmpty()){
            throw new EmptyException();
            }
        return getMin(root).elem;
    }

    // precondicion: árbol distinto de vacío
    public T getMax()throws EmptyException {
        if(isEmpty()){
            throw new EmptyException();
        }
        return getMax(root).elem;
    }

    // precondicion: elemento a buscar pertenece al arbol
    public T search(Comparable x) throws NewObjectException {
        if(!exists(x)){
            throw new NewObjectException();
        }
        return search(root, x).elem;
    }

    // precondicion: -
    public boolean exists(Comparable x){
        return exists(root, x);
    }

    // precondicion: -
    public boolean isEmpty(){
        return (root == null);
    }

    // precondición: árbol distino de vacío
    public T getRoot() throws EmptyException {
        if(isEmpty()) {
            throw new EmptyException();
        }
        return root.elem;
    }

    // precondición: árbol distino de vacío
    public BinarySearchTree getLeft() throws EmptyException {
        if(isEmpty()) {
            throw new EmptyException();
        }
        BinarySearchTree t = new BinarySearchTree();
        t.root = root.izq;
        return t;
    }

    // precondición: árbol distino de vacío
    public BinarySearchTree<T> getRight() throws EmptyException {
        if (isEmpty()){
            throw new EmptyException();
        }
        BinarySearchTree<T> t = new BinarySearchTree<T>();
        t.root = root.der;
        return t;
    }


    // METODOS PRIVADOS
    private NodoDoble<T> getMax(NodoDoble<T> t){
        if (t.der == null)
            return t;
        else
            return getMax(t.der);
    }

    private NodoDoble<T> getMin(NodoDoble<T> t){
        if (t.izq == null)
            return t;
        else
            return getMin(t.izq);
    }

    private NodoDoble<T> search(NodoDoble<T> t, Comparable x){
        if (x.compareTo(t.elem)== 0)
            return t;
        else if (x.compareTo( t.elem)< 0)
            return search(t.izq, x);
        else
            return search(t.der, x);
    }

    private boolean exists(NodoDoble<T> t, Comparable x) {
        if (t == null)
            return false;
        if (x.compareTo(t.elem) == 0)
            return true;
        else if (x.compareTo( t.elem)< 0)
            return exists(t.izq, x);
        else
            return exists(t.der, x);
    }


    private NodoDoble<T> insert (NodoDoble<T> t, Comparable x) {
        if (t == null){
            t = new NodoDoble<T>();
            t.elem = (T) x;
        }
        else if (x.compareTo(t.elem) < 0)
            t.izq = insert(t.izq, x);
        else
            t.der = insert(t.der, x);
        return t;
    }


    private NodoDoble<T> delete (NodoDoble<T> t, Comparable x) {
        if (x.compareTo(t.elem) < 0)
            t.izq = delete(t.izq, x);
        else if (x.compareTo(t.elem) > 0)
            t.der = delete(t.der, x);
        else
        if (t.izq != null && t.der != null ) {
            t.elem = getMin(t.der).elem;
            t.der = deleteMin(t.der);
        }
        else if (t.izq != null)
            t = t.izq;
        else
            t =t.der;
        return t;
    }

    private NodoDoble<T> deleteMin(NodoDoble<T> t){
        if (t.izq != null)
            t.izq = deleteMin(t.izq);
        else
            t = t.der;
        return t;
    }
    public int height(NodoDoble<T> t) {
        if (t!=null) {
            int heigthLeft = height(t.izq);
            int heightRight = height(t.der);
            return 1 + Math.max(heigthLeft, heightRight);
        } else {
            return -1;
        }
    }
    public NodoDoble<T> getRootOfTree(){
        return root;
    }
    public int amountOfTries(NodoDoble<T> t, Comparable x, int counter) {
        if (x.compareTo(t.elem) == 0)
            return counter;
        else if (x.compareTo(t.elem) < 0) {
            counter++;
            return amountOfTries(t.izq, x, counter);
        } else {
            counter++;
            return amountOfTries(t.der, x, counter);
        }
    }
}

