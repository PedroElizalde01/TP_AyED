package BinarySearchTree;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class Genoma implements Comparable<Genoma>{
    private String codigoDeOrganismo;
    private String tipoDeOrganismo;
    private String descripcionDelOrganismo;
    private int[] tamañoDelGenoma;

    public Genoma(String codigoDeOrganismo) {
        this.codigoDeOrganismo = codigoDeOrganismo;
    }

    public String getCodigoDeOrganismo() {
        return codigoDeOrganismo;
    }

    public String getTipoDeOrganismo() {
        return tipoDeOrganismo;
    }

    public String getDescripcionDelOrganismo() {
        return descripcionDelOrganismo;
    }

    public int[] getTamañoDelGenoma() {
        return tamañoDelGenoma;
    }

    public int compareTo(Genoma o) {
        return codigoDeOrganismo.compareTo(o.getCodigoDeOrganismo());
    }
}
