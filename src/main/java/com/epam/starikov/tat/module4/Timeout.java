package com.epam.starikov.tat.module4;

/**
 * Created by Klim_Starykau on 4/11/2018.
 */
public class Timeout {
    public Timeout() {
    }

    public static void sleep(int sec) {
        try {
            Thread.sleep((long) (sec * 1000));
        } catch (InterruptedException var2) {
            ;
        }

    }
}
