package TP_Hash;

import TP_Hash.Util.*;
import TP_Hash.Util.Comparable;

public class HashTableOpen {

    private DynamicList[] t;
    private int capacidad;

    public HashTableOpen(int M) {
        if (!Primo.esPrimo(M))
            M = Primo.proxPrimo(M);
        capacidad = M;
        this.t = fillArray(M);
    }

    private DynamicList<Object>[] fillArray(int M) {
        DynamicList<Object>[] array = new DynamicList[M];
        for (int i = 0; i < M; i++)
            array[i] = new DynamicList<>();
        return array;
    }

    public void insertar(Object x) {
        int k = ((Hashable) x).hashCode(capacidad);
        t[k].insertNext(x);
    }

    public Object buscar (Object x) {
        int k = ((Hashable) x).hashCode(capacidad);
        t[k].goFirst();
        int l = t[k].size();
        for (int i = 0 ; i < l ; i ++ )
            if (((Comparable) x).compareTo(t[k].getActual())== 0)
                return t[k].getActual();
        return x;
    }

    public BinarySearchTree<Object> obtenerArBinBus() throws DuplicatedObjectException {
        BinarySearchTree a = new BinarySearchTree<>();
        for (int i = 0; i < capacidad; i++) {
            if (!t[i].isEmpty()) {
                t[i].goFirst();
                for (int j = 0; j < t[i].size(); j++) {
                    a.insert((Comparable) t[i].getActual());
                    t[i].goNext();
                    j++;
                }
            }
        }
        return a;
    }

    public DynamicList<Object>[] eliminar(Object x) {
        int k = ((Hashable) x).hashCode(capacidad);
        t[k].goFirst();
        int l = t[k].size();
        for (int i = 0 ; i < l ; i ++ )
            if (((Comparable) x).compareTo(t[k].getActual())== 0)
                t[k].remove();
        return t;
    }

    public boolean exists(Object x){
        int k = ((Hashable) x).hashCode(capacidad);
        t[k].goFirst();
        int l = t[k].size();
        if (l == 1) {
            if (t[k].getActual().equals(x)) {
                return true;
            } else {
                return false;
            }
        }
        for (int i = 0; i < l - 1; i++) {
            if (x.equals(t[k].getActual())) {
                return true;
            }
            if (l != i) {
                t[k].goNext();
            }
        }
        return false;
    }
}