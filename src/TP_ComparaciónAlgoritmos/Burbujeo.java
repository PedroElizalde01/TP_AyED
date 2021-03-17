package TP_ComparaciónAlgoritmos;

import java.util.ArrayList;

public class Burbujeo {
    //Authors: Pedro Elizalde Acevedo, Juan Pablo Senmartin, Timoteo Sanchez Varsallona

    public static <T>  T[] bubbleSort(Comparable<T> array[]){
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1].compareTo((T) array[j]) > 0) {
                    Comparable<T> bigger = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = bigger;       // if compareTo() is 0 or less it means
                                            // that it is smaller than the next
                }
            }
        }
        return (T[])array;
    }
    public static <T> ArrayList<Comparable<T>> bubbleListSort(ArrayList<Comparable<T>> list){
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j - 1).compareTo((T) list.get(j)) > 0) {
                    Comparable<T> bigger = list.get(j - 1);
                    list.add(j -1, list.get(j));
                    list.remove(j+1);
                    list.add(j, bigger);
                    list.remove(j+1);
                                                // if compareTo() is 0 or less it means
                                                // that it is smaller than the next
                }
            }
        }
        return list;
    }
}
