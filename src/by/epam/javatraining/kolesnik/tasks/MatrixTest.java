package by.epam.javatraining.kolesnik.tasks;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Misha Kolesnik
 * @date 25.07.2019
 *
 * Class that make tests with all matrix methods
 *
 */

public class MatrixTest {

    private double[][] matrix1;
    private double[][] matrix2;
    private double[][] matrix3;
    private double[][] matrix4;
    private double[][] matrix5;
    private double[][] matrix6;

    @Before
    public void init() {
        matrix1 = new double[][]{
                {1.0, 2.0, 3.0, 4.0},
                {2.0, 1.0, 5.0, 6.0},
                {3.0, 5.0, 1.0, 7.0},
                {4.0, 6.0, 7.0, 1.0}
        };
        matrix2 = new double[][]{
                {4.0, 6.0, 7.0, 2.0},
                {3.0, 5.0, 10.0, 2.0},
                {2.0, 0.0, 5.0, 6.0},
                {1.0, 2.0, 3.0, 4.0}
        };
        matrix3 = new double[][]{
                {4.0, 3.0, 2.0, 1.0},
                {6.0, 5.0, 0.0, 2.0},
                {7.0, 10.0, 5.0, 3.0},
                {2.0, 2.0, 6.0, 4.0}
        };

        matrix4 = new double[][]{
                {7.0, 2.0, 3.0},
                {3.0, 1.0, 5.0}
        };
        matrix5 = new double[][]{
                {7.0, 2.0, 3.0},
                {3.0, 1.0, 5.0},
                {2.0, 8.0, 7.0}};
        matrix6 = new double[][]{
                {7.0, 2.0, 3.0},
                {3.0, 10.0, 5.0},
                {2.0, 8.0, 7.0}
        };
    }

    @Test
    public void minEl() {

        assertEquals(2.0, Matrix.minEl(matrix6));

    }

    @Test
    public void maxEl() {

        assertEquals(10.0, Matrix.maxEl(matrix6));

    }

    @Test
    public void isSym() {

        assertEquals(true, Matrix.isSym(matrix1));

    }

    @Test
    public void arifmAverage() {

        assertEquals(3.5, Matrix.arifmAverage(matrix4));

    }

    @Test
    public void geomAverage() {

        assertEquals(2.9279034960724704, Matrix.geomAverage(matrix4));

    }

    @Test
    public void localMin() {

        int[] extend = {1,1};
        int[] get = Matrix.localMin(matrix4);
        for (int i = 0; i < get.length; ++i) {
            assertEquals(extend[i], get[i]);
        }

    }

    @Test
    public void localMax() {

        int[] extend = {0,0};
        int[] get = Matrix.localMax(matrix4);
        for (int i = 0; i < get.length; ++i) {
            assertEquals(extend[i], get[i]);
        }

    }

    @Test
    public void trunsp() {

        double[][] get = Matrix.trunsp(matrix2);
        for (int i = 0; i < matrix3.length; ++i) {
            for (int j = 0; j < matrix3[1].length; ++j) {
                assertEquals(matrix3[i][j], get[i][j]);
            }
        }

    }
}
