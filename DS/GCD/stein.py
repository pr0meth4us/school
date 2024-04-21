import time
import random

def gcd(a, b):
    if a == 0:
        return b
    if b == 0:
        return a

    # Find the greatest common divisor of a and b
    if a % 2 == 0 and b % 2 == 0:
        return 2 * gcd(a // 2, b // 2)
    elif a % 2 == 0:
        return gcd(a // 2, b)
    elif b % 2 == 0:
        return gcd(a, b // 2)
    elif a > b:
        return gcd((a - b) // 2, b)
    else:
        return gcd(a, (b - a) // 2)
    

# Generate random numbers for testing
a = 659376
b = 533070

# Test the Stein binary GCD algorithm
start_time = time.time()
result = gcd(a, b)
end_time = time.time()

execution_time_ms = (end_time - start_time) * 1000

print(f"GCD of {a} and {b} is {result}")
print(f"Execution time: {execution_time_ms:.6f} milliseconds")
