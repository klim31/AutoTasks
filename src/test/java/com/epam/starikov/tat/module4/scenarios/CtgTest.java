package com.epam.starikov.tat.module4.scenarios;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Klim_Starykau on 4/24/2018.
 */
public class CtgTest {
    private Calculator calc;

    @BeforeTest
    public void setUp() {
        calc = new Calculator();
        System.out.println("BeforeClass Ctg");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("AfterClass Ctg");
    }

    @Test
    @Parameters({"Value1","Value2"})
    public void testCtg(double hypValue, double decimVal) throws Exception {
        Assert.assertEquals(calc.ctg(hypValue),decimVal);
    }
}
