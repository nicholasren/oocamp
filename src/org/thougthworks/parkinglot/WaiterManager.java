package org.thougthworks.parkinglot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: reaapi
 * Date: 3/20/12
 * Time: 8:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class WaiterManager extends Waiter{
    private List<Waiter> waiters = new ArrayList<Waiter>();

    public void addWaiter(Waiter waiter) {
        this.waiters.add(waiter);
    }

    @Override
    public Receipt park(Car car) {
        for (Waiter waiter : waiters) {
            Receipt receipt = waiter.park(car);
            if (null != receipt)
                return receipt;
        }
        return super.park(car);
    }
}
