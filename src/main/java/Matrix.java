import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Matrix {

    public static double[][] multiply(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
            }
        }
        return result;
    }

    public static double[][] add(double[][] firstMatrix, double[][] secondMatrix) {
        if(firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length)
            return null;
        double[][] result = new double[firstMatrix.length][firstMatrix[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = firstMatrix[row][col] + secondMatrix[row][col];
            }
        }
        return result;
    }

    public static double[][] subtract(double[][] firstMatrix, double[][] secondMatrix) {
        if(firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length)
            return null;
        double[][] result = new double[firstMatrix.length][firstMatrix[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = firstMatrix[row][col] - secondMatrix[row][col];
            }
        }
        return result;
    }

    public static double[][] add(double[][] firstMatrix, double number) {
        double[][] result = new double[firstMatrix.length][firstMatrix[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = firstMatrix[row][col] + number;
            }
        }
        return result;
    }

    public static double[][] subtract(double[][] firstMatrix, double number) {
        double[][] result = new double[firstMatrix.length][firstMatrix[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = firstMatrix[row][col] - number;
            }
        }
        return result;
    }

    private static double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }

    public static double[][] readFromFile(String path){
        int row, col;
        double[][] array;
        try (Scanner s = new Scanner(new File(path))) {
            s.useLocale(Locale.US);
            row = s.nextInt();
            col = s.nextInt();
            array = new double[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    array[i][j]  = s.nextDouble();
                }
            }
        } catch (FileNotFoundException e) {
            return null;
        } catch (java.util.InputMismatchException e) {
            return null;
        } catch (java.util.NoSuchElementException e) {
            return null;
        } catch (IllegalStateException e) {
            return null;
        }
        return array;

    }
    public static void print(double[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
    }
}