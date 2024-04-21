import org.junit.jupiter.api.Test;

public class GCDTest {
    @Test
    public void testGCDPerformance() {
        long startTime = System.nanoTime();

        // Perform GCD algorithm in a loop
        for (int i = 0; i < 1000000; i++) {
            GCD.gcd(1680324313, 640421324);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Convert to milliseconds

        System.out.println("Java - GCD algorithm duration: " + duration + " ms");
    }
}

