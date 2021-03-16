package TP_Blast;

public class Blast {
//@author - Timoteo Sanchez, Juan Pablo Senmartin, Pedro Elizalde
    public static double blast(String reference, String query){
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
        String a = "AATGCCA";
        String b = "TATGAAT";
        double percentage = blast(a,b);
        System.out.println(percentage+"%");
    }
}
