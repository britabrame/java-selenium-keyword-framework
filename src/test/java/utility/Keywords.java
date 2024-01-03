package utility;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * This class contains methods needed to issue commands to Selenium WebDriver.
 * Each of the private methods
 * corresponds to a keyword that can be used in the test case excel sheet.
 */
public class Keywords {
    private static WebDriver driver;

    /** Method for keyword "openBrowser." */
    public void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();
    }

    /** Method for keyword "closeBrowser." */
    public void closeBrowser() {
        synchronized (driver) {
            try {
                driver.wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        driver.close();
    }

    /** Method for keyword "gotTo." */
    public void goTo(String url) {
        System.out.println(url);
        driver.get(url);
    }

    /** Method for keyword "click." */
    public void clickElement(String obj, String objectType) {
        synchronized (driver) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            switch (objectType.toLowerCase()) {
                case "xpath":
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj))).click();
                    break;
                case "id":
                    wait.until(ExpectedConditions.elementToBeClickable(By.id(obj))).click();
                    break;
                case "class":
                    wait.until(ExpectedConditions.elementToBeClickable(By.className(obj))).click();
                    break;
                default:
                    System.out.println("Unable to click element: " + obj);
                    break;
            }
        }
    }

    /** Method for keyword "input." */
    public void input(String obj, String objectType, String data) {

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

    public void expectVisible(String obj, String objectType) {
        WebElement el;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String failureMessage = "Element was expected to be visible, but was not.";
        synchronized (driver) {
            switch (objectType.toLowerCase()) {
                case "xpath":
                    el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj)));
                    Assert.assertTrue(el.isDisplayed(), failureMessage);
                    break;
                case "id":
                    el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(obj)));
                    Assert.assertTrue(el.isDisplayed(), failureMessage);
                    break;

                case "class":
                    el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(obj)));
                    Assert.assertTrue(el.isDisplayed(), failureMessage);
                    break;
                default:
                    System.out.println("Todo error/failure handling");
                    break;
            }
        }
    }

}
