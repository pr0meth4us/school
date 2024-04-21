public class SteinBinaryGCD {

    // Function to find the greatest common divisor using Binary GCD Algorithm
    public static int binaryGCD(int a, int b) {
        // Base cases
        if (a == 0) return b; // If 'a' is zero, return 'b'
        if (b == 0) return a; // If 'b' is zero, return 'a'

        // Find the greatest power of 2 that divides both a and b
        int shift;
        for (shift = 0; ((a | b) & 1) == 0; ++shift) {
            System.out.println("Step " + (shift + 1) + ": Right shifting 'a' and 'b' by 1");
            a >>= 1; // Right shift 'a' by 1
            b >>= 1; // Right shift 'b' by 1
        }

        // Divide a by 2 until odd
        while ((a & 1) == 0) {
            System.out.println("Step " + (shift + 1) + ": Right shifting 'a' by 1");
            a >>= 1; // Keep dividing 'a' by 2 until it becomes odd
            shift++;
        }

        // From here on, 'a' is always odd
        do {
            // If b is even, remove all factors of 2 in b
            while ((b & 1) == 0) {
                System.out.println("Step " + (shift + 1) + ": Right shifting 'b' by 1");
                b >>= 1; // Keep dividing 'b' by 2 until it becomes odd
                shift++;
            }

            // Now a and b are both odd, swap if necessary so a <= b,
            if (a > b) {
                System.out.println("Step " + (shift + 1) + ": Swapping 'a' and 'b'");
                int temp = a;
                a = b;
                b = temp;
            }

            // Subtract smaller odd number from larger one
            System.out.println("Step " + (shift + 1) + ": Subtracting 'a' from 'b'");
            b -= a; // Subtract 'a' from 'b'
            shift++;
        } while (b != 0); // Continue until 'b' becomes zero

        // Restore common factors of 2
        System.out.println("Final step: Left shifting 'a' by " + shift);
        return a << shift; // Return 'a' left shifted by 'shift'
    }

    public static void main(String[] args) {
        // Example cases
        int a = 12;
        int b = 18;
        System.out.println("GCD of " + a + " and " + b + " is: " + binaryGCD(a, b));

        a = 35;
        b = 49;
        System.out.println("GCD of " + a + " and " + b + " is: " + binaryGCD(a, b));

        a = 1071;
        b = 462;
        System.out.println("GCD of " + a + " and " + b + " is: " + binaryGCD(a, b));
    }
}
