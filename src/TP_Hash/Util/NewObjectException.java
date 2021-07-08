package TP_Hash.Util;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class NewObjectException extends  Exception{
    public NewObjectException(){
        super("Your object does not exist in this BinarySearchTree");
    }
}
