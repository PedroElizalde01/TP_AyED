package TP_Hash;

public class prueba implements Hashable, Comparable{
        Integer codigo;
        String nombre;
        public prueba(int codigo, String nombre){
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
