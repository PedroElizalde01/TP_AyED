package TPComparacióndeArboles;

import PilasyColas.IsEmptyException;
import PilasyColas.StackNode;
/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 20/04/2021
 **************************************/

public class AVL<T> {
    private NodoDoble<T> root;

    public AVL() {
        root = null;
    }

    // precondicion: elemento a insertar no pertenece al árbol
    public void insert(Comparable<T> x) throws DuplicatedObjectException {
        if (exists(x)) {
            throw new DuplicatedObjectException();
        }
        try{
            root = insert(root, x);
        } catch (IsEmptyException e) {
            e.printStackTrace();
        }
    }

    // precondicion: elemento a eliminar pertenece al árbol
    public void delete(Comparable<T> x) throws DuplicatedObjectException {
        if (exists(x)) {
            throw new DuplicatedObjectException();
        }
        root = delete(root, x);
    }

    // precondicion: árbol distinto de vacío
    public T getMin() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException();
        }
        return getMin(root).elem;
    }

    // precondicion: árbol distinto de vacío
    public T getMax() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException();
        }
        return getMax(root).elem;
    }

    // precondicion: elemento a buscar pertenece al arbol
    public T search(Comparable<T> x) throws NewObjectException {
        if (!exists(x)) {
            throw new NewObjectException();
        }
        return search(root, x).elem;
    }

    // precondicion: -
    public boolean exists(Comparable<T> x) {
        return exists(root, x);
    }

    // precondicion: -
    public boolean isEmpty() {
        return (root == null);
    }

    // precondición: árbol distino de vacío
    public T getRoot() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException();
        }
        return root.elem;
    }

    // precondición: árbol distino de vacío
    public AVL<T> getLeft() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException();
        }
        AVL<T> t = new AVL<T>();
        t.root = root.izq;
        return t;
    }

    // precondición: árbol distino de vacío
    public AVL<T> getRight() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException();
        }
        AVL<T> t = new AVL<T>();
        t.root = root.der;
        return t;
    }


    // METODOS PRIVADOS
    private NodoDoble<T> getMax(NodoDoble<T> t) {
        if (t.der == null)
            return t;
        else
            return getMax(t.der);
    }

    private NodoDoble<T> getMin(NodoDoble<T> t) {
        if (t.izq == null)
            return t;
        else
            return getMin(t.izq);
    }

    private NodoDoble<T> search(NodoDoble<T> t, Comparable<T> x) {
        if (x.compareTo(t.elem) == 0)
            return t;
        else if (x.compareTo(t.elem) < 0)
            return search(t.izq, x);
        else
            return search(t.der, x);
    }

    private boolean exists(NodoDoble<T> t, Comparable<T> x) {
        if (t == null)
            return false;
        if (x.compareTo(t.elem) == 0)
            return true;
        else if (x.compareTo(t.elem) < 0)
            return exists(t.izq, x);
        else
            return exists(t.der, x);
    }


    private NodoDoble<T> insert(NodoDoble<T> t, Comparable<T> x) throws IsEmptyException{
        StackNode<NodoDoble<T>> stack = new StackNode<>();
        if (t == null){
            t = new NodoDoble<T>();
            t.elem = (T) x;
        }
        else if (x.compareTo(t.elem) < 0) {
            t.izq = insert(t.izq, x);
        }else{
            t.der = insert(t.der, x);
        }
        stack = nodeJourney(t, x, stack);
        NodoDoble<T> unbalancedNode= isEstable(stack);
        NodoDoble<T> aux= new NodoDoble<>();
        if(unbalancedNode==null){
            return t;
        }
        if (height(unbalancedNode.izq)>height(unbalancedNode.der)){
            if(unbalancedNode.izq.izq!=null){
                aux= rotateWithLeftChild(unbalancedNode);
            }else{
                aux= doubleWithLeftChild(unbalancedNode);
            }
        }else{
            if(unbalancedNode.der.der!=null){
                aux= rotateWithRightChild(unbalancedNode);
            }else{
                aux= doubleWithRightChild(unbalancedNode);
            }
        }
        if(unbalancedNode==getRootOfTree()){
            return aux;
        }
        return t;
    }


    private NodoDoble<T> delete(NodoDoble<T> t, Comparable<T> x) {
        if (x.compareTo(t.elem) < 0)
            t.izq = delete(t.izq, x);
        else if (x.compareTo(t.elem) > 0)
            t.der = delete(t.der, x);
        else if (t.izq != null && t.der != null) {
            t.elem = getMin(t.der).elem;
            t.der = deleteMin(t.der);
        } else if (t.izq != null)
            t = t.izq;
        else
            t = t.der;
        return t;
    }

    private NodoDoble<T> deleteMin(NodoDoble<T> t) {
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
    private StackNode<NodoDoble<T>> nodeJourney(NodoDoble<T> t, Comparable<T> x, StackNode<NodoDoble<T>> stack){
        // Devuelve el camino que hace para insertar el nodo nuevo y lo inserta
        if (t == null){
            t = new NodoDoble<T>();
            t.elem = (T) x;
        }
        else if (x.compareTo(t.elem) < 0) {
            stack.stack(t);
            stack = nodeJourney(t.izq, x, stack);
        }else{
            stack.stack(t);
            stack = nodeJourney(t.der, x, stack);
        }
        return stack;
    }

    private NodoDoble<T> isEstable(StackNode<NodoDoble<T>> nodeStack) throws IsEmptyException{
        if(nodeStack.isEmpty()){
            return null;
        }
        NodoDoble<T> node= nodeStack.peek();
        int dif= Math.abs(height(node.izq) - height(node.der));
        if ( dif<=1 ) {
            nodeStack.pop();
            return isEstable(nodeStack);
        } else {
            return node;
        }
    }
    private NodoDoble<T> rotateWithLeftChild( NodoDoble<T> k2 ){
        NodoDoble<T> k1 = k2.izq;
        k2.izq = k1.der;
        k1.der = k2;
        return k1;
    }
    private NodoDoble<T> rotateWithRightChild( NodoDoble<T> k1 )
    {
        NodoDoble<T> k2 = k1.der;
        k1.der = k2.izq;
        k2.izq = k1;
        return k2;
    }
    private NodoDoble<T> doubleWithLeftChild( NodoDoble<T> k3 )
    {
        k3.izq = rotateWithRightChild( k3.izq );
        return rotateWithLeftChild( k3 );
    }
    private NodoDoble<T> doubleWithRightChild( NodoDoble<T> k1 )
    {
        k1.der = rotateWithLeftChild( k1.der );
        return rotateWithRightChild( k1 );
    }

    public NodoDoble<T> getRootOfTree(){
        return root;
    }

    public int amountOfTries(NodoDoble<T> t, Comparable<T> x, int counter){
        if (x.compareTo(t.elem) == 0)
            return counter;
        else if (x.compareTo(t.elem) < 0)
            return amountOfTries(t.izq, x ,++counter);
        else
            return amountOfTries(t.der, x,++counter);
    }
}
