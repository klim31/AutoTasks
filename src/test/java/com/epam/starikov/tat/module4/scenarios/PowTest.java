package com.epam.starikov.tat.module4.scenarios;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Klim_Starykau on 4/24/2018.
 */
public class PowTest {
    private Calculator calc;

    @BeforeTest
    public void setUp() {
        calc = new Calculator();
        System.out.println("BeforeClass Pow");
    }


    @Test(dataProvider = "DP for Pow")
    public void testPow(double a, double b, double c) {
        Assert.assertEquals(calc.pow(a,b), c);
    }


    @Test
    @Parameters({"negativeVal1","negativeVal2", "negativeVal3"})
    public void testPowNegative(double a, double b, double c) {
        Assert.assertNotEquals(calc.pow(a,b),c);
    }

    @DataProvider(name = "DP for Pow")
    private Object[][] dPLong() {
        return new Object[][]{
                {2.0, 2.0, 4.0},
                {1.0, 1.0, 1.0}};
    }

    @AfterClass
    public void tearDown() {
        System.out.println("AfterClass Pow");
    }
}

