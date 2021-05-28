package customSearchTress;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class DuplicatedObjectException extends Exception{
    public DuplicatedObjectException(){
        super("Your BinarySearchTree already has the object");
    }
}
