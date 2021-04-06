package BinaryTree;

import java.util.ArrayList;

/*******************************
 Auhor/s: Timoteo Sánchez Varsallona
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
        if (!a.isEmpty()) {
            if (a.getLeft() == null && a.getRight() == null) {
                return 1;
            } else {
                return numeroDeHojas(a.getLeft()) + numeroDeHojas(a.getRight());
            }
        }
        return -1;
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
        if (a.isEmpty()){
            return 0;
        }
        if (level == 0){
            return 1;
        }
        return getCountOfElementsInALevel(a.getLeft(), level-1) + getCountOfElementsInALevel(a.getRight(), level - 1);
    }


    public int height(BinaryTree<T> a){
        if(!a.isEmpty()){
            int heigthLeft = height(a.getLeft());
            int heightRight = height(a.getRight());
            return 1 + Math.max(heigthLeft,heightRight);
        }else{
            return -1;
            }
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
        int level= height(a);
        if (!completo(a)) {
            return false;
        } else {
            ArrayList<T> leaves= new ArrayList<>();
            leaves= getLeaves(a, leaves);
        }
        return true;
    }

    private ArrayList<T> getLeaves(BinaryTree<T> a, ArrayList<T> leaves) {
        return null;
    }

    private int getLevel(BinaryTree<T> a, T data) {
        return getLevelUtil(a, data, 1)-1;
    }
    private int getLevelUtil(BinaryTree<T> a, T data, int level) {
        if (a.isEmpty()){
            return 0;
        }
        if (a.getRoot() == data){
            return level;
        }
        int downlevel = getLevelUtil(a.getLeft(), data, level + 1);
        if (downlevel != 0){
            return downlevel;
        }
        downlevel = getLevelUtil(a.getRight(), data, level + 1);
        return downlevel;
    }
    public boolean ocurreArbin( BinaryTree<T> a1,  BinaryTree<T> a2 ){ /* Indica si el árbol a2 ocurre en el árbol a1 */
        if (a1.isEmpty()){
            return false;
        }
        if(iguales(a1, a2)){
            return true;
        }

        return ocurreArbin(a1.getLeft(), a2) || ocurreArbin(a1.getRight(), a2);
    }
}
