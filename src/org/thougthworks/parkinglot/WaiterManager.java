package org.thougthworks.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class WaiterManager extends Waiter {
    private List<ParkingFacility> facilities = new ArrayList<ParkingFacility>();

    public void addWaiter(Waiter waiter) {
        this.facilities.add(waiter);
    }

    @Override
    public Receipt park(Car car) {
        for (ParkingFacility facility : facilities) {
            Receipt receipt = facility.park(car);
            if (null != receipt)
                return receipt;
        }
        return super.park(car);
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
        for(int i=0; i < depth; i++){
            reportBuilder.append("  ");
        }
        reportBuilder.append(this.getClass().getSimpleName()).append(":")
                .append("\n");

        for (int index = 0; index < facilities.size(); index++) {
            List<ParkingFacility> waiter = facilities;
            reportBuilder.append(waiter.get(index).report(depth + 1));
            if (index < facilities.size() - 1)
                reportBuilder.append("\n");
        }


        return reportBuilder.toString();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
