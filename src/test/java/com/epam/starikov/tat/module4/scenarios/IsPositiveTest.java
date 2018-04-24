package com.epam.starikov.tat.module4.scenarios;

import com.epam.starikov.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Klim_Starykau on 4/13/2018.
 */
public class IsPositiveTest {
    private Calculator calc;

    @BeforeTest
    public void setUp() {
        calc = new Calculator();
        System.out.println("BeforeClass IsPositive");
    }


    @Test(dataProvider = "DP for long Positive")
    public void testIsPositive(long a, boolean b) {
        Assert.assertEquals(calc.isPositive(a), b);
    }


    @Test
    @Parameters({"negativeVal1", "negativeVal2"})
    public void testIsNegative(long a, boolean b) {
        Assert.assertNotEquals(calc.isPositive(a), b);
    }

    @DataProvider(name = "DP for long Positive")
    private Object[][] dPLong() {
        return new Object[][]{
                {1, true},
                {-7, false}};
    }

    @AfterClass
    public void tearDown() {
        System.out.println("AfterClass IsPositive");
    }
}
