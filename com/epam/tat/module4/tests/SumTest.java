package epam.tat.module4.tests;

import epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Klim_Starykau on 4/11/2018.
 */
public class SumTest {
    public Calculator calc;

    /*@BeforeGroups
    public void setUp() {
        calc = new Calculator();
        System.out.println("BeforeClass Sum");
    }*/


    @Test(dataProvider = "DP for double sum")
    public void testSumPositive(double a,double b,double c){
        Assert.assertEquals(calc.sum(a, b),c);
    }

   /* @Test(dataProvider = "DP for long sum")
    public void testSumPositive(long a,long b,long c){
        Assert.assertEquals(calc.sum(a, b),c);
    }

    @Parameters({"negativeVal1","negativeVal2","negativeVal3"})
    @Test
    public void testSumNegative(long a,long b,long c){
        Assert.assertNotEquals(calc.sum(a, b),c);
    }
*/
    @DataProvider(name = "DP for double sum")
    private Object[][] dPDouble(){
        return new Object[][]{
                {1.5,5.0,6.5},
                {7.2,8.0,15.2}};
    }
    @DataProvider(name = "DP for long sum")
    private Object[][] dPLong(){
        return new Object[][]{
                {1L,5L,6L},
                {7L,8L,15L}};
    }

    /*@AfterClass
    public void tearDown(){
        System.out.println("AfterClass Sum");
    }*/





}
