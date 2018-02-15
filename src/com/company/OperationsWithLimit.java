package com.company;

/**
 * Created by Klim_Starykau on 1/29/2018.
 */
public interface OperationsWithLimit {

    /**
     * Interface for imlementation of the method for checking the limit of user's award giving/recieving capacity
     *
     * @param averageValue i.e Current value, shows it's current state
     * @param limitValue   value to be reached to stop the nomination procedure
     */

    public boolean isLimitReached(double averageValue, double limitValue);
}
