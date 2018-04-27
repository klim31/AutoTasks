package com.epam.starikov.tat.module4.scenarios;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Klim_Starykau on 4/11/2018.
 */
public class SumTest {

    private Calculator calc;

    @BeforeTest(groups = {"Double Values Sum"})
    public void setUp() {
        calc = new Calculator();
    }


    @Test(dataProvider = "DP for double sum", groups = {"Double Values Sum"})
    public void testSumPositiveDouble(double a, double b, double c) {
        Assert.assertEquals(calc.sum(a, b), c);
    }

    @Test(dependsOnGroups = "Double Values Sum",dataProvider = "DP for long sum", groups = {"Long Values Sum"})
    public void testSumPositiveLong(long a, long b, long c) {
        Assert.assertEquals(calc.sum(a, b), c);
    }


    @Test(groups = {"Double Values Sum"})
    @Parameters({"negativeVal1", "negativeVal2", "negativeVal3"})
    public void testSumNegative(long a, long b, long c) {
        Assert.assertNotEquals(calc.sum(a, b), c);
    }

    @DataProvider(name = "DP for double sum")
    private Object[][] dPDouble() {
        return new Object[][]{
                {1.5, 5.0, 6.5},
                {7.2, 8.0, 15.2}};
    }

    @DataProvider(name = "DP for long sum")
    private Object[][] dPLong() {
        return new Object[][]{
                {1, 5, 6},
                {7, 8, 15}};
    }

    @AfterClass
    public void tearDown() {
        System.out.println("AfterClass Sum");
    }


}
