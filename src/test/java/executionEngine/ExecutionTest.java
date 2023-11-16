package executionEngine;
import excelUtility.ReadExcelSheet;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExecutionTest {

    /** Main method calls the ReadExcelSheet.executeTests() method. */
    @Test(groups= {"main"})
    public void runTests() throws IOException, InterruptedException {
        ReadExcelSheet res = new ReadExcelSheet();
        res.executeTests();
//        WebDriver driver;
////        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://google.com");
    }



}
