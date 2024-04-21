import random
import time
import ctypes

# Load the C library
c_lib = ctypes.CDLL('./stein_gcd.so')

# Define the C function prototype
c_lib.gcd_c.argtypes = [ctypes.c_int, ctypes.c_int]
c_lib.gcd_c.restype = ctypes.c_int

from stein_gcd import gcd_python

def gcd_c(a, b):
    """
    Calls the C implementation of Stein's GCD algorithm.
    """
    return c_lib.gcd_c(a, b)

def test_gcd_performance(num_tests, max_num):
    """
    Runs a performance test for the Stein's GCD algorithm implementation.
    """
    print("Running Stein's GCD algorithm performance test...")
    print(f"Number of tests: {num_tests}")
    print(f"Maximum number: {max_num}")

    python_times = []
    c_times = []

    for _ in range(num_tests):
        a = random.randint(1, max_num)
        b = random.randint(1, max_num)

        # Python implementation
        start_time = time.time()
        gcd_python(a, b)
        end_time = time.time()
        python_times.append(end_time - start_time)

        # C implementation
        start_time = time.time()
        gcd_c(a, b)
        end_time = time.time()
        c_times.append(end_time - start_time)

    print("Results:")
    print(f"Python average time: {sum(python_times) / num_tests:.6f} seconds")
    print(f"C average time: {sum(c_times) / num_tests:.6f} seconds")

    if sum(python_times) > sum(c_times):
        print("The C implementation is faster than the Python implementation.")
    else:
        print("The Python implementation is faster than the C implementation.")

# Call the test function
test_gcd_performance(1000, 1000000)