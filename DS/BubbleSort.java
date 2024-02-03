import java.util.Arrays;

class BubbleSort {
    static void bubbleSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        if (n%10000==0){
            System.out.println(n);
        }


    }

    // Prints the array
    void printArray(int[] arr)
    {
        int n = arr.length;
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }
    public static void main(String[] args){
        BubbleSort ob = new BubbleSort();
        int[] numlist = new int[100000];
        for (int i =0; i<100000; i++){
            numlist[i] =  (int) (Math.random() * 100000000);
        }
        long startTime = System.nanoTime();
        bubbleSort(numlist);
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1000000;
        ob.printArray(numlist);
        System.out.println(executionTime);
    }


}