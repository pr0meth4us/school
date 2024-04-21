import java.lang.Math;
public class GCD {
    public static int gcd(int a, int b) {
        // Stein algorithm for GCD
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // Find powers of 2 in a and b
        int a_even = 0;
        while ((a & 1) == 0) {
            a >>= 1;
            a_even++;
        }
        int b_even = 0;
        while ((b & 1) == 0) {
            b >>= 1;
            b_even++;
        }

        // Reduce a and b until one becomes 0
        while (a != b) {
            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }
            a -= b;
            while ((a & 1) == 0)
                a >>= 1;
        }

        // Restore common factors of 2
        return a << Math.min(a_even, b_even);
    }
}



