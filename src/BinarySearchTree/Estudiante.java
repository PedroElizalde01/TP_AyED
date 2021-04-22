package BinarySearchTree;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 20/04/2021
 **************************************/

public class Estudiante implements Comparable<Estudiante> {

    private String matricula;
    private String apellido;
    // demás datos;
    public Estudiante(String matricula, String apellido) {
        super();
        this.matricula = matricula;
        this.apellido = apellido;
    }
    public Estudiante(String matricula) {
        super();
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int compareTo(Estudiante x){

        return this.matricula.compareTo(x.matricula);
    }
}
