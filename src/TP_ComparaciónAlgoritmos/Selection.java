package TP_ComparaciónAlgoritmos;

import java.util.ArrayList;

public class Selection {
    //b)
    public static void main(String[] args) {
        Integer[] a = {4,3,2,1,4,2,7};
        ArrayList<Comparable<Integer>> list= new ArrayList<>();
        for (int i = 0; i <a.length ; i++) {
            list.add(a[i]);
        }
        ArrayList<Integer> newArray = recursiveSeleccionListSort(list,0);
        for (int i = 0; i < newArray.size(); i++) {
            System.out.println(newArray.get(i));
        }
    }
    public static <T> T[] selectionSort(Comparable <T> array[]){
        int indexOfMin=0;
        for (int i = 0; i < array.length-1; i++) {
            Comparable<T> min= array[i];
            for (int count = i; count < array.length; count++) {
                if (min.compareTo((T) array[count]) > 0) {
                    min = array[count];
                    indexOfMin=count;
                }
            }
            array[indexOfMin]=array[i];
            array[i] = min;
        }
        return (T[])array;
    }
    public static <T> ArrayList<Comparable<T>> selectionListSort(ArrayList<Comparable <T>> list){
        int indexOfMin=0;
        for (int i = 0; i < list.size()-1; i++) {
            Comparable<T> min= list.get(i);
            for (int count = i; count < list.size(); count++) {
                if (min.compareTo((T) list.get(count)) > 0) {
                    min = list.get(count);
                    indexOfMin=count;
                }
            }
            list.add(indexOfMin,list.get(i));
            list.add(i, min);
        }
        return list;
    }
    public static <T> ArrayList<T> recursiveSeleccionListSort(ArrayList<Comparable <T>> list, int count){
        if (count>list.size()){
            return (ArrayList<T>) list;
        }
        Comparable<T> min = recursiveSeleccionListSortHelper(list, 0, list.get(0));
       list.add(list.indexOf(min), list.get(0));
       list.add(0, min);
       count++;
       recursiveSeleccionListSort(list, count);
        return null;
    }
    public static <T> Comparable<T> recursiveSeleccionListSortHelper(ArrayList<Comparable <T>> list, int sortedUpTo, Comparable<T> min) {
        if(sortedUpTo>list.size()){
            return min;
        }
        if(min.compareTo((T)list.get(sortedUpTo))>0){
            min= list.get(sortedUpTo);
        }
        sortedUpTo++;
        recursiveSeleccionListSortHelper(list, sortedUpTo, min);
        return null;
    }
}
