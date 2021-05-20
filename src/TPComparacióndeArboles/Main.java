package TPComparacióndeArboles;

import PilasyColas.IsEmptyException;

public class Main {
    public static void main(String[] args) throws DuplicatedObjectException, IsEmptyException {
        BlackAndRedTree<Integer> bnrTree = new BlackAndRedTree<>();
        bnrTree.insert(10);
        bnrTree.insert(8);
        bnrTree.insert(9);
        bnrTree.insert(40);
        bnrTree.insert(50);
    }
}
