package com.company.award;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Klim_Starykau on 2/19/2018.
 */

public interface AwardService {

    /**
     * Method for creation of the default array of awards
     */
    ArrayList<Award> createAwards(int count, String type);

    /**
     * Method for outputting sorted ArrayList of specific type awards and a set of all the award types
     *
     * @param awards List of awards to be sorted
     * @param type   Type of award to be included into sorted table
     */
    void printAwards(List<Award> awards, String type);
}
