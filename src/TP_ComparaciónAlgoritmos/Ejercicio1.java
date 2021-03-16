package TP_ComparaciónAlgoritmos;

public class Ejercicio1 {
    //Authors: Pedro Elizalde Acevedo, Juan Pablo Senmartin, Timoteo Sanchez Varsallona

    public int SeqSearch ( int a[], int k) {
           for (int i = 0; i < a.length; i++)
               if (k == a[i])
                    return i;
            return -1;
        }

    public static int BinarySearch ( int a[], int k) {
        int min = 0;
        int max = a.length-1;
        int middle = (min+max)/2;
        while(min <= max) {
            if (k == a[middle])
                return middle;
            else if (k < a [middle] )
                max = middle-1;
            else
                min = middle +1;
            middle = (min+max)/2;
        }
        return -1;
    }


}
