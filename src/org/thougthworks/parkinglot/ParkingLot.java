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
public class ParkingLot implements ParkingFacility {
    private int capacity;

    private Map<Receipt, Car> cars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.cars = new HashMap<Receipt, Car>(capacity);
    }

    @Override
    public Car unpark(Receipt receipt) {
        return this.cars.get(receipt);
    }

    @Override
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

    @Override
    public String toString() {
        String indent = "";
        return report(indent);
    }

    public String report(String indent) {
        return report(0);
    }

    public String report(int depth) {
        StringBuilder reportBuilder = new StringBuilder();
        indent(reportBuilder, depth);
        return reportBuilder.append(this.getClass().getSimpleName()).append(":")
                .append(capacity - this.availableCapacity()).append("/").append(capacity).toString();
    }

    private void indent(StringBuilder reportBuilder, int depth) {
        for(int i=0; i < depth; i++){
            reportBuilder.append("  ");
        }
    }
}
