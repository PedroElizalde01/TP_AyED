package TPComparacióndeArboles;

import java.util.Objects;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 20/04/2021
 **************************************/

public class NodoBnR<T extends Comparable<T>> {
        T elem;
        boolean isRed;
        NodoBnR<T> izq, der;

        public NodoBnR() {
            isRed=true;
        }

        public NodoBnR(T elem) {
            this.elem = elem;
            isRed=true;
        }

        public NodoBnR(T elem, NodoBnR<T> izq, NodoBnR<T> der) {
            this.elem = elem;
            this.izq = izq;
            this.der = der;
            isRed=true;
       }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodoBnR<?> nodoBnR = (NodoBnR<?>) o;
        return elem.equals(nodoBnR.elem) && Objects.equals(izq, nodoBnR.izq) && Objects.equals(der, nodoBnR.der);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elem, izq, der);
    }
}