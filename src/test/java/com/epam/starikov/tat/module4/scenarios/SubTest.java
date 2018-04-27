package com.epam.starikov.tat.module4.scenarios;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Klim_Starykau on 4/11/2018.
 */
public class SubTest {
    private Calculator calc;

    @BeforeTest
    public void setUp() {
        calc = new Calculator();
        System.out.println("BeforeClass Sub");
    }

    @Test(dataProvider = "DP for double sub")
    public void testSubPositive(double a, double b, double c) {
        Assert.assertEquals(calc.sub(a, b), c);
    }

    @Test(dependsOnMethods = "testSubPositive",dataProvider = "DP for long sub")
    public void testSubPositiveLong(long a, long b, long c) {
        Assert.assertEquals(calc.sub(a, b), c);
    }


    @Test(dependsOnMethods = "testSubPositiveLong")
    @Parameters({"negativeVal1", "negativeVal2", "negativeVal3"})
    public void testSubNegative(long a, long b, long c) {
        Assert.assertNotEquals(calc.sub(a, b), c);
    }

    @DataProvider(name = "DP for double sub")
    private Object[][] dPDouble() {
        return new Object[][]{
                {3.5, 2.0, 1.5},
                {7.2, 3.0, 4.2}};
    }

    @DataProvider(name = "DP for long sub")
    private Object[][] dPLong() {
        return new Object[][]{
                {5, 1, 4},
                {7, 4, 3}};
    }

    @AfterClass
    public void tearDown() {
        System.out.println("AfterClass Sub");
    }

}
