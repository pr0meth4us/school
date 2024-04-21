public class BinaryGCD {

    public static int gcd(int a, int b) {
        System.out.println("Initial values: a = " + a + ", b = " + b);

        // Base cases
        if (a == 0) {
            System.out.println("Base case: GCD(0, b) = b");
            return b;
        }
        if (b == 0) {
            System.out.println("Base case: GCD(a, 0) = a");
            return a;
        }

        // Finding K, where K is the greatest power of 2 that divides both a and b
        int k = 0;
        while (((a | b) & 1) == 0) {
            System.out.println("Both numbers are even, right shifting a and b by 1");
            System.out.print("Right shift a by 1: " + a + " >> 1 = ");
            a >>= 1;
            System.out.println(a);
            System.out.print("Right shift b by 1: " + b + " >> 1 = ");
            b >>= 1;
            System.out.println(b);
            k++;
        }
        System.out.println("K (greatest power of 2) = " + k);

        // Dividing a by 2 until a becomes odd
        while ((a & 1) == 0) {
            System.out.println("Dividing a by 2 until it becomes odd");
            System.out.print("Right shift a by 1: " + a + " >> 1 = ");
            a >>= 1;
            System.out.println(a);
        }

        System.out.println("After making 'a' odd, a = " + a);

        // From here on, 'a' is always odd
        while (b != 0) {
            // If b is even, remove all factor of 2 in b
            while ((b & 1) == 0) {
                System.out.println("Both numbers are odd, removing all factors of 2 in b by right shifting b by 1");
                System.out.print("Right shift b by 1: " + b + " >> 1 = ");
                b >>= 1;
                System.out.println(b);
            }

            // Now a and b are both odd. Swap if necessary so a <= b, then set b = b - a (which is even).
            if (a > b) {
                System.out.println("Swapping a and b since a > b");
                int temp = a;
                a = b;
                b = temp;
            }

            System.out.println("Subtracting a from b: " + b + " - " + a + " = " + (b - a));
            b = b - a;
        }

        // restore common factors of 2
        int gcdValue = a << k;
        System.out.println("Restoring common factors of 2 by left shifting a by " + k + " positions");
        System.out.println("GCD is " + gcdValue);
        return gcdValue;
    }

    public static void main(String[] args) {
        int a = 64;
        int b = 202;
        System.out.println("Finding GCD of " + a + " and " + b);
        System.out.println("GCD of given numbers is " + gcd(a, b));
    }
}
