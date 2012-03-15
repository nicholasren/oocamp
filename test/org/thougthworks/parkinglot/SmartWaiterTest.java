package org.thougthworks.parkinglot;

import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SmartWaiterTest {

    @Test
    public void should_parking_to_the_one_has_more_lots(){
        ParkingLot withMoreLots = new ParkingLot(5);
        ParkingLot withLessLots = new ParkingLot(2);
        Waiter smartWaiter = new Waiter(new SmartParkingLotChooser());
        smartWaiter.addLot(withLessLots);
        smartWaiter.addLot(withMoreLots);

        Car car = new Car();
        Receipt receipt = smartWaiter.park(car);
        assertThat(receipt.parking(), is(withMoreLots));
    }

    @Test
    public void should_parking_failed_if_is_full(){
        ParkingLot withMoreLots = new ParkingLot(0);
        ParkingLot withLessLots = new ParkingLot(0);
        Waiter smartWaiter = new Waiter(new SmartParkingLotChooser());
        smartWaiter.addLot(withLessLots);
        smartWaiter.addLot(withMoreLots);

        Car car = new Car();
        Receipt receipt = smartWaiter.park(car);
        assertNull(receipt);

    }
}
