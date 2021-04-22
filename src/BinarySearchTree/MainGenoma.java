package BinarySearchTree;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class MainGenoma {
    public static void main(String[] args) throws DuplicatedObjectException {
        Genoma genoma1 = new Genoma("HDGTS");
        Genoma genoma2= new Genoma("HDGTV");
        Genoma genoma3= new Genoma("HDGTT");
        BinarySearchTree<Genoma> tree= new BinarySearchTree<Genoma>();
        tree.insert(genoma1);
        tree.insert(genoma2);
        tree.insert(genoma3);

    }
}
