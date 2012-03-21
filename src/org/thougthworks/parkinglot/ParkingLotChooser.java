package org.thougthworks.parkinglot;

import java.util.List;

public interface ParkingLotChooser {
    ParkingFacility choose(List<ParkingLot> parkingLots1);
}
