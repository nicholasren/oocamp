package org.thougthworks.parkinglot;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: reaapi
 * Date: 3/20/12
 * Time: 8:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class WaiterManagerTest {

    private WaiterManager waiterManager;

    @Before
    public void setUp() throws Exception {
        waiterManager = new WaiterManager();
    }

    @Test
    public void should_park_directly(){
        WaiterManager manager = new WaiterManager();
        manager.addLot(new ParkingLot(2));

        Receipt receipt = manager.park(new Car());
        assertNotNull(receipt);
    }

    @Test
    public void should_unpark_directly(){
        waiterManager.addLot(new ParkingLot(2));
        Car myCar = new Car();

        Receipt receipt = waiterManager.park(myCar);
        assertThat(waiterManager.unpark(receipt), is(myCar));
    }

    @Test
    public void should_ask_waiter_help_to_park(){
        Waiter waiter = new Waiter();
        ParkingLot parkingLot = new ParkingLot(2);
        waiter.addLot(parkingLot);
        
        waiterManager.addWaiter(waiter);
        Car car = new Car();
        waiterManager.park(car);
        assertThat(parkingLot.availableCapacity(), is(1) );
    }

    @Test
    public void should_ask_waiter_help_to_park_as_posiable(){
        Waiter waiter = new Waiter();
        ParkingLot parkingLot = new ParkingLot(0);
        waiter.addLot(parkingLot);

        Waiter waiter2 = new Waiter();
        ParkingLot parkingLot2 = new ParkingLot(2);
        waiter2.addLot(parkingLot2);

        waiterManager.addWaiter(waiter);
        waiterManager.addWaiter(waiter2);
        Car car = new Car();
        Receipt receipt = waiterManager.park(car);
        assertNotNull(receipt);
        assertThat(parkingLot2.availableCapacity(), is(1) );
    }

    @Test
    public void should_directly_if_all_waiters_are_not_available(){
        Waiter waiter = new Waiter();
        ParkingLot parkingLot = new ParkingLot(0);
        waiter.addLot(parkingLot);

        Waiter waiter2 = new Waiter();
        ParkingLot parkingLot2 = new ParkingLot(0);
        waiter2.addLot(parkingLot2);

        waiterManager.addWaiter(waiter);
        waiterManager.addWaiter(waiter2);
        ParkingLot parkingLot3 = new ParkingLot(3);
        waiterManager.addLot(parkingLot3);

        Car car = new Car();
        Receipt receipt = waiterManager.park(car);
        assertNotNull(receipt);
        assertThat(parkingLot3.availableCapacity(), is(2) );
    }
}
