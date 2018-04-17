package com.epam.starikov.tat.module4;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Klim_Starykau on 4/14/2018.
 */
public class SqrtTest {
    private Calculator calc;

    @BeforeTest
    public void setUp() {
        calc = new Calculator();
        System.out.println("BeforeClass Sqrt");
    }


    @Test(dataProvider = "DP for Sqrt")
    public void testSqrt(double a, double b) {
        Assert.assertEquals(calc.sqrt(a), b);
    }


    @Test(expectedExceptions = Exception.class)
    @Parameters({"negativeVal1"})
    public void testSqrtNegative(double a) {
        calc.sqrt(a);
    }

    @DataProvider(name = "DP for Sqrt")
    private Object[][] dPLong() {
        return new Object[][]{
                {4.0, 2.0},
                {1.0, 1.0}};
    }

    @AfterClass
    public void tearDown() {
        System.out.println("AfterClass Sqrt");
    }
}
