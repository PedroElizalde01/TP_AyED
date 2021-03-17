package TP_ComparaciónAlgoritmos;

public class Ejercicio3 {
    //@author - Tomiteo Sanchez, Juan Pablo Senmartin, Pedro Elizalde

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

