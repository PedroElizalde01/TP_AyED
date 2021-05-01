package BinarySearchTree;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class MainGenome {
    public static void main(String[] args) throws DuplicatedObjectException, EmptyException {
        Genome genome1 = new Genome("HDGTS");
        Genome genome2= new Genome("HDGTV");
        Genome genome3= new Genome("HDGTT");
        Genome[] genomes= new Genome[3];
        genomes[0]= genome1;
        genomes[1]= genome2;
        genomes[2]=genome3;
        BinarySearchTree<Genome> tree= new BinarySearchTree<Genome>();
        ArBinApi<Genome> api= new ArBinApi<Genome>();
        api.insertList(tree, genomes);
        api.inorderGenome(tree);

    }
}
