import java.util.Random;

class SteinGCD {
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        // Find the greatest common divisor of a and b
        if ((a % 2 == 0) && (b % 2 == 0)) {
            return 2 * gcd(a / 2, b / 2);
        } else if (a % 2 == 0) {
            return gcd(a / 2, b);
        } else if (b % 2 == 0) {
            return gcd(a, b / 2);
        } else if (a > b) {
            return gcd((a - b) / 2, b);
        } else {
            return gcd(a, (b - a) / 2);
        }
    }
}

public class SteinGCDPerformance {
    public static void main(String[] args) {
        Random rand = new Random();

        // Generate random numbers for testing
        int a = rand.nextInt(1000000) + 1;
        int b = rand.nextInt(1000000) + 1;

        // Test the Stein binary GCD algorithm
        long startTime = System.nanoTime();
        int result = SteinGCD.gcd(a, b);
        long endTime = System.nanoTime();

        System.out.println("GCD of " + a + " and " + b + " is " + result);
        System.out.println("Execution time: " + (endTime - startTime) / 1000000.0 + " milliseconds");
    }
}