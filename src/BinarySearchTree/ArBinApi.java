package BinarySearchTree;

import TP_Hash.Util.DuplicatedObjectException;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 20/04/2021
 **************************************/

public class ArBinApi <T> {
    public void inordenEstudiante (BinarySearchTree <T> a) throws EmptyException {
        if (!a.isEmpty()){
            inordenEstudiante(a.getLeft());
            System.out.println(((Estudiante) a.getRoot()).getMatricula() +
                    " " +((Estudiante) a.getRoot()).getApellido());
            inordenEstudiante(a.getRight());
        }
    }
    public BinarySearchTree<T> insertList(BinarySearchTree<T> tree, Comparable<Genome>[] genomeArray) throws DuplicatedObjectException {
        for (int i = 0; i < genomeArray.length; i++) {
            tree.insert((Comparable<T>) genomeArray[i]);
        }
        return tree;
    }
    public void inorderGenome (BinarySearchTree <T> a) throws EmptyException {
        if (!a.isEmpty()){
            inorderGenome(a.getLeft());
            System.out.println(((Genome) a.getRoot()).getOrganismCode() +
                    " " +((Genome) a.getRoot()).getOrganismType()+
                    " " +((Genome) a.getRoot()).getGenomeSize()+
                    " " +((Genome) a.getRoot()).getOrganismDescription());
            inorderGenome(a.getRight());
        }
    }
}

