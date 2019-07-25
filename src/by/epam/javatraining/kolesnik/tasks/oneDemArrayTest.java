package by.epam.javatraining.kolesnik.tasks;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 *
 * @author Misha Kolesnik
 * @date 25.07.2019
 *
 * Class that make tests with all oneDemArray methods
 *
 */

public class oneDemArrayTest {

    ArrayList<Double> array = new ArrayList();

    @Before
    public void init(){
        array.add(4.0);
        array.add(3.0);
        array.add(1.0);
        array.add(1.0);
    }

    @Test
    public void reverse() {

        ArrayList<Double> extend = new ArrayList();
        extend.add(1.0);
        extend.add(1.0);
        extend.add(3.0);
        extend.add(4.0);
        array = oneDemArray.reverse(array);
        for (int i = 0; i < array.size(); ++i) {
            assertEquals(extend.get(i), array.get(i));
        }

    }

    @Test
    public void minElement() {

        int extend[] = {2,3};
        ArrayList<Integer> get = oneDemArray.minElement(array);
        for (int i = 0; i < get.size(); ++i) {
            assertEquals(extend[i], get.get(i));
        }

    }

    @Test
    public void maxElement() {

        int extend[] = {0};
        ArrayList<Integer> get = oneDemArray.maxElement(array);
        for (int i = 0; i < get.size(); ++i) {
            assertEquals(extend[i], get.get(i));
        }

    }

    @Test
    public void arifmAverage() {

        double extend = 2.25;
        assertEquals(extend, oneDemArray.arifmAverage(array));

    }

    @Test
    public void geomAverage() {

        assertEquals(1.8612097182041991, oneDemArray.geomAverage(array));

    }

    @Test
    public void localMin() {

        assertEquals(-1, oneDemArray.localMin(array));

    }

    @Test
    public void localMax() {

        assertEquals(0, oneDemArray.localMax(array));

    }

    @Test
    public void isIncreasing() {

        ArrayList<Double> ar = new ArrayList();
        ar.add(1.0);
        ar.add(2.0);
        ar.add(3.0);
        ar.add(4.0);
        assertEquals(true, oneDemArray.isIncreasing(ar));

    }

    @Test
    public void isDecreasing() {

        ArrayList<Double> ar = new ArrayList();
        ar.add(4.0);
        ar.add(3.0);
        ar.add(2.0);
        ar.add(1.0);
        assertEquals(true, oneDemArray.isDecreasing(ar));

    }
}
