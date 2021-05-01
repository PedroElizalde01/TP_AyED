package BinarySearchTree;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class Genome implements Comparable<Genome> {
    private String organismCode;
    private String organismType;
    private String organismDescription;
    private int[] genomeSize;

    public Genome(String organismCode) {
        this.organismCode = organismCode;
    }

    public String getOrganismCode() {
        return organismCode;
    }

    public String getOrganismType() {
        return organismType;
    }

    public String getOrganismDescription() {
        return organismDescription;
    }

    public int[] getGenomeSize() {
        return genomeSize;
    }

    @Override
    public int compareTo(Genome o) {
        return this.organismCode.compareTo(o.organismCode);
    }
}
