public class CocktailSort {
    static void cocktailSort(int[] a)
    {
        boolean swapped = true;
        int start = 0;
        int end = a.length;

        while (swapped) {
// reset the swapped flag on entering the
// loop, because it might be true from a
// previous iteration.
            swapped = false;

// loop from bottom to top same as
// the bubble sort
            for (int i = start; i < end - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }

// if nothing moved, then array is sorted.
            if (!swapped)
                break;

// otherwise, reset the swapped flag so that it
// can be used in the next stage
            swapped = false;

// move the end point back by one, because
// item at the end is in its rightful spot
            end = end - 1;

// from top to bottom, doing the
// same comparison as in the previous stage
            for (int i = end - 1; i >= start; i--) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }

// increase the starting point, because
// the last stage would have moved the next
// smallest number to its rightful spot.
            start = start + 1;
        }
    }

    /* Prints the array */
    void printArray(int[] a)
    {
        int n = a.length;
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String[] args){
        CocktailSort ob = new CocktailSort();
        int[] numlist = new int[100000];
        for (int i =0; i<100000; i++){
            numlist[i] =  (int) (Math.random() * 100000000);
        }
        long startTime = System.nanoTime();
        cocktailSort(numlist);
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1000000;
        ob.printArray(numlist);
        System.out.println(executionTime);
    }
}
