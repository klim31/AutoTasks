package com.company;

import java.util.ArrayList;

/**
 * Created by Klim_Starykau on 1/3/2018.
 */
public class QuantitiesComparator {
    public void compare(ArrayList<Double> quantities) {
        if (quantities.get(0) > quantities.get(1)) {
            System.out.println(quantities.get(0) + " is greater than " + quantities.get(1));
        } else {
            System.out.println(quantities.get(1) + " is greater or equal to " + quantities.get(0));
        }
        if (quantities.get(0).floatValue() >= quantities.get(1).floatValue()) {
            System.out.println(quantities.get(0) + " is greater or equal to " + quantities.get(1));
        }
        if (quantities.get(0).floatValue() == quantities.get(1).floatValue()) {
            System.out.println(quantities.get(0) + " is equal to " + quantities.get(1));
        }
        if (quantities.get(0).floatValue() != quantities.get(1).floatValue()) {
            System.out.println(quantities.get(0) + " is not equal to " + quantities.get(1));
        }
        if (quantities.get(0).floatValue() <= quantities.get(1).floatValue()) {
            System.out.println(quantities.get(0) + " is lesser or equal to " + quantities.get(1));
        }
        if ((quantities.get(0).floatValue() > 3) && (quantities.get(1).floatValue() > 3)) {
            System.out.println(quantities.get(0) + " and " + quantities.get(1) + " are both greater than 3");
        }
        if ((quantities.get(0).floatValue() > 3) || (quantities.get(1).floatValue() > 3)) {
            System.out.println(quantities.get(0) + " or " + quantities.get(1) + "is greater than 3");
        }
        if (!(quantities.get(0).floatValue() < 2)) {
            System.out.println(quantities.get(0) + " is not less than 2");
        }
    }

}
