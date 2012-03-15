package org.thougthworks.parkinglot;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: reaapi
 * Date: 3/14/12
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParkingLot {
    private int capacity;

    private Map<Receipt, Car> cars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.cars = new HashMap<Receipt, Car>(capacity);
    }

    public Car unpark(Receipt receipt) {
        return this.cars.get(receipt);
    }

    public Receipt park(Car car) {

        if (availableCapacity() <= 0) {
            return null;
        } else {
            Receipt receipt = new Receipt(this);
            this.cars.put(receipt, car);
            return receipt;
        }
    }

    public int availableCapacity() {
        return capacity - this.cars.size();
    }
}
