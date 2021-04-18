package BinaryTree;

import java.lang.instrument.IllegalClassFormatException;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) throws IllegalClassFormatException {
        BinaryTreeAPI api = new BinaryTreeAPI();
        BinaryTree<Integer> A = new BinaryTree<Integer>(1);
        BinaryTree<Integer> B = new BinaryTree<Integer>(2);
        BinaryTree<Integer> F = new BinaryTree<Integer>(53);
        BinaryTree<Integer> G = new BinaryTree<Integer>(15);
        BinaryTree<Integer> C = new BinaryTree<Integer>(3,A,F);
        BinaryTree<Integer> D = new BinaryTree<Integer>(4,G,B);
        BinaryTree<Integer> E = new BinaryTree<Integer>(5,D,C);

        BinaryTree<Integer> H=E;

        System.out.println(api.peso(E)+" , Expected 7");
        System.out.println(api.numeroDeHojas(E)+" , Expected 4");
        System.out.println(api.ocurrenciesOf(E, 3)+" , Expected 1");
        System.out.println(api.getCountOfElementsInALevel(E, 1)+" , Expected 2");
        System.out.println(api.ocurrenciesOf(E, 3)+" , Expected 1");
        System.out.println(api.height(E)+" , Expected 2");
        System.out.println(api.sumOfAllNodes(E) +" , Expected 83");
        System.out.println(api.sumOfAllNodesDiviededByThree(E)+ " ,Expected 18");
        System.out.println(api.iguales(E,H)+" ,Expected true");
        System.out.println(api.isomorfos(E,H)+ " ,Expected true");
        System.out.println(api.semejantes(E,H)+ " ,Expected true");
        System.out.println(api.completo(E)+ " ,Expected true");
        System.out.println(api.lleno(E)+ " ,Expected: true");
        System.out.println(api.estable(E) +" REVISAR");
        System.out.println(api.ocurreArbin(D,E) + " ,Expected false");
        api.mostrarFrontera(E);
        System.out.println("Must be the same as: ");
        printArrayList(api.frontera(E));
    }
    private static void printArrayList(ArrayList<Integer> list){
        String toReturn="";
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}