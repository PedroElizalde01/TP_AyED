package customSearchTrees;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class EmptyException extends Exception{
    public EmptyException(){
        super("Your BinarySearchTree is Empty");
    }
}
