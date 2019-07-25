package by.epam.javatraining.kolesnik.tasks;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;

/**
 *
 * @author Misha Kolesnik
 * @date 25.07.2019
 *
 * Class provides all methods to work with one dem arrays
 *
 */
public class oneDemArray {

    public static double[] array;

    /**
     * Construct that fill array with random numbers
     */
    public oneDemArray() {

        this.array = new double[10];
        Random random = new Random();
        for (int i = 0; i < 10; ++i) {
            array[i] = random.nextDouble();
        }

        Main.logger.log(Level.INFO, "Array was filled with random numbers");

    }

    /**
     * Construct with ready array
     *
     * @param array
     */
    public oneDemArray(double[] array) {
        this.array = array;

        Main.logger.log(Level.INFO, "Array was created");

    }

    /**
     * Print array in console
     */
    public void printArray() {

        for (double i: array) {
            System.out.print(i + "  ");
        }

        Main.logger.log(Level.INFO, "Array was printed");

    }

    /**
     * Reverse the array
     *
     * @param array
     * @return reversed array
     */
    public static ArrayList<Double> reverse(ArrayList<Double> array) {

        int border = array.size()/2;
        for (int i = 0; i < border; ++i) {
            array.set(i, (array.get(i) + array.get(array.size() - 1 - i)));
            array.set(array.size() - 1 - i, (array.get(i) - array.get(array.size() - 1 - i)));
            array.set(i, (array.get(i) - array.get(array.size() - 1 - i)));
        }

        Main.logger.log(Level.INFO, "Array was reversed");

        return array;

    }

    /**
     * Find the id's of min element
     *
     * @param array
     * @return id's
     */
    public static ArrayList<Integer> minElement(ArrayList<Double> array) {

        double minElemnt = array.get(0);
        ArrayList<Integer> minElID = new ArrayList();
        if (Utils.hasDiff(array)) {
            for (int i = 1; i < array.size(); ++i) {
                if (array.get(i) < minElemnt) {
                    minElemnt = array.get(i);
                }
            }
            minElID = Utils.equalElID(minElemnt, array);
        } else {
            minElID.add(-1);
        }

        Main.logger.log(Level.INFO, "Id's of min elements were found");

        return minElID;

    }

    /**
     * Find the id's of max element
     *
     * @param array
     * @return id's
     */
    public static ArrayList<Integer> maxElement(ArrayList<Double> array) {

        double maxElemnt = array.get(0);
        ArrayList<Integer> maxElID = new ArrayList();
        if (Utils.hasDiff(array)) {
            for (int i = 1; i < array.size(); ++i) {
                if (array.get(i) > maxElemnt) {
                    maxElemnt = array.get(i);
                }
            }
            maxElID = Utils.equalElID(maxElemnt, array);
        } else {
            maxElID.add(-1);
        }

        Main.logger.log(Level.INFO, "Id's of max elements were found");

        return maxElID;

    }

    /**
     * Find arifm average of array
     *
     * @param array
     * @return arifm average
     */
    public static double arifmAverage(ArrayList<Double> array) {

        int sum = 0;
        for (double i: array) {
            sum += i;
        }

        Main.logger.log(Level.INFO, "Arifm average was found");

        return sum/(double)array.size();

    }

    /**
     * Find geom average of array
     *
     * @param array
     * @return geom average
     */
    public static double geomAverage(ArrayList<Double> array) {

        int pro = 1;
        for (double i: array) {
            pro *= i;
        }

        Main.logger.log(Level.INFO, "Geom average was found");

        return Math.pow(pro, 1/(double)array.size());

    }

    /**
     * Find first local min of array
     *
     * @param array
     * @return id of local min
     */
    public static int localMin(ArrayList<Double> array) {

        Main.logger.log(Level.INFO, "First local min was found");

        int border = array.size() - 1;
        if ((array.size() == 1) || (array.get(0) < array.get(1))) {
            return 0;
        }
        for (int i = 1; i < border; ++i) {
            if ((array.get(i) < array.get(i - 1)) && (array.get(i) < array.get(i + 1))) {
                return i;
            }
        }
        if (array.get(border) < array.get(border - 1)) {
            return border;
        }

        return -1;

    }

    /**
     * Find first local max of array
     *
     * @param array
     * @return id of local max
     */
    public static int localMax(ArrayList<Double> array) {

        Main.logger.log(Level.INFO, "First local max was found");

        int border = array.size() - 1;
        if ((array.size() == 1) || (array.get(0) > array.get(1))) {
            return 0;
        }
        for (int i = 1; i < border; ++i) {
            if ((array.get(i) > array.get(i - 1)) && (array.get(i) > array.get(i + 1))) {
                return i;
            }
        }
        if (array.get(border) > array.get(border - 1)) {
            return border;
        }

        return -1;

    }

    /**
     * Check for sort
     *
     * @param array
     * @return {@code true} if incr, {@code false} if else
     */
    public static boolean isIncreasing(ArrayList<Double> array) {

        boolean isIncreasing = true;
        int border = array.size() - 1;
        for (int i = 0; i < border; ++i) {
            if (array.get(i) > array.get(i + 1)) {
                isIncreasing = false;
            }
        }

        Main.logger.log(Level.INFO, "Increasing check has been made");

        return isIncreasing;

    }

    /**
     * Check for sort
     *
     * @param array
     * @return {@code true} if decr, {@code false} if else
     */
    public static boolean isDecreasing(ArrayList<Double> array) {

        boolean isDecreasing = true;
        int border = array.size() - 1;
        for (int i = 0; i < border; ++i) {
            if (array.get(i) < array.get(i + 1)) {
                isDecreasing = false;
            }
        }

        Main.logger.log(Level.INFO, "Decreasing check has been made");

        return isDecreasing;

    }

}
