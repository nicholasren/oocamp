package org.thougthworks.parkinglot;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: reaapi
 * Date: 3/15/12
 * Time: 7:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ParkingLotChooser {
    ParkingLot choose(List<ParkingLot> parkingLots1);
}
