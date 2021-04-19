package BinaryTree;

import PilasyColas.IsEmptyException;
import PilasyColas.QueueNode;

import java.lang.instrument.IllegalClassFormatException;
import java.util.ArrayList;

/*******************************
 Auhor/s: Timoteo Sánchez Varsallona, Juan Pablo Senmartin, Pedro Elizlde Acevedo
 Date: 30/3/2021/03/2021
 *********************************/
public class BinaryTreeAPI <T> {
    public int peso(BinaryTree<T> a) {
        if (a.isEmpty())
            return 0;
        else
            return 1 + peso(a.getLeft()) + peso(a.getRight());
    }

    public int numeroDeHojas(BinaryTree<T> a) {
        return auxiliar(a, 0);
    }

    public int auxiliar(BinaryTree<T> a, int counter) {
        if (!a.isEmpty()) {
            counter = auxiliar(a.getLeft(), counter);
            if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
                counter++;
            }
            counter = auxiliar(a.getRight(), counter);
        }
        return counter;
    }

    public int ocurrenciesOf(BinaryTree<T> a, T o) {
        if (a.isEmpty())
            return 0;
        if (a.getRoot().equals(o))
            return
                    1 + ocurrenciesOf(a.getLeft(), o) + ocurrenciesOf(a.getRight(), o);
        else
            return ocurrenciesOf(a.getLeft(), o) + ocurrenciesOf(a.getRight(), o);
    }

    public int getCountOfElementsInALevel(BinaryTree<T> a, int level) {
        if (a.isEmpty()) {
            return 0;
        }
        if (level == 0) {
            return 1;
        }
        return getCountOfElementsInALevel(a.getLeft(), level - 1) + getCountOfElementsInALevel(a.getRight(), level - 1);
    }

    public int height(BinaryTree<T> a) {
        if (!a.isEmpty()) {
            int heigthLeft = height(a.getLeft());
            int heightRight = height(a.getRight());
            return 1 + Math.max(heigthLeft, heightRight);
        } else {
            return -1;
        }
    }
    public Integer sumOfAllNodes(BinaryTree<Integer> a){
        int count=0;
        count = auxSumOfAllNodes(a, count);
        return count;
    }

    private Integer auxSumOfAllNodes(BinaryTree<Integer> a, int count) {
        if(!a.isEmpty()){
            count+= a.getRoot();
            count = auxSumOfAllNodes(a.getLeft(), count);
            count = auxSumOfAllNodes(a.getRight(), count);
        }
        return count;
    }
    public int sumOfAllNodesDiviededByThree(BinaryTree<Integer> a) {
        int count=0;
        count = auxSumOfAllNodesDividedByThree(a, count);
        return count;
    }

    private Integer auxSumOfAllNodesDividedByThree(BinaryTree<Integer> a, int count) {
        if(!a.isEmpty()){
            if(a.getRoot() %3 ==0) {
                count+=a.getRoot();
            }
            count = auxSumOfAllNodesDividedByThree(a.getLeft(), count);
            count = auxSumOfAllNodesDividedByThree(a.getRight(), count);
        }
        return count;
    }

    boolean iguales(BinaryTree<T> a1, BinaryTree<T> a2) {
        /* Indica si dos árboles binarios son iguales */
        if (a1.isEmpty() || a2.isEmpty()) {
            if (a1.isEmpty() && !a2.isEmpty()) {
                return false;
            }
            if (!a1.isEmpty() && a2.isEmpty()) {
                return false;
            }
        }
        if (!a1.isEmpty() && !a2.isEmpty()) {
            if (!a1.getRoot().equals(a2.getRoot())) {
                return false;
            }
            if (iguales(a1.getLeft(), a2.getLeft())) {
                return iguales(a1.getRight(), a2.getRight());
            }
        }
        return true;
    }

    boolean isomorfos(BinaryTree<T> a1, BinaryTree<T> a2) {
        /* Informa si los árboles binarios a1 y a2 son isomorfos */
        if (peso(a1) != peso(a2)) {
            return false;
        }
        if (a1.getLeft().isEmpty() || a2.getLeft().isEmpty()) {
            if (a1.getLeft().isEmpty() && !a2.getLeft().isEmpty()) {
                return false;
            } else if (!a1.getLeft().isEmpty() && a2.getLeft().isEmpty()) {
                return false;
            }
        }
        if (a1.getRight().isEmpty() || a2.getRight().isEmpty()) {
            if (a1.getRight().isEmpty() && !a2.getRight().isEmpty()) {
                return false;
            } else if (!a1.getRight().isEmpty() && a2.getRight().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    boolean semejantes(BinaryTree<T> a1, BinaryTree<T> a2) {
        /* Informa si los árboles binarios a1 y a2, sin elementos repetidos son semejantes*/
        if (a1.isEmpty() || a2.isEmpty()) {
            if (a1.isEmpty() && !a2.isEmpty()) {
                return false;
            }
            if (!a1.isEmpty() && a2.isEmpty()) {
                return false;
            }
        }
        ArrayList<T> list1 = new ArrayList<>();
        ArrayList<T> list2 = new ArrayList<>();
        list1 = guardarDatosDeUnArbolConInorden(a1, list1);
        list2 = guardarDatosDeUnArbolConInorden(a2, list2);

        if (list1.containsAll(list2)) {
            return true;
        } else {
            return false;
        }
    }


    private ArrayList<T> guardarDatosDeUnArbolConInorden(BinaryTree<T> a, ArrayList<T> elements) {
        if (!a.isEmpty()) {
            guardarDatosDeUnArbolConInorden(a.getLeft(), elements);
            elements.add(a.getRoot());
            guardarDatosDeUnArbolConInorden(a.getRight(), elements);
        }
        return elements;
    }

    boolean completo(BinaryTree<T> a) {
        /* Indica si un árbol binario es completo */
        if (a.getLeft().isEmpty() || a.getRight().isEmpty()) {
            if (a.getLeft().isEmpty() && !a.getRight().isEmpty()) {
                return false;
            } else if (!a.getLeft().isEmpty() && a.getRight().isEmpty()) {
                return false;
            }
        } else {
            if (!completo(a.getLeft())) {
                return false;
            }
            if (!completo(a.getRight())) {
                return false;
            }
        }
        return true;
    }

    boolean lleno(BinaryTree<T> a) {
        /* Informa si un árbol binario está lleno */
        int level = height(a);
        if (!completo(a)) {
            return false;
        } else {
            ArrayList<T> leaf = frontera(a);
            for (int i = 0; i < leaf.size()-1; i++) {
                if(getLevel(a, leaf.get(i)) != getLevel(a, leaf.get(i + 1))){
                    return false;
                }
            }
        }
        return true;
    }

    private int getLevel(BinaryTree<T> a, T data) {
        return getLevelUtil(a, data, 1) - 1;
    }

    private int getLevelUtil(BinaryTree<T> a, T data, int level) {
        if (a.isEmpty()) {
            return 0;
        }
        if (a.getRoot() == data) {
            return level;
        }
        int downlevel = getLevelUtil(a.getLeft(), data, level + 1);
        if (downlevel != 0) {
            return downlevel;
        }
        downlevel = getLevelUtil(a.getRight(), data, level + 1);
        return downlevel;
    }

    public boolean ocurreArbin(BinaryTree<T> a1, BinaryTree<T> a2) {
        /* Indica si el árbol a2 ocurre en el árbol a1 */
        if (a1.isEmpty()) {
            return false;
        }
        if (iguales(a1, a2)) {
            return true;
        }

        return ocurreArbin(a1.getLeft(), a2) || ocurreArbin(a1.getRight(), a2);
    }

    public boolean estable (BinaryTree<Comparable <T>> a){
        if(a.isEmpty()) return true;
        if(a.getLeft().isEmpty() && a.getRight().isEmpty()) return true;
        for (int i = 0; i < peso((BinaryTree<T>) a); i++) {
            if(a.getRoot().compareTo((T) a.getLeft().getRoot()) > 0){
                return estable(a.getLeft());
            }else if(a.getRoot().compareTo((T) a.getLeft().getRoot()) <= 0){
                return false;
            }else if(a.getRoot().compareTo((T) a.getRight().getRoot()) > 0){
                return estable(a.getRight());
            }
        }
        return false;
    }

    public void mostrarFrontera(BinaryTree<T> a) {
        if (!a.isEmpty()) {
            mostrarFrontera(a.getLeft());
            if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
                System.out.println(a.getRoot());
            }
            mostrarFrontera(a.getRight());
        }
    }

    public ArrayList<T> frontera(BinaryTree<T> a) {
        return aux_frontera(a, new ArrayList<T>());
    }

    private ArrayList<T> aux_frontera(BinaryTree<T> a, ArrayList<T> list) {
        if (!a.isEmpty()) {
            list = aux_frontera(a.getLeft(), list);
            if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
                list.add(a.getRoot());
            }
            list = aux_frontera(a.getRight(), list);
        }
        return list;
    }
    public void preorder(BinaryTree<T> a){
        if(!a.isEmpty()){
            System.out.println(a.getRoot());
            preorder(a.getLeft());
            preorder(a.getRight());
        }
    }
    public void inorder(BinaryTree<T> a){
        if(!a.isEmpty()){
            inorder(a.getLeft());
            System.out.println(a.getRoot());
            inorder(a.getRight());
        }
    }
    public void postorder(BinaryTree<T> a){
        if(!a.isEmpty()){
            postorder(a.getLeft());
            postorder(a.getRight());
            System.out.println(a.getRoot());
        }
    }
    public void byLevels(BinaryTree<T> a) throws IsEmptyException {
        QueueNode<BinaryTree<T>> auxQueue= new QueueNode<BinaryTree<T>>();
        auxQueue.enqueue(a);
        while(!auxQueue.isEmpty()){
            BinaryTree<T> auxTree= auxQueue.dequeue();
            System.out.println(auxTree.getRoot());
            if(!auxTree.getLeft().isEmpty()){
                auxQueue.enqueue(auxTree.getLeft());
            }if(!auxTree.getRight().isEmpty()){
                auxQueue.enqueue(auxTree.getRight());
            }
        }
    }
}