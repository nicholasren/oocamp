package org.thougthworks.parkinglot;

import java.util.List;

/**
* Created by IntelliJ IDEA.
* User: reaapi
* Date: 3/15/12
* Time: 7:36 PM
* To change this template use File | Settings | File Templates.
*/
public class NormalParkingLotChooser implements ParkingLotChooser {

    public ParkingLot choose(List<ParkingLot> parkingLots1) {
        ParkingLot availableParking = null;
        for (ParkingLot parking : parkingLots1) {
            if (parking.availableCapacity() > 0) {
                availableParking = parking;
            }
        }
        return availableParking;
    }
}
