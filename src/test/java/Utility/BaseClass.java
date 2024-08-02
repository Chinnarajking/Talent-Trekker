package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    
	protected static WebDriver driver;

    // Simple constructor to initialize the WebDriver
    public BaseClass() {
    	if (driver == null) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    }

    public static void browserLaunch(String url) {
        driver.get(url);
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
    }
    

    

    
    

//	public static void ensureDriverInitialized() {
//        if (driver == null) {
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*");
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver(options);
//            driver.manage().window().maximize();
//       }
//    }
//
//    public static void browserLaunch(String url) {
//        ensureDriverInitialized();
//        driver.get(url);
//        System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.getTitle());
//    }

    public static void inputText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public static void btnClick(WebElement element) {
        element.click();
    }

    public static void enter(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    public void cleartext(WebElement element) {
        element.clear();
    }

    public static void getText(WebElement element) {
        System.out.println(element.getText());
    }

    public static void assertTextEquals(WebElement element, String expectedText) {
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText);
    }
    
    public void clickButtonUsingJS(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }
    
    public boolean assertElementValueUsingJS(WebElement element, String expectedValue) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String actualValue = (String) jsExecutor.executeScript("return arguments[0].value;", element);
        return expectedValue.equals(actualValue);
    }
}