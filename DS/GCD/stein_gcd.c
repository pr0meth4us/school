#include <stdio.h>

int gcd_c(int a, int b) {
    /**
     * Implements Stein's GCD algorithm in C.
     */
    if (a == 0)
        return b;
    if (b == 0)
        return a;

    // Ensure a >= b
    if (a < b) {
        int temp = a;
        a = b;
        b = temp;
    }

    // Step 1: Divide out common factors of 2
    int k = 0;
    while (((a | b) & 1) == 0) {
        a >>= 1;
        b >>= 1;
        k++;
    }

    // Step 2: Divide a and b by their common factors of 2, and compute the GCD
    while ((a & 1) == 0)
        a >>= 1;
    while ((b & 1) == 0)
        b >>= 1;

    // Step 3: Compute the GCD using the Euclidean algorithm
    while (a != b) {
        if (a > b)
            a -= b;
        else
            b -= a;
        while ((a & 1) == 0)
            a >>= 1;
        while ((b & 1) == 0)
            b >>= 1;
    }

    // Step 4: Multiply the GCD by the common factors of 2
    return a << k;
}