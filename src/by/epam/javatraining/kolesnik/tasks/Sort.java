package by.epam.javatraining.kolesnik.tasks;

import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author Misha Kolesnik
 * @date 25.07.2019
 *
 * Class provides all sort methods
 *
 */
public class Sort {

    /**
     * Bubble sort
     */
    public static ArrayList<Double> bubbleSortIN(ArrayList<Double> array) {

        int border = array.size() - 1;
        boolean isSorted = false;
        while (isSorted == false) {
            isSorted = true;
            for (int i = 0; i < border; ++i) {
                if (array.get(i) > array.get(i + 1)) {
                    array.set(i, array.get(i) + array.get(i + 1));
                    array.set(i + 1, array.get(i) - array.get(i + 1));
                    array.set(i, array.get(i) - array.get(i + 1));
                    isSorted = false;
                }
            }
        }

        Main.logger.log(Level.INFO, "Array sorted");

        return array;

    }

    public static ArrayList<Double> bubbleSortDE(ArrayList<Double> array) {

        int border = array.size() - 1;
        boolean isSorted = false;
        while (isSorted == false) {
            isSorted = true;
            for (int i = 0; i < border; ++i) {
                if (array.get(i) < array.get(i + 1)) {
                    array.set(i, array.get(i) + array.get(i + 1));
                    array.set(i + 1, array.get(i) - array.get(i + 1));
                    array.set(i, array.get(i) - array.get(i + 1));
                    isSorted = false;
                }
            }
        }

        Main.logger.log(Level.INFO, "Array sorted");

        return array;

    }

    /**
     * Insert sort
     */
    public static ArrayList<Double> insertSortIN(ArrayList<Double> array) {

        int border = array.size() - 1;
        for (int i = 0; i < border; ++i) {
            if (array.get(i) > array.get(i + 1)) {
                array.set(i, array.get(i) + array.get(i + 1));
                array.set(i + 1, array.get(i) - array.get(i + 1));
                array.set(i, array.get(i) - array.get(i + 1));
                for (int j = i; j > 0; --j) {
                    if (array.get(j) < array.get(j - 1)) {
                        array.set(j, array.get(j) + array.get(j - 1));
                        array.set(j - 1, array.get(j) - array.get(j - 1));
                        array.set(j, array.get(j) - array.get(j - 1));
                    }
                }
            }
        }

        Main.logger.log(Level.INFO, "Array sorted");

        return array;

    }

    public static ArrayList<Double> insertSortDE(ArrayList<Double> array) {

        int border = array.size() - 1;
        for (int i = 0; i < border; ++i) {
            if (array.get(i) < array.get(i + 1)) {
                array.set(i, array.get(i) + array.get(i + 1));
                array.set(i + 1, array.get(i) - array.get(i + 1));
                array.set(i, array.get(i) - array.get(i + 1));
                for (int j = i; j > 0; --j) {
                    if (array.get(j) > array.get(j - 1)) {
                        array.set(j, array.get(j) + array.get(j - 1));
                        array.set(j - 1, array.get(j) - array.get(j - 1));
                        array.set(j, array.get(j) - array.get(j - 1));
                    }
                }
            }
        }

        Main.logger.log(Level.INFO, "Array sorted");

        return array;

    }

    /**
     * Selection sort
     */
    public static ArrayList<Double> selectionSortIN(ArrayList<Double> array) {

        int border = array.size() - 1;
        double min;
        int minID;
        for (int i = 0; i < border; ++i) {
            min = array.get(i);
            minID = i;
            for (int j = i + 1; j < array.size(); ++j) {
                if (array.get(j) < min) {
                    min = array.get(j);
                    minID = j;
                }
            }

            double tmp = array.get(i);
            array.set(i, array.get(minID));
            array.set(minID, tmp);
        }

        Main.logger.log(Level.INFO, "Array sorted");

        return array;

    }

    public static ArrayList<Double> selectionSortDE(ArrayList<Double> array) {

        int border = array.size() - 1;
        double max;
        int maxID;
        for (int i = 0; i < border; ++i) {
            max = array.get(i);
            maxID = i;
            for (int j = i + 1; j < array.size(); ++j) {
                if (array.get(j) > max) {
                    max = array.get(j);
                    maxID = j;
                }
            }

            double temp = array.get(i);
            array.set(i, array.get(maxID));
            array.set(maxID, temp);
        }

        Main.logger.log(Level.INFO, "Array sorted");

        return array;

    }

    /**
     * Quick sort
     */
    public static ArrayList<Double> quickSort(ArrayList<Double> array, int start, int end) {

        if (start >= end) {
            return array;
        }
        int i = start;
        int j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array.get(i) <= array.get(cur))) {
                i++;
            }
            while (j > cur && (array.get(cur) <= array.get(j))) {
                j--;
            }
            if (i < j) {
                double temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        quickSort(array, start, cur);
        quickSort(array,cur+1, end);

        Main.logger.log(Level.INFO, "Array sorted");

        return array;

    }



}
