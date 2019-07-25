package by.epam.javatraining.kolesnik.tasks;

import by.epam.javatraining.kolesnik.tasks.Utils;

import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author Misha Kolesnik
 * @date 25.07.2019
 *
 * Class provides all search methods
 *
 */
public class Search {

    /**
     * Linear search
     */
    public static ArrayList<Integer> linearSearch(ArrayList<Double> array, double elToSearch) {

        Main.logger.log(Level.INFO, "Search");

        ArrayList<Integer> allIDs = new ArrayList();
        for (int i = 0; i < array.size(); ++i) {
            if (array.get(i) == elToSearch) {
                allIDs = Utils.equalElID(array.get(i), array);
                return allIDs;
            }
        }
        allIDs.add(-1);

        return allIDs;

    }

    /**
     * Binary search
     */
    public static ArrayList<Integer> binarySearch(ArrayList<Double> array, double elToSearch) {

        Main.logger.log(Level.INFO, "Search");

        ArrayList<Integer> allIDs = new ArrayList();
        int firstID = 0;
        int lastID = array.size() - 1;
        int middleID;
        while (firstID != lastID) {
            middleID =firstID + (lastID - firstID)/2;
            if (elToSearch > array.get(middleID)) {
                firstID = middleID;
            } else if (elToSearch < array.get(middleID)) {
                lastID = middleID;
            } else if (elToSearch == array.get(middleID)){
                allIDs = Utils.equalElID(array.get(middleID), array);
                return allIDs;
            }
        }

        if (array.get(firstID) == elToSearch) {
            allIDs = Utils.equalElID(array.get(firstID), array);
        } else {
            allIDs.add(-1);
        }

        return allIDs;

    }

}
