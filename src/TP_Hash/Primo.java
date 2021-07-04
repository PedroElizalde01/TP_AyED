package TP_Hash;

public class Primo {
    public static boolean esPrimo(int n) {
        if (n == 1 || n == 2 || n == 3)
            return true;
        if (n % 2 == 0)
            return false;
        else {
            int k = 3;
            while (k <= Math.sqrt(n)) {
                if (n % k == 0)
                    return false;
                k = k +2;
            }
        }
        return true;
    }
    public static int proxPrimo(int n) {
        if (n % 2 == 0)
            n++;
        while (!esPrimo(n))
            n = n + 2;
        return n;
    }
}
