package TPComparacióndeArboles;

import PilasyColas.IsEmptyException;

public class MainAux {
    public static void main(String[] args) throws IsEmptyException {
        RBTree<Integer> avlTree = new RBTree<>(0);
        for (Integer i = 1; i < 1000; i++) {
            avlTree.insert(i);
        }
        System.out.println(avlTree.search(510));
    }
}
