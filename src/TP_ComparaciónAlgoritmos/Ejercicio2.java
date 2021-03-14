package TP_ComparaciónAlgoritmos;

public class Ejercicio2{
    //b)
    public static void main(String[] args) {
        Integer[] a = {4,3,2,1};
        Comparable<Integer>[] newArray = seleccionSort(a);
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }
    }
    public static <T> Comparable<T>[] seleccionSort(Comparable <T>[] array){
        for (int i = 0; i < array.length; i++) {
            Comparable<T> min= array[i];
            for (int count = 0; count < array.length; count++) {
                if (min.compareTo((T) array[count]) > 0) {
                    Comparable<T> max = min;
                    min = array[count];
                }
            }
            array[i] = min;
        }
        return array;
    }
}
