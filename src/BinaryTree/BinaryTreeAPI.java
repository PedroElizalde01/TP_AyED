package BinaryTree;

/*******************************
 Auhor/s: Timoteo Sánchez Varsallona
 Date: 30/3/2021/03/2021
 *********************************/
public class BinaryTreeAPI <T> {
    public int size(BinaryTree<T> a) {
        if (a.isEmpty())
            return 0;
        else
            return 1 + size(a.getLeft()) + size(a.getRight());
    }

    public int numberOfLeaves(BinaryTree<T> a) {
        if (!a.isEmpty()) {
            if (a.getLeft() == null && a.getRight() == null) {
                return 1;
            } else {
                return numberOfLeaves(a.getLeft()) + numberOfLeaves(a.getRight());
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

    public void getCountOfElementsInALevel(BinaryTree<T> a, int level) {
    }

    public void heigth(BinaryTree<T> a) {
    }

    boolean iguales(BinaryTree<T> a1, BinaryTree<T> a2) {
        /* Indica si dos árboles binarios son iguales */
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

    void semejantes(BinaryTree<T> a1, BinaryTree<T> a2) {
        /* Informa si los árboles binarios a1 y a2, sin elementos repetidos son semejantes*/
    }
}
