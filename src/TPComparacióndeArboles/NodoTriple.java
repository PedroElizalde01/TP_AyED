package TPComparacióndeArboles;

public class NodoTriple<T> {
    NodoTriple<T> izq;
    NodoTriple<T> der;
    NodoTriple<T> father;
    T elem;

    public NodoTriple(NodoTriple<T> izq, NodoTriple<T> der, NodoTriple<T> father, T elem) {
        this.izq = izq;
        this.der = der;
        this.father = father;
        this.elem = elem;
    }

    public NodoTriple(T elem) {
        this.elem = elem;
    }

    public NodoTriple() {
    }
}
