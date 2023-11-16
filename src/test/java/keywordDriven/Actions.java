package keywordDriven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/** This class contains methods needed to issue commands to Selenium WebDriver. Each of the private methods
 * corresponds to a keyword that can be used in the test case excel sheet.*/
public class Actions {
    private static WebDriver driver;

    /** This method takes test step details and calls the appropriate action method for the given step.*/
    public void perform(String keyword, String obj, String objectType, String data, String desc) throws InterruptedException {
        switch(keyword.toLowerCase()) {
            case "openbrowser":
                openBrowser();
                break;
            case "goto":
                goTo(data);
                break;
            case "closebrowser":
                closeBrowser();
                break;
            case "click":
                clickElement(obj,objectType);
                break;
            case "input":
                input(obj,objectType,data);
                break;
            case "expectVisible":
                //todo
                break;
        }
     }

    /** Method for keyword "openBrowser." */
    private void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();
    }

    /** Method for keyword "closeBrowser." */
    private void closeBrowser() throws InterruptedException {
        driver.wait(10000);
        driver.quit();
    }

    /** Method for keyword "gotTo." */
    private void goTo(String url) {
        System.out.println(url);
        driver.get(url);
   }

    /** Method for keyword "click." */
    private void clickElement(String obj, String objectType) {

        switch (objectType.toLowerCase()) {
            case "xpath":
                driver.findElement(By.xpath(obj)).click();
                break;
            case "id":
                driver.findElement(By.id(obj)).click();
                break;
            case "class":
                driver.findElement(By.className(obj)).click();
                break;
            default:
                System.out.println("Unable to click element: " + obj);
                break;
        }
    }

    /** Method for keyword "input." */
    private void input(String obj, String objectType, String data) {

        switch (objectType.toLowerCase()) {
            case "xpath":
                driver.findElement(By.xpath(obj)).sendKeys(data);
                break;
            case "id":
                driver.findElement(By.id(obj)).sendKeys(data);
                break;
            case "class":
                driver.findElement(By.className(obj)).sendKeys(data);
                break;
            default:
                System.out.println("Unable to enter input for element: " + obj);
                break;
        }
    }

}
