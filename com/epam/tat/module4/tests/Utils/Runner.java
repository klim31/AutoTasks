package epam.tat.module4.tests.Utils;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Klim_Starykau on 4/12/2018.
 */
public class Runner {
    public static void main(String[] args)
    {
        TestNG testng = new TestNG();
        TestListenerAdapter adapter = new TestListenerAdapter();
        XmlSuite suite = new XmlSuite();
        suite.setName("CalculatorTests");
        List<String> files = new ArrayList<>();
        files.addAll(new ArrayList<String>(){{add("./com/epam.tat.module4/Resources/CalculatorTests.xml");
        }});
        suite.setSuiteFiles(files);

        List<XmlSuite>suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        testng.setXmlSuites(suites);
        testng.addListener(new Listener());
        testng.run();


    }

}
