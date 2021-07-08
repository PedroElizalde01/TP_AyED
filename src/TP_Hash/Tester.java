package TP_Hash;

import TP_Hash.Util.Comparable;
import TP_Hash.Util.Hashable;

public class Tester implements Hashable, Comparable {
        Integer codigo;
        String nombre;
        public Tester(int codigo, String nombre){
            this.codigo = codigo;
            this.nombre = nombre;
        }
        public int hashCode (int tableSize){
            return codigo % tableSize;
        }

    @Override
    public int compareTo(Object x) {
        return -1;
    }


}
