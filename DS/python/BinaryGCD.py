def gcd(a, b):
    print("Initial values: a =", a, ", b =", b)

    # Base cases
    if a == 0:
        print("Base case: GCD(0, b) = b")
        return b
    if b == 0:
        print("Base case: GCD(a, 0) = a")
        return a

    # Finding K, where K is the greatest power of 2 that divides both a and b
    k = 0
    while ((a | b) & 1) == 0:
        print("Both numbers are even, right shifting a and b by 1")
        print("Right shift a by 1:", a, ">> 1 =", end=" ")
        a >>= 1
        print(a)
        print("Right shift b by 1:", b, ">> 1 =", end=" ")
        b >>= 1
        print(b)
        k += 1
    print("K (greatest power of 2) =", k)

    # Dividing a by 2 until a becomes odd
    while (a & 1) == 0:
        print("Dividing a by 2 until it becomes odd")
        print("Right shift a by 1:", a, ">> 1 =", end=" ")
        a >>= 1
        print(a)

    print("After making 'a' odd, a =", a)

    # From here on, 'a' is always odd
    while b != 0:
        # If b is even, remove all factor of 2 in b
        while (b & 1) == 0:
            print("Both numbers are odd, removing all factors of 2 in b by right shifting b by 1")
            print("Right shift b by 1:", b, ">> 1 =", end=" ")
            b >>= 1
            print(b)

        # Now a and b are both odd. Swap if necessary so a <= b, then set b = b - a (which is even).
        if a > b:
            print("Swapping a and b since a > b")
            a, b = b, a

        print("Subtracting a from b:", b, "-", a, "=", b - a)
        b = b - a

    # restore common factors of 2
    gcd_value = a << k

    print("Restoring common factors of 2 by left shifting a ", a, " by", k, "positions")
    print("GCD is", gcd_value)
    return gcd_value


# Driver code
a = 1028
b = 18
print("Finding GCD of", a, "and", b)
print("Gcd of given numbers is", gcd(a, b))
