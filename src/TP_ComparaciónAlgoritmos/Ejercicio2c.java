package TP_ComparaciónAlgoritmos;

public class Ejercicio2c {
    public static void main(String[] args) {
        Integer[] arrayToSort= randomArray(100);
        long currentTime= System.currentTimeMillis();
        Burbujeo.bubbleSort(arrayToSort);
        long bubbleTime= (System.currentTimeMillis()- currentTime);
        System.out.println("El tiempo en segundos es de:" + bubbleTime + " milisegundos");
        currentTime= System.currentTimeMillis();
        Selection.selectionSort(arrayToSort);
        long selectionTime= (System.currentTimeMillis()- currentTime);
        System.out.println("El tiempo en segundos es de:" + selectionTime + " milisegundos");
        currentTime= System.currentTimeMillis();
        Insertion.insertionSort(arrayToSort);
        long insertionTime= (System.currentTimeMillis()- currentTime);
        System.out.println("El tiempo en segundos es de:" + insertionTime + " milisegundos");

    }
    public static Integer[] randomArray(int index){
        Integer[] array = new Integer[index];
        for (int i = 0; i < index; i++) {
            array[i] =  (int) (Math.random()*100);
        }
        return array;
    }
}
