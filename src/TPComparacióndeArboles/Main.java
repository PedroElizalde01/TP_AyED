package TPComparacióndeArboles;

public class Main {
    public static void main(String[] args) throws DuplicatedObjectException {
        AVL<Integer> avlTree = new AVL<>();
        avlTree.insert(10);
        avlTree.insert(8);
        avlTree.insert(9);
        avlTree.insert(40);
        avlTree.insert(50);
    }
}
