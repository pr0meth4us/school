public class CocktailSort {
    void cocktailSort(int a[]) {
        int start = 0;
        int end = a.length;
        int passCount = 1;

        while (true) {
            boolean swapped = false;
            int swapCountForward = 0;
            int swapCountBackward = 0;
            // Forward pass
            for (int i = start; i < end - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                    swapCountForward++;
                    System.out.println("Forward Pass " + passCount + ", Swap " + swapCountForward + ":");
                    printArray(a);
                }
            }

            if (!swapped) break;

            swapped = false;
            end--;


            // Backward pass
            for (int i = end - 1; i >= start; i--) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                    swapCountBackward++;
                    System.out.println("Backward Pass " + passCount + ", Swap " + swapCountBackward + ":");
                    printArray(a);
                }
            }

            start++;
            passCount++;
        }
    }

    /* Prints the array */
    void printArray(int a[]) {
        int n = a.length;
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String[] args) {
        CocktailSort ob = new CocktailSort();
        int a[] = {5, 1, 4, 2, 8, 0, 2};
        ob.cocktailSort(a);
        System.out.println("Sorted array:");
        ob.printArray(a);
    }
}
