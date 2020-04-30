import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MatrixTest {
    @Test
    public void canAddNumberToMatrix() {
        double[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int number = 8;

        double[][] ans = Matrix.add(array, number);
        double[][] expectAns = {{9, 10, 11}, {12, 13, 14}, {15, 16, 17}};
        assertArrayEquals(ans, expectAns);
    }

    @Test
    public void canSubtractNumberToMatrix() {
        double[][] array = {{6, 7, 8}, {9, 10, 11}, {12, 13, 14}};
        int number = 2;
        double[][] ans = Matrix.subtract(array, number);
        double[][] expectAns = {{4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        assertArrayEquals(ans, expectAns);
    }

    @Test
    public void canAddMatricesWithEqualSize() throws Exception {
        double[][] array1 = {{3, 3, 3}, {5, 5, 5}, {7, 7, 7}};
        double[][] array2 = {{6, 7, 8}, {9, 10, 11}, {12, 13, 14}};
        double[][] ans = Matrix.add(array1, array2);
        double[][] expectAns = {{9, 10, 11}, {14, 15, 16}, {19, 20, 21}};
        assertArrayEquals(ans, expectAns);
    }

    @Test
    public void returnNullIfTryToAddMatricesWithNotEqualSize(){
        double[][] array1 = {{3}};
        double[][] array2 = {{6, 7}, {9, 10}, {12, 13}};
        assertNull(Matrix.add(array1, array2));
    }

    @Test
    public void returnNullIfTryToSubtractMatricesWithNotEqualSize(){
        double[][] array1 = {{4, 5, 6, 7, 8}};
        double[][] array2 = {{6, 7}, {9, 10}, {12, 13}};
        assertNull(Matrix.subtract(array1, array2));
    };

    @Test
    public void canMultiplyTwoMatrices() {
        double[][] array1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        double[][] array2 = {{2, 2, 2}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        double[][] ans = Matrix.multiply(array1, array2);
        double[][] ansExpect = {{71, 80, 89}, {163, 184, 205}, {255, 288, 321}};
        assertArrayEquals(ans, ansExpect);
    }
    @Test
    public void canMultiplyOneDimensionalMatrices() {
        double[][] array1 = {{1, 2, 3, 4, 5}};
        double[][] array2 = {{5}, {4}, {3}, {2}, {1}};
        double[][] ans = Matrix.multiply(array1, array2);
        double[][] expectAns = {{35}};
        assertArrayEquals(ans, expectAns);
    }

    @Test
    public void canReadCorrectFile() {
        double[][] array = Matrix.readFromFile(getClass().getResource("/test1.txt").getFile());
        double[][] expectAns = {{7,  8,  9,  10,    11},
                {11,  10,  9, 8, 7},
                {2, 3, 5, 7,  9},
                {20, 30, 40, 50, 60}};
        assertNotNull(array);
        assertArrayEquals(array, expectAns);
    }

    @Test
    public void cantReadFileWithIncorrectPath() {
        assertNull(Matrix.readFromFile("something incorrect"));
    }

    @ParameterizedTest
    @ValueSource (strings = {"/incorrectTest1.txt", "/incorrectTest2.txt", "/incorrectTest3.txt"})
    void cantReadIncorrectFiles(String path) {
        double[][] array = Matrix.readFromFile(getClass().getResource(path).getFile());
        assertNull(array);
    }
}