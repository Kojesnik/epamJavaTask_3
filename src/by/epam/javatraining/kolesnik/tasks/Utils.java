package by.epam.javatraining.kolesnik.tasks;

import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author Misha Kolesnik
 * @date 25.07.2019
 *
 * Class provides all utils
 *
 */
public class Utils {

    /**
     * Find all equal elements
     *
     * @param array
     * @return array of equal element id's
     */
    public static ArrayList<Integer> equalElID(double num, ArrayList<Double> array) {

        ArrayList<Integer> equalID = new ArrayList();
        for (int i = 0; i < array.size(); ++i) {
            if (array.get(i) == num) {
                equalID.add(i);
            }
        }

        Main.logger.log(Level.INFO, "All id's of equal elements were found");

        return equalID;

    }

    /**
     * Check on diff of elements
     *
     * @param array
     * @return {@code true} if array has diff elements, {@code false} if array has not diff elements
     */
    public static boolean hasDiff(ArrayList<Double> array) {

        Main.logger.log(Level.INFO, "Check for different elements has been made");

        for (int i = 0; i < array.size()/2; ++i) {
            for (int j = i+1; j < array.size(); ++j) {
                if (array.get(i).equals(array.get(j)) == false) {
                    return true;
                }
            }
        }

        return false;

    }

}
