package pers.vay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyTest {

    Daily daily = new Daily();

    @Test
    void distributeCandies() {
        int[] ans = {1,2,3,1};
        int[] ans2 = {5,2,3};
        assertArrayEquals(daily.distributeCandies(7, 4), ans);
        assertArrayEquals(daily.distributeCandies(10, 3), ans2);
    }

    @Test
    void findContinuousSequence() {
//        daily.findContinuousSequence(9);
        daily.findContinuousSequence(98160);
    }

    @Test
    void maxProfit() {
        int[] test1 = {7,1,5,3,6,4};
        assertEquals(daily.maxProfit(test1), 5);
        int[] test2 = {7,6,4,3,1};
        assertEquals(daily.maxProfit(test2), 0);
    }

}