package TPComparacióndeArboles;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 20/04/2021
 **************************************/

public class NodoBnR<T> {
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
}