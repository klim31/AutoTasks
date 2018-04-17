package com.epam.starikov.tat.module4;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Klim_Starykau on 4/11/2018.
 */
public class MultiTest {
    private Calculator calc;

    @BeforeTest
    public void setUp() {
        calc = new Calculator();
        System.out.println("BeforeClass Mult");
    }


    @Test(dataProvider = "DP for double Mult")
    public void testMultPositive(double a, double b, double c) {
        Assert.assertEquals(calc.mult(a, b), c);
    }

    @Test(dataProvider = "DP for long Mult")
    public void testMultPositive(long a, long b, long c) {
        Assert.assertEquals(calc.mult(a, b), c);
    }

    @Test
    @Parameters({"negativeVal1", "negativeVal2", "negativeVal3"})
    public void testMultNegative(long a, long b, long c) {
        Assert.assertNotEquals(calc.mult(a, b), c);
    }

    @DataProvider(name = "DP for double Mult")
    private Object[][] dPDouble() {
        return new Object[][]{
                {3.5, 2.0, 7.0},
                {7.2, 3.0, 21.6}};
    }

    @DataProvider(name = "DP for long Mult")
    private Object[][] dPLong() {
        return new Object[][]{
                {5L, 1L, 5L},
                {7L, 4L, 28L}};
    }

    @AfterClass
    public void tearDown() {
        System.out.println("AfterClass Mult");
    }
}
