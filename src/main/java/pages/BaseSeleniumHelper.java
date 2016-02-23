package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Archie on 22.02.2016.
 */
public class BaseSeleniumHelper
{
    private static WebDriver driver;
    private static WebDriverWait waiter;

    private WebDriver getDriver()
    {
        return driver;
    }

    protected WebDriverWait getWaiter()
    {
        return waiter;
    }

    protected void driverInitialize()
    {
        if (driver != null)
        {
            return;
        }
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        waiter = new WebDriverWait(driver, 10);
    }

    public void driverCleanup()
    {
        if (driver == null)
        {
            return;
        }
        driver.quit();
        waiter = null;
        driver = null;
    }

    protected void goToUrl(String url)
    {
        getDriver().navigate().to(url);
    }

    public WebElement FilterElementByCustomParameter(List<WebElement> collection, String paramName, String paramVal)
    {
        for (WebElement element : collection)
        {
            if (element.getAttribute(paramName).equals(paramVal)) return element;
        }
        throw new NoSuchElementException(paramName + "=" + paramVal + " in " + collection.size() + " elements");
    }
}