package org.thougthworks.parkinglot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: reaapi
 * Date: 3/15/12
 * Time: 7:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class SmarterWaiterTest {
    @Test
    public void should_park_to_the_one_has_less_lots(){
        ParkingLot withMoreLots = new ParkingLot(5);
        ParkingLot withLessLots = new ParkingLot(2);
        Waiter smarterWaiter = new Waiter(new SmarterParkingLotChooser());
        smarterWaiter.addLot(withLessLots);
        smarterWaiter.addLot(withMoreLots);

        Car car = new Car();
        Receipt receipt = smarterWaiter.park(car);
        assertThat(receipt.parking(), is(withLessLots));
    }
}
