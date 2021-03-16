package TP_ComparaciónAlgoritmos;

import java.util.ArrayList;

public class Insertion {
    //Authors: Pedro Elizalde Acevedo, Juan Pablo Senmartin, Timoteo Sanchez Varsallona
    public static <T> T[] insertionSort(Comparable<T>[] array){
        Comparable <T> min;
        for (int i = 1; i <array.length; i++) {
            min = array[i];
            int j = i-1;
            while((j >=0)&&(min.compareTo((T) array[j]))<0){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = min;
        }
        return (T[]) array;
    }
    public static <T> ArrayList<Comparable<T>> insertionSort(ArrayList<Comparable<T>> array){
        Comparable <T> min;
        for (int i = 1; i <array.size(); i++) {
            min = array.get(i);
            int j = i-1;
            while((j >=0)&&(min.compareTo((T) array.get(j)))<0){
                array.add(j+1, array.get(j));
                j--;
            }
            array.add(j+1,  min);
        }
        return array;
    }
}

