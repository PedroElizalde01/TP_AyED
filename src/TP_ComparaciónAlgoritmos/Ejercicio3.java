package TP_ComparaciónAlgoritmos;
/*
Algoritmo de merge
• Mantener un índice para recorrer el arreglo a, otro para b y otro para c.

• Recorrer linealmente los arreglos a y b, asignando de a un elemento por vez en el
arreglo de salida c. El elemento a asignar en c es el menor entre el elemento actual de
a y el actual de b.

• Incrementar en 1 el índice del arreglo del que provino el elemento y también
incrementar en 1 el índice de c.

• Repetir hasta que uno de los dos arreglos de entrada haya sido pasado totalmente a c.

• Pasar el resto del otro arreglo a c.

Se pide codificar el algoritmo merge para cualquier tipo de objetos comparables.
 */

public class Ejercicio3 {

public static void main(String[] args) {
    int[] a = { -55,-10,0,5,45 };
    int[] b = { 1,76,82,99 };
    int[] c = new int[a.length + b.length];
    merge(a,b,c);
    for (int i = 0; i < c.length; i++)
        System.out.println(c[i]);
}

    public static void merge(int[] a, int[] b , int[] c) {
        int aCounter = 0, bCounter = 0, cCounter = 0;
        while (bCounter < b.length && aCounter < a.length) {
            if (b[bCounter] <= a[aCounter]){
                c[cCounter] = b[bCounter];
                cCounter++;
                bCounter++;
            }else{
                c[cCounter] = a[aCounter];
                cCounter++;
                aCounter++;
            }
        }
        while (bCounter < b.length){
            c[cCounter] = b[bCounter];
            cCounter++;
            bCounter++;
        }
        while (aCounter < a.length){
            c[cCounter] = a[aCounter];
            cCounter++;
            aCounter++;
        }
    }
}

