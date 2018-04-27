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
public class TgTest {
    private Calculator calc;

    @BeforeTest
    public void setUp() {
        calc = new Calculator();
        System.out.println("BeforeClass Tg");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("AfterClass Tg");
    }

    @Test
    @Parameters({"Value1","Value2"})
    public void testTg(double hypValue, double decimVal) throws Exception {
        Assert.assertEquals(calc.tg(hypValue),decimVal);
    }

}