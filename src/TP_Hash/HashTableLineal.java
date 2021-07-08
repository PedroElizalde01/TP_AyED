package TP_Hash;

import TP_Hash.Util.BinarySearchTree;
import TP_Hash.Util.Comparable;
import TP_Hash.Util.DuplicatedObjectException;
import TP_Hash.Util.Hashable;
import TP_Hash.Util.Primo;

public class HashTableLineal {

        private Object[] t;
        private int capacidad;

        public HashTableLineal(int M) {
            if (!Primo.esPrimo(M))
                M = Primo.proxPrimo(M);
            capacidad = M;
            this.t = fillArray(M);
        }

    private Object[] fillArray(int M) {
        Object[] array= new Object[M];
        for(int i = 0; i < M ; i++)
            array[i] = 0;
        return array;
    }



        public void insertar (Object x) {
            int k =((Hashable) x).hashCode(capacidad);
            if(t[k].equals(0) || t[k].equals(-1)) {
                t[k] = x;
            }else{
                insertar(x,k+1);
            }
        }
        private void insertar(Object x, int k) {

            if (t[k].equals(0) || t[k].equals(-1)) {
                t[k] = x;

            } else {
                insertar(x, k + 1);
            }
        }

        public Object buscar (Object x) {
            int k = ((Hashable) x).hashCode(capacidad);
            for (int i = k ; i < capacidad ; i ++ )
                if (((TP_Hash.Util.Comparable) x).compareTo(t[k])== 0)
                    return t[k];
            return x;
        }

        public BinarySearchTree<Object> obtenerArBinBus () throws DuplicatedObjectException {
            BinarySearchTree a = new BinarySearchTree<>();
            for (int i = 0; i < capacidad; i++ ) {
                if (!t[i].equals(0) || !t[i].equals(-1)) {
                    a.insert((Comparable) t[i]);
                }
            }
            return a;
        }

        public Object[] eliminar(Object x){
            int k = ((Hashable) x).hashCode(capacidad);
            for (int i = k ; i < capacidad ; i ++ )
                if (x.equals(t[i])) {
                    t[i] = -1;
                    break;
                }
            return t;
        }

        public boolean exists(Object x){
            int k = ((Hashable) x).hashCode(capacidad);
            for (int i = k ; i < capacidad ; i ++ )
                if (x.equals(t[i]))
                    return true;
            return false;
        }
}
