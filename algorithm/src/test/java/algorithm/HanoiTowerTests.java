package algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HanoiTowerTests {

    @Test
    public void givenBlockNumberThenReturnTimes() {
        HanoiTower hanoiTower = new HanoiTower();
        int times = hanoiTower.run(3);
        Assertions.assertEquals(7, times);
        System.out.println("-------------------------------");

        times = hanoiTower.run(2);
        Assertions.assertEquals(3, times);
        System.out.println("-------------------------------");

        times = hanoiTower.run(4);
        Assertions.assertEquals(15, times);
    }
}
