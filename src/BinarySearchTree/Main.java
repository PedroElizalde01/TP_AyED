package BinarySearchTree;

import TP_Hash.Util.DuplicatedObjectException;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 20/04/2021
 **************************************/

public class Main {
        public static void main(String[] args) throws DuplicatedObjectException, EmptyException {
            BinarySearchTree <Estudiante> a = new BinarySearchTree<Estudiante>();
            Estudiante e =new Estudiante("I004", "Gonzalez");
            a.insert(e);
            a.insert(new Estudiante("D022", "Lettera"));
            a.insert(new Estudiante("I014", "Alvarez"));
            a.insert(new Estudiante("E023", "Schmit"));
            a.insert(new Estudiante("O105", "Oberman"));

            if (a.exists(new Estudiante("A023")))
                System.out.println("existe");
            else
                System.out.println("no existe");
            ArBinApi<Estudiante> api= new ArBinApi<Estudiante>();
            api.inordenEstudiante(a);
        }
    }

