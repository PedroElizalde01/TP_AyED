package TPNumRom;//@author - Timoteo Sanchez, Juan Pablo Senmartin, Pedro Elizalde

import java.util.HashMap;
import java.util.Scanner;

public class NumRom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(romanToInt(input)); //Call method to translate a roman number to int, and then print

    }
    public static int romanToInt(String input) {
        int result = 0;                                                         // Create local variable to store int's
        if (input.length() != 1) {                                              // If more than one letter,
            for (int i = 0; i < input.length() - 1; i++) {                      // for each one,
                    if (romanNumsInfo().get(input.charAt(i)) != null) {         // if's not null,
                        int num = romanNumsInfo().get(input.charAt(i));         // search for numeric value and
                        if (num < romanNumsInfo().get(input.charAt(i + 1))) {   // check if it's smaller than the next number
                            result -= num;                                      // If it is, subtract to result
                        } else {                                                // if its bigger,
                            result += num;                                      // add to result
                        }
                    }
            }
        }
        return result + romanNumsInfo().get(input.charAt(input.length() - 1));  // return int equivalent to roman number
    }
    private static HashMap<Character, Integer> romanNumsInfo(){ // This is where 'romanToInt()' gets the info to translate
        HashMap<Character,Integer> romanNums = new HashMap<>();
        romanNums.put('I',1);
        romanNums.put('V',5);
        romanNums.put('X',10);
        romanNums.put('L',50);
        romanNums.put('C',100);
        romanNums.put('D',500);
        romanNums.put('M',1000);
        return romanNums;
    }
}
