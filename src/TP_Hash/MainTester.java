package TP_Hash;

public class MainTester {
    public static void main(String[] args) {
        Tester a = new Tester(28, "a");
        Tester b = new Tester(39, "b");
        Tester c = new Tester(3, "c");
        Tester d = new Tester(20, "d");
        Tester f= new Tester(0,"2");
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
