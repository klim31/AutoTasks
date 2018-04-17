package epam.tat.module4.tests;

import epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Klim_Starykau on 4/11/2018.
 */
public class SubTest {
    private Calculator calc;

    @BeforeGroups
    public void setUp() {
        calc = new Calculator();
        System.out.println("BeforeClass Sub");
    }
        @Test(dataProvider = "DP for double sub")
        public void testSubPositive(double a,double b,double c){
            Assert.assertEquals(calc.sub(a, b),c);
        }

        @Test(dataProvider = "DP for long sub")
        public void testSubPositive(long a,long b,long c){
            Assert.assertEquals(calc.sub(a, b),c);
        }

        @Parameters({"negativeVal1","negativeVal2","negativeVal3"})
        @Test
        public void testSubNegative(long a,long b,long c){
            Assert.assertNotEquals(calc.sub(a, b),c);
        }

    @DataProvider(name = "DP for double sub")
    private Object[][] dPDouble(){
        return new Object[][]{
                {3.5,2.0,1.5},
                {7.2,3.0,4.2}};
    }
    @DataProvider(name = "DP for long sub")
    private Object[][] dPLong(){
        return new Object[][]{
                {5L,1L,4L},
                {7L,4L,3L}};
    }

    @AfterClass
    public void tearDown(){
        System.out.println("AfterClass Sub");
    }

}
