package org.thougthworks.parkinglot;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: reaapi
 * Date: 3/14/12
 * Time: 6:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParkingLotTest {

    @Test
    public void should_park_succeed_if_not_full(){
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(10);
        parkingLot.park(car);
        assertThat(parkingLot.availableCapacity(), is(9));
    }


    @Test
    public void should_park_failed_if_full(){
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(car1);
        assertThat(parkingLot.availableCapacity(), is(0));
        assertNull(parkingLot.park(car2));

    }

    @Test
    public void should_unpark_failed_if_is_empty(){
        ParkingLot parkingLot = new ParkingLot(0);
        assertNull(parkingLot.unpark(null));
    }

    @Test
    public void should_unpark_car_by_receipt(){
        Car car1 = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        Receipt parkingID = parkingLot.park(car1);
        assertThat(car1, is(parkingLot.unpark(parkingID)));
    }
}
