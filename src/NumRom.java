import java.util.HashMap;
import java.util.Scanner;

public class NumRom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(romanToInt(input)); //Llamo al metodo que traduce de NumRomano a entero

    }
    public static int romanToInt(String input) {
        int result = 0;
        if (input.length() != 1) {                                              // Si no es de una letra,
            for (int i = 0; i < input.length() - 1; i++) {                      // para cada una,
                    if (romanNumsInfo().get(input.charAt(i)) != null) {         // si es distinta a null,
                        int num = romanNumsInfo().get(input.charAt(i));         // busco su valor numerico y
                        if (num < romanNumsInfo().get(input.charAt(i + 1))) {   // me fijo si es menor al numero siguiente
                            result -= num;                                      //
                        } else {                                                //
                            result += num;                                      //
                        }
                    }
            }
        }
        result += romanNumsInfo().get(input.charAt(input.length()-1));
        return result;
    }
    private static HashMap<Character, Integer> romanNumsInfo(){
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
