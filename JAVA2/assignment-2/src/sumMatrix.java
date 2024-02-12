import java.util.Scanner;

public class sumMatrix {

    public static double[][] readMatrixInput(Scanner input, int rows, int cols){
        double[][] matrix = new double[rows][cols];
        System.out.println("Enter a " + rows + "-by-" + cols + " matrix row by row:");
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                matrix[i][j] = input.nextDouble();
            }
        }
        return matrix;
    }

    public static double sumColumn(double[][] m, int columnIndex){
        double sum = 0;
        for(int i=0; i<m.length; i++){
            sum += m[i][columnIndex];
        }
        return sum;
    }

    public static void main(String[] args){
        try(Scanner input = new Scanner(System.in)){
            int rows = 3;
            int cols = 4;
            double[][] matrix = readMatrixInput(input, rows, cols);
            for(int i=0; i<cols; i++){
                System.out.println("Sum of the elements at column " + i + " is " + sumColumn(matrix, i));
            }
        }
    }

}