package com.epam.starikov.tat.module4.scenarios;

import com.epam.starikov.tat.module4.Timeout;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Klim_Starykau on 4/23/2018.
 */
public class TimeoutTest {
    private Timeout timeout;

    @BeforeMethod
    public void setUp() throws Exception {
        timeout = new Timeout();
        System.out.println("BeforeClass Timeout");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("AfterClass Timeout");
    }

    @Test
    @Parameters({"Time"})
    public void testSleep(int time) throws Exception {
        long start = System.currentTimeMillis();
        timeout.sleep(time);
        long finish = System.currentTimeMillis();
        Assert.assertTrue((finish - start) == (time*1000));
    }

}