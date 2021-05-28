package customSearchTress;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 20/04/2021
 **************************************/

public class NodoDoble<T> {
    T elem;
    NodoDoble<T> izq, der;

    public NodoDoble() {
    }

    public NodoDoble(T elem) {
        this.elem = elem;
    }

    public NodoDoble(T elem, NodoDoble<T> izq, NodoDoble<T> der) {
        this.elem = elem;
        this.izq = izq;
        this.der = der;
    }
}
