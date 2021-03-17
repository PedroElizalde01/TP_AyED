package TP_Blast;

import java.util.Scanner;

public class Blast {
//@author - Timoteo Sanchez, Juan Pablo Senmartin, Pedro Elizalde
    public static double blast(String reference, String query) throws IllegalArgumentException{
        //Compares the query sequence to the reference sequence nucleotide by nucleotide adding 1 if it is the same
        // nucleotide and at the end returning the percentage of similarity
        if(reference.length()!=query.length()){
            throw new IllegalArgumentException("The query and the reference don`t have the same length");
        }
        char[] charReference = reference.toLowerCase().toCharArray();
        char[] charQuery = query.toLowerCase().toCharArray();
        double counter= 0;
        for (int i = 0; i < charReference.length; i++) {
            if(charReference[i] == charQuery[i]){
                counter++;
            }
        }
        double percentage = ((counter/ reference.length()) *100);
        return Math.round(percentage * 100.0) / 100.0; // Round to two decimal figures.
    }

    public static void main(String[] args) {
        String reference = "AAAGTGCTGATA";
        Scanner scanner= new Scanner(System.in);
        String query= scanner.nextLine();
        double percentage = blast(reference,query);
        System.out.println(percentage+"%");
    }
}
