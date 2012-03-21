package org.thougthworks.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Waiter implements ParkingFacility{

    private ParkingLotChooser chooser;

    public Waiter() {
        this(new NormalParkingLotChooser());
    }

    public Waiter(ParkingLotChooser chooser) {
        this.chooser = chooser;
    }

    private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

    public Receipt park(Car car) {
        ParkingFacility availableParking = chooser.choose(parkingLots);
        return availableParking == null ? null : availableParking.park(car);
    }

    @Override
    public String toString() {
        return report(0);
    }

    public String report(String indent) {
        return report(0);
    }

    public String report(int depth) {
        StringBuilder reportBuilder = new StringBuilder();
        indent(depth, reportBuilder);

        reportBuilder.append("Waiter").append(":").append("\n");
        for (int index = 0; index < parkingLots.size(); index++) {
            reportBuilder.append(parkingLots.get(index).report(depth + 1));
            if (index < parkingLots.size() - 1)
                reportBuilder.append("\n");
        }
        return reportBuilder.toString();
    }

    private void indent(int depth, StringBuilder reportBuilder) {
        for(int i=0; i< depth; i++){
            reportBuilder.append("  ");
        }
    }

    public Car unpark(Receipt receipt) {
        for (ParkingFacility lot : parkingLots) {
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
