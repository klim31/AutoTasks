package com.company;

import java.util.Random;

/**
 * Created by Klim_Starykau on 1/3/2018.
 */
public class UtilClass {
    public float randomDecimal() {
        Random rand = new Random();
        float f = rand.nextFloat();
        return f;
    }

    public int randomInt() {
        Random rand = new Random();
        int z = rand.nextInt(1) + 5;
        return z;
    }

}
