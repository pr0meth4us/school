import timeit

def gcd(a, b):
    # Stein algorithm for GCD
    if a == 0:
        return b
    if b == 0:
        return a

    # Find powers of 2 in a and b
    a_even = 0
    while a & 1 == 0:
        a >>= 1
        a_even += 1
    b_even = 0
    while b & 1 == 0:
        b >>= 1
        b_even += 1

    # Reduce a and b until one becomes 0
    while a != b:
        if a < b:
            a, b = b, a
        a -= b
        while a & 1 == 0:
            a >>= 1

    # Restore common factors of 2
    return a << min(a_even, b_even)


def gcd_performance():
    # Perform GCD algorithm in a loop
    return gcd(43, 624)

print(gcd_performance())


# Measure execution time using timeit
time_taken = timeit.timeit(gcd_performance, number=1)
print("Python - GCD algorithm duration:", time_taken, "seconds")
