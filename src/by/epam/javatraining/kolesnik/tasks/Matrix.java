package by.epam.javatraining.kolesnik.tasks;

import java.util.logging.Level;


/**
 *
 * @author Misha Kolesnik
 * @date 25.07.2019
 *
 * Class provides all methods to work with matrix
 *
 */
public class Matrix {

    /**
     * Find min element of the matrix
     *
     * @param array the matrix
     * @return the min element of matrix
     */
    public static double minEl(double[][] array) {

        double minEl = array[0][0];
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[1].length; ++j) {
                if (array[i][j] < minEl) {
                    minEl = array[i][j];
                }
            }
        }

        Main.logger.log(Level.INFO, "Min matrix el was found");

        return minEl;

    }

    /**
     * Find max element of the matrix
     *
     * @param array the matrix
     * @return the max element of matrix
     */
    public static double maxEl(double[][] array) {

        double maxEl = array[0][0];
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[1].length; ++j) {
                if (array[i][j] > maxEl) {
                    maxEl = array[i][j];
                }
            }
        }

        Main.logger.log(Level.INFO, "Max matrix el was found");

        return maxEl;

    }

    /**
     * Check for symmetry of matrix
     *
     * @param array the matrix
     * @return {@code true} if sym, {@code false} if not sym
     */
    public static boolean isSym(double[][] array) {

        for (int i = 0; i < array[1].length; ++i) {
            for (int j = i + 1; j < array.length; ++j){
                if (array[j][i] != array[i][j]) {
                    return false;
                }
            }
        }

        Main.logger.log(Level.INFO, "Symmetry of matrix has been verified");

        return true;

    }

    /**
     * Find arifm average of matrix elements
     *
     * @param array the matrix
     * @return arifm average
     */
    public static double arifmAverage(double[][] array) {

        int sum = 0;
        int num = 0;
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[1].length; ++j) {
                sum += array[i][j];
                ++num;
            }
        }

        Main.logger.log(Level.INFO, "Arifm average was found");

        return sum/(double)num;

    }

    /**
     * Find geom average of matrix elements
     *
     * @param array the matrix
     * @return geom average
     */
    public static double geomAverage(double[][] array) {

        int pro = 1;
        int num = 0;
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[1].length; ++j) {
                pro *= array[i][j];
                ++num;
            }
        }

        Main.logger.log(Level.INFO, "Geom average was found");

        return Math.pow(pro, 1/(double)num);

    }

    /**
     * Find first local minimum
     *
     * @param array the matrix
     * @return id
     */
    public static int[] localMin(double[][] array) {

        Main.logger.log(Level.INFO, "First local min was found");

        int[] id = {-1,-1};
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[1].length; ++j) {
                // left
                if(j == 0) {
                    if (i == 0) {
                        if ((array[i][j] < array[i][j + 1]) && (array[i][j] < array[i + 1][j])) {
                            id[0] = i;
                            id[1] = j;
                            return id;
                        }
                    } else if (i == array.length - 1) {
                        if ((array[i][j] < array[i - 1][j]) && (array[i][j] < array[i][j + 1])) {
                            id[0] = i;
                            id[1] = j;
                            return id;
                        }
                    } else {
                        if ((array[i][j] < array[i][j + 1]) && (array[i][j] < array[i + 1][j]) && (array[i][j] < array[i - 1][j])) {
                            id[0] = i;
                            id[1] = j;
                            return id;
                        }
                    }
                }
                //right
                if (j == array[1].length - 1) {
                    if (i == 0) {
                        if ((array[i][j] < array[i][j - 1]) && (array[i][j] < array[i + 1][j])) {
                            id[0] = i;
                            id[1] = j;
                            return id;
                        }
                    } else if (i == array.length - 1) {
                        if ((array[i][j] < array[i - 1][j]) && (array[i][j] < array[i][j - 1])) {
                            id[0] = i;
                            id[1] = j;
                            return id;
                        }
                    } else {
                        if ((array[i][j] < array[i][j - 1]) && (array[i][j] < array[i + 1][j]) && (array[i][j] < array[i - 1][j])) {
                            id[0] = i;
                            id[1] = j;
                            return id;
                        }
                    }
                }
                // top
                if (i == 0 && j != 0 && j != array[1].length-1) {
                    if ((array[i][j] < array[i][j - 1]) && (array[i][j] < array[i][j + 1]) && (array[i][j] < array[i + 1][j])) {
                        id[0] = i;
                        id[1] = j;
                        return id;
                    }
                }
                // bot
                if (i == array.length - 1 && j != 0 && j != array[1].length-1) {
                    if ((array[i][j] < array[i][j - 1]) && (array[i][j] < array[i][j + 1]) && (array[i][j] < array[i - 1][j])) {
                        id[0] = i;
                        id[1] = j;
                        return id;
                    }
                }
                // center
                if (j != 0 && j != array[1].length-1 && i != 0 && i != array.length-1) {
                    if ((array[i][j] < array[i][j - 1]) && (array[i][j] < array[i][j + 1]) && (array[i][j] < array[i - 1][j]) && (array[i][j] < array[i + 1][j])) {
                        id[0] = i;
                        id[1] = j;
                        return id;
                    }
                }
            }
        }

        return id;

    }

    /**
     * Find first local maximum
     *
     * @param array the matrix
     * @return id
     */
    public static int[] localMax(double[][] array) {

        Main.logger.log(Level.INFO, "First local max was found");

        int[] id = {-1,-1};
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[1].length; ++j) {
                // left
                if(j == 0) {
                    if (i == 0) {
                        if ((array[i][j] > array[i][j + 1]) && (array[i][j] > array[i + 1][j])) {
                            id[0] = i;
                            id[1] = j;
                            return id;
                        }
                    } else if (i == array.length - 1) {
                        if ((array[i][j] > array[i - 1][j]) && (array[i][j] > array[i][j + 1])) {
                            id[0] = i;
                            id[1] = j;
                            return id;
                        }
                    } else {
                        if ((array[i][j] > array[i][j + 1]) && (array[i][j] > array[i + 1][j]) && (array[i][j] > array[i - 1][j])) {
                            id[0] = i;
                            id[1] = j;
                            return id;
                        }
                    }
                }
                // right
                if (j == array[1].length - 1) {
                    if (i == 0) {
                        if ((array[i][j] > array[i][j - 1]) && (array[i][j] > array[i + 1][j])) {
                            id[0] = i;
                            id[1] = j;
                            return id;
                        }
                    } else if (i == array.length - 1) {
                        if ((array[i][j] > array[i - 1][j]) && (array[i][j] > array[i][j - 1])) {
                            id[0] = i;
                            id[1] = j;
                            return id;
                        }
                    } else {
                        if ((array[i][j] > array[i][j - 1]) && (array[i][j] > array[i + 1][j]) && (array[i][j] > array[i - 1][j])) {
                            id[0] = i;
                            id[1] = j;
                            return id;
                        }
                    }
                }
                // top
                if (i == 0 && j != 0 && j != array[1].length-1) {
                    if ((array[i][j] > array[i][j - 1]) && (array[i][j] > array[i][j + 1]) && (array[i][j] > array[i + 1][j])) {
                        id[0] = i;
                        id[1] = j;
                        return id;
                    }
                }
                // bot
                if (i == array.length - 1 && j != 0 && j != array[1].length-1) {
                    if ((array[i][j] > array[i][j - 1]) && (array[i][j] > array[i][j + 1]) && (array[i][j] > array[i - 1][j])) {
                        id[0] = i;
                        id[1] = j;
                        return id;
                    }
                }
                // center
                if (j != 0 && j != array[1].length-1 && i != 0 && i != array.length-1) {
                    if ((array[i][j] > array[i][j - 1]) && (array[i][j] > array[i][j + 1]) && (array[i][j] > array[i - 1][j]) && (array[i][j] > array[i + 1][j])) {
                        id[0] = i;
                        id[1] = j;
                        return id;
                    }
                }
            }
        }

        return id;

    }

    /**
     * Trunsp matrix
     *
     * @param array the matrix
     * @return trunsp matrix
     */
    public static double[][] trunsp(double[][] array) {

        System.out.println(array.length);
        System.out.println(array[1].length);

        for (int i = 0; i < array.length; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                double temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }

        Main.logger.log(Level.INFO, "Matrix has been transported");

        return array;

    }

}
