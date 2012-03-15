package org.thougthworks.parkinglot;

import java.util.List;

/**
* Created by IntelliJ IDEA.
* User: reaapi
* Date: 3/15/12
* Time: 7:33 PM
* To change this template use File | Settings | File Templates.
*/
public class SmarterParkingLotChooser implements ParkingLotChooser{

    @Override
    public ParkingLot choose(List<ParkingLot> parkingLots1) {
        Integer minSlots = Integer.MAX_VALUE;
        ParkingLot minParking = null;
        for(ParkingLot parking : parkingLots1) {
            if (parking.availableCapacity() < minSlots) {
                minSlots = parking.availableCapacity();
                minParking = parking;
            }
        }
        return minParking;
    }
}
