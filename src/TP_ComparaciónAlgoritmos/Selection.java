package TP_Comparaci√≥nAlgoritmos;

import java.util.ArrayList;

public class Selection {
    // Authors: Pedro Elizalde Acevedo, Juan Pablo Senmartin, Timoteo Sanchez Varsallona

    public static <T> T[] selectionSort(Comparable<T> array[]) {
        int indexOfMin = 0;
        for (int i = 0; i < array.length - 1; i++) {
            Comparable<T> min = array[i];
            for (int count = i; count < array.length; count++) {
                if (min.compareTo((T) array[count]) > 0) {
                    min = array[count];
                    indexOfMin = count;
                }
            }
            array[indexOfMin] = array[i];
            array[i] = min;
        }
        return (T[]) array;
    }

    public static <T> ArrayList<Comparable<T>> selectionListSort(ArrayList<Comparable<T>> list) {
        int indexOfMin = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            Comparable<T> min = list.get(i);
            for (int count = i; count < list.size(); count++) {
                if (min.compareTo((T) list.get(count)) > 0) {
                    min = list.get(count);
                    indexOfMin = count;
                }
            }
            list.add(indexOfMin, list.get(i));
            list.remove(indexOfMin+1);
            list.add(i, min);
            list.remove(i+1);
        }
        return list;
    }

    public static <T> ArrayList<Comparable<T>> recursiveSeleccionListSort(ArrayList<Comparable<T>> list, int count, ArrayList<Comparable<T>> listToReturn, int repetitions) {

        if (count >= repetitions) {
            return listToReturn;
        }
        Comparable<T> min = minSearcher(list, 0 , list.get(0));
        int lastMin= list.indexOf(min);
        listToReturn.add(count, min);
        list.remove(lastMin);


        count++;
        recursiveSeleccionListSort(list, count, listToReturn, repetitions);
        return listToReturn;
    }

    public static <T> Comparable<T> minSearcher(ArrayList<Comparable<T>> list, int lookedUpTo, Comparable<T> min) {
        if (lookedUpTo < list.size()) {
            if (list.get(lookedUpTo).compareTo((T) min) < 0) {
                min = list.get(lookedUpTo);
            }
            lookedUpTo++;
            return (minSearcher(list, lookedUpTo, min));
        }
        return min;
    }
}