package org.thougthworks.parkinglot;

import java.util.List;

public class SmartParkingLotChooser implements ParkingLotChooser {

    public ParkingLot choose(List<ParkingLot> parkingLots) {
        Integer maxSlots = 0;
        ParkingLot maxParking = null;
        for(ParkingLot parking : parkingLots) {
            if (parking.availableCapacity() > maxSlots) {
                maxSlots = parking.availableCapacity();
                maxParking = parking;
            }
        }
        return maxParking;
    }
}
