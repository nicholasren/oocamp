package org.thougthworks.parkinglot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: reaapi
 * Date: 3/14/12
 * Time: 7:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Waiter {


    public Waiter() {
    }


    private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

    public Receipt park(Car car) {
        for (ParkingLot lot : parkingLots) {
            Receipt receipt = lot.park(car);
            if (null != receipt) {
                return receipt;
            }
        }
        return null;
    }

    public Car unpark(Receipt receipt) {
        for (ParkingLot lot : parkingLots) {
            Car car = lot.unpark(receipt);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

    public Integer availableCapacity() {
        Integer availableCapacity = 0;
        for(ParkingLot lot : parkingLots){
            availableCapacity += lot.availableCapacity();
        }
        return availableCapacity;
    }

    public void addLot(ParkingLot lot) {
        this.parkingLots.add(lot);
    }
}
