package org.thougthworks.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Waiter {

    private ParkingLotChooser chooser;

    public Waiter() {
        this(new NormalParkingLotChooser());
    }

    public Waiter(ParkingLotChooser chooser) {
        this.chooser = chooser;
    }

    private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

    public Receipt park(Car car) {
        ParkingLot availableParking = chooser.choose(parkingLots);
        return availableParking == null ? null : availableParking.park(car);
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

    public Integer slots() {
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
