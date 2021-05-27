package TPComparacióndeArboles;

import BinarySearchTree.NodoDoble;
import PilasyColas.IsEmptyException;
import PilasyColas.StackNode;

/**************************************
     Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
     Date: 20/04/2021
 **************************************/

    public class BlackAndRedTree<T extends Comparable<T>> {
        private NodoBnR<T> root;

        public BlackAndRedTree(){
            root = null;
        }

        // precondicion: elemento a insertar no pertenece al árbol
        public void insert(Comparable <T> x) throws DuplicatedObjectException, IsEmptyException {
            if(exists(x)){
                throw new DuplicatedObjectException();
            }

            root = insert(root, x);
            if (root.isRed){
                root.isRed=false;
            }
        }


        // precondicion: elemento a eliminar pertenece al árbol
        public void delete(Comparable <T> x) throws DuplicatedObjectException {
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
        public T search(Comparable<T> x) throws NewObjectException {
            if(!exists(x)){
                throw new NewObjectException();
            }
            return search(root, x).elem;
        }

        // precondicion: -
        public boolean exists(Comparable<T> x){
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
        public BlackAndRedTree<T> getLeft() throws EmptyException {
            if(isEmpty()) {
                throw new EmptyException();
            }
            BlackAndRedTree<T> t = new BlackAndRedTree<T>();
            t.root = root.izq;
            return t;
        }

        // precondición: árbol distino de vacío
        public BlackAndRedTree<T> getRight() throws EmptyException {
            if (isEmpty()){
                throw new EmptyException();
            }
            BlackAndRedTree<T> t = new BlackAndRedTree<T>();
            t.root = root.der;
            return t;
        }


        // METODOS PRIVADOS
        private NodoBnR<T> getMax(NodoBnR<T> t){
            if (t.der == null)
                return t;
            else
                return getMax(t.der);
        }

        private NodoBnR<T> getMin(NodoBnR<T> t){
            if (t.izq == null)
                return t;
            else
                return getMin(t.izq);
        }

        private NodoBnR<T> search(NodoBnR<T> t, Comparable<T> x){
            if (x.compareTo(t.elem)== 0)
                return t;
            else if (x.compareTo( t.elem)< 0)
                return search(t.izq, x);
            else
                return search(t.der, x);
        }

        private boolean exists(NodoBnR<T> t, Comparable<T> x) {
            if (t == null)
                return false;
            if (x.compareTo(t.elem) == 0)
                return true;
            else if (x.compareTo( t.elem)< 0)
                return exists(t.izq, x);
            else
                return exists(t.der, x);
        }

        private NodoBnR<T> insert(NodoBnR<T> t, Comparable <T> x) throws IsEmptyException {
            StackNode<NodoBnR<T>> stack = new StackNode<>();
            if (t == null) {
                t = new NodoBnR<T>();
                t.elem = (T) x;
            } else if (x.compareTo(t.elem) < 0) {
                t.izq = insert(t.izq, x);

            }else{
                t.der = insert(t.der, x);
            }
            stack = nodeJourney(t, x, stack);
            if(stack.size()>=3) {
                while(!isEstable(t)) {
                    NodoBnR<T> nodeSon = stack.peek();
                    stack.pop();
                    NodoBnR<T> nodeFather = stack.peek();
                    stack.pop();
                    NodoBnR<T> grandfatherNode = stack.peek();
                    if (grandfatherNode.izq != null && grandfatherNode.der != null) {
                        //Caso 2
                        if (grandfatherNode.izq.equals(nodeFather)) {
                            if (grandfatherNode.der.isRed) {
                                t = changeColors2ndCaseRedBrother(grandfatherNode);
                            } else {
                                if (nodeSon.elem.compareTo(nodeFather.elem) > 0) {
                                    t= doubleWithLeftChild(grandfatherNode);
                                    t.der.isRed = true;
                                    t.izq.isRed = true;
                                    t.isRed = false;
                                } else {
                                    t = rotateWithLeftChild(grandfatherNode);
                                    t.der.isRed = true;
                                    t.izq.isRed = true;
                                    t.isRed = false;
                                }
                            }
                        } else {
                            if (grandfatherNode.izq.isRed) {
                                t = changeColors2ndCaseRedBrother(t);
                            } else {
                                if (nodeSon.elem.compareTo(nodeFather.elem) > 0) {
                                    t= rotateWithRightChild(grandfatherNode);
                                    t.der.isRed = true;
                                    t.izq.isRed = true;
                                    t.isRed = false;
                                } else {
                                    t= doubleWithRightChild(grandfatherNode);
                                    t.der.isRed = true;
                                    t.izq.isRed = true;
                                    t.isRed = false;
                                }
                            }
                        }
                    } else {
                        if (grandfatherNode.izq!=null && grandfatherNode.izq.equals(nodeFather)) {
                            if (nodeFather.izq != null) {
                                t = rotateWithLeftChild(grandfatherNode);
                                t.isRed = false;
                                t.izq.isRed = true;
                                t.der.isRed = true;
                            } else {
                                t = doubleWithLeftChild(grandfatherNode);
                                t.der.isRed = true;
                                t.izq.isRed = true;
                                t.isRed = false;
                            }
                        } else {
                            if (nodeFather.der != null) {
                                t = rotateWithRightChild(grandfatherNode);
                                t.der.isRed = true;
                                t.izq.isRed = true;
                                t.isRed = false;
                            } else {
                                t = doubleWithRightChild(grandfatherNode);
                                t.der.isRed = true;
                                t.izq.isRed = true;
                                t.isRed = false;
                            }
                        }
                    }
                }
            }
            return t;
        }

    private NodoBnR<T> changeColors2ndCaseRedBrother(NodoBnR<T> granfather) {
            granfather.isRed = true;
            granfather.izq.isRed = false;
            granfather.der.isRed = false;
            return granfather;
    }


    private NodoBnR<T> delete(NodoBnR<T> t, Comparable<T> x) {
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

        private NodoBnR<T> deleteMin(NodoBnR<T> t){
            if (t.izq != null)
                t.izq = deleteMin(t.izq);
            else
                t = t.der;
            return t;
        }
        private boolean isEstable(NodoBnR<T> t){
            if (isSonRed(t) != null || mismaCantidadDeNodosNegros(t,0,0) == -1){
                return false;
            }
            return true;
        }

        private int mismaCantidadDeNodosNegros(NodoBnR<T> node, int cantizq, int cantder){
            if(node != null){
                cantizq = mismaCantidadDeNodosNegros(node.izq,cantizq,cantder);
                cantder = mismaCantidadDeNodosNegros(node.der,cantizq,cantder);
                if (cantder != cantizq){
                    return -1;
                }
            }
            return 1;
        }
    private NodoBnR<T> isSonRed(NodoBnR<T> node) {
        if (node != null) {
            if ((node.izq!=null && node.izq.isRed && node.isRed) || (node.der != null && node.der.isRed && node.isRed)) {
                return node;
            } else {
                if(isSonRed(node.izq)==null){
                    return isSonRed(node.der);
                }
                return isSonRed(node.izq);
            }
        }
        return null;
    }

    private NodoBnR<T> rotateWithLeftChild( NodoBnR<T> k2 ){
        NodoBnR<T> k1 = k2.izq;
        k2.izq = k1.der;
        k1.der = k2;
        return k1;
    }
    private NodoBnR<T> rotateWithRightChild( NodoBnR<T> k1)
    {
        NodoBnR<T> k2 = k1.der;
        k1.der = k2.izq;
        k2.izq = k1;
        return k2;
    }
    private NodoBnR<T> doubleWithLeftChild( NodoBnR<T> k3 )
    {
        k3.izq = rotateWithRightChild( k3.izq );
        return rotateWithLeftChild( k3 );
    }
    private NodoBnR<T> doubleWithRightChild( NodoBnR<T> k1 )
    {
        k1.der = rotateWithLeftChild( k1.der );
        return rotateWithRightChild( k1 );
    }
    private NodoBnR<T> changeColors(NodoBnR<T> k1){
            k1.isRed=false;
            return k1;
    }

    private StackNode<NodoBnR<T>> nodeJourney(NodoBnR<T> t, Comparable<T> x, StackNode<NodoBnR<T>> stack){
        // Devuelve el camino que hace para insertar el nodo nuevo y lo inserta
        if (t == null) {
            t = new NodoBnR<T>();
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
    public int height(NodoBnR<T> t) {
        if (t!=null) {
            int heigthLeft = height(t.izq);
            int heightRight = height(t.der);
            return 1 + Math.max(heigthLeft, heightRight);
        } else {
            return -1;
        }
    }
    public NodoBnR<T> getRootOfTree(){
        return root;
    }

    public int amountOfTries(NodoBnR <T> t, Comparable<T> x, int counter) {
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

