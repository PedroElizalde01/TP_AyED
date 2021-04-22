package BinarySearchTree;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 20/04/2021
 **************************************/

public class ArBinApi <T> {
    public void inorden (BinarySearchTree <T> a) throws EmptyException {
        if (!a.isEmpty()){
            inorden(a.getLeft());
            System.out.println(((Estudiante) a.getRoot()).getMatricula() +
                    " " +((Estudiante) a.getRoot()).getApellido());
            inorden(a.getRight());
        }
    }
}

