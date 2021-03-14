package TP_ComparaciónAlgoritmos;

import java.util.ArrayList;

public class Burbujeo {
    public static void main(String[] args) {
        Integer[] array= {3,2,1,3,5,6,8,9};
        Integer[] sortedArray= bubbleSort(array);
        for (int i = 0; i <sortedArray.length ; i++) {
            System.out.println(array[i]);
        }
    }

    public static <T>  T[] bubbleSort(Comparable<T> array[]){
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1].compareTo((T) array[j]) > 0) {
                    Comparable<T> bigger = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = bigger;                                            // if compareTo() is 0 or less it means
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
                    list.add(j - 1, list.get(j));
                    list.add(j, bigger);                                            // if compareTo() is 0 or less it means
                                                                                    // that it is smaller than the next
                }
            }
        }
        return list;
    }
}
