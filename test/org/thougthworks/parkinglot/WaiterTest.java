package org.thougthworks.parkinglot;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: reaapi
 * Date: 3/14/12
 * Time: 7:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class WaiterTest {

    private Waiter waiter;

    @Before
    public void setUp() throws Exception {
        waiter = new Waiter();
    }

    @Test
    public void should_return_the_parking_id_give_parking_succeed() {
        Car car = new Car();

        ParkingLot lot1 = new ParkingLot(10);
        ParkingLot lot2 = new ParkingLot(10);

        waiter.addLot(lot1);
        waiter.addLot(lot2);

        assertNotNull(waiter.park(car));
        assertThat(waiter.availableCapacity(), is(19));
    }


    @Test
    public void should_return_the_car_that_i_parked() {
        Car car = new Car();
        ParkingLot lot1 = new ParkingLot(10);
        ParkingLot lot2 = new ParkingLot(10);
        waiter.addLot(lot1);
        waiter.addLot(lot2);

        Receipt receipt = waiter.park(car);
        assertThat(waiter.unpark(receipt), is(car));
    }

    @Test
    public void should_not_return_the_car_that_i_have_not_parked() {
        ParkingLot lot1 = new ParkingLot(10);
        ParkingLot lot2 = new ParkingLot(10);
        waiter.addLot(lot1);
        waiter.addLot(lot2);

        assertNull(waiter.unpark(null));
    }

    @Test
    public void should_parking_car_if_any_parking_lot_available() {
        waiter.addLot(new ParkingLot(0));
        waiter.addLot(new ParkingLot(1));
        Car car = new Car();
        Receipt parkingID = waiter.park(car);
        assertThat(waiter.unpark(parkingID), is(car));
    }

}
