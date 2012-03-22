package org.thougthworks.parkinglot;

/**
 * Created by IntelliJ IDEA.
 * User: reaapi
 * Date: 3/21/12
 * Time: 7:07 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ParkingFacility {

    Car unpark(Receipt receipt);

    Receipt park(Car car);

    String report(int depth);
}
