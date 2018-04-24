package com.epam.starikov.tat.module4.scenarios;

import com.epam.starikov.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Klim_Starykau on 4/24/2018.
 */
public class IsNegativeTest {
    private Calculator calc;

    @BeforeTest
    public void setUp() {
        calc = new Calculator();
        System.out.println("BeforeClass IsNegative");
    }


    @Test(dataProvider = "DP for long Negative")
    public void testIsPositive(long a, boolean b) {
        Assert.assertEquals(calc.isNegative(a), b);
    }


    @DataProvider(name = "DP for long Negative")
    private Object[][] dPLong() {
        return new Object[][]{
                {1, false},
                {-7, true}};
    }

    @AfterClass
    public void tearDown() {
        System.out.println("AfterClass IsNegative");
    }
}
