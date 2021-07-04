package TP_Hash;

public class MainPrueba {
    public static void main(String[] args) {
        prueba a = new prueba(28, "a");
        prueba b = new prueba(39, "b");
        prueba c = new prueba(3, "c");
        prueba d = new prueba(20, "d");
        prueba f= new prueba(0,"2");
        HashTableLineal hashTableOpen = new HashTableLineal(10);
        hashTableOpen.insertar(a);
        hashTableOpen.insertar(b);
        hashTableOpen.insertar(c);
        hashTableOpen.insertar(d);
        System.out.println(hashTableOpen.exists(d));
        Object fObj = hashTableOpen.buscar(f);
        Object cObj = hashTableOpen.buscar(c);
        hashTableOpen.eliminar(b);
        System.out.println(hashTableOpen.exists(b));
        System.out.println(hashTableOpen.exists(d));
        System.out.println();

    }
}
