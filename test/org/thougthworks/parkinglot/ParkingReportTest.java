package org.thougthworks.parkinglot;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParkingReportTest {

    @Test
    public  void should_report_given_parking_lot() {

        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.park(new Car());
        String reportResult = parkingLot.toString();

        assertThat(reportResult, is("ParkingLot:1/3"));
    }


    @Test
    public  void should_report_given_waiter() {

        Waiter waiter = new Waiter();
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.park(new Car());
        waiter.addLot(parkingLot);
        String reportResult = waiter.report(new Waiter.Report().getDepth());

        assertThat(reportResult, is("Waiter:\n  ParkingLot:1/3"));
    }

    @Test
    public  void should_report_given_manager() {

        WaiterManager manager = new WaiterManager();

        Waiter waiter = new Waiter();
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.park(new Car());
        waiter.addLot(parkingLot);

        manager.addWaiter(waiter);

        String reportResult = manager.toString();

        assertThat(reportResult, is("WaiterManager:\n"
                                   +"  Waiter:\n"
                                   +"    ParkingLot:1/3"));
    }
}
