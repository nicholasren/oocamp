package org.thougthworks.parkinglot;

/**
 * Created by IntelliJ IDEA.
 * User: reaapi
 * Date: 3/14/12
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Receipt {
    private ParkingLot parkingLot;

    public Receipt(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Receipt() {
    }

    public ParkingLot parking() {
        return parkingLot;
    }
}
