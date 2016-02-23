package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public abstract class BaseTestPage extends BaseSeleniumHelper
{
    public BaseTestPage()
    {
        driverInitialize();
    }

    protected abstract String getPageUrl();

    public void loadPage()
    {
        goToUrl(getPageUrl());
    }

    public WebElement waitForElementBySelector(final String selector)
    {
        return getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
    }

    public List<WebElement> waitForElementsBySelector(final String selector)
    {
        return getWaiter().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector)));
    }

    public WebElement waitForButtonBySelector(String selector)
    {
        WebElement button = waitForElementBySelector(selector);
        getWaiter().until(ExpectedConditions.elementToBeClickable(button));
        return button;
    }

    public void WaitForLoadingElementSelector(String selector)
    {
        try {
            waitForElementBySelector(selector);
        } catch (Exception e) {}
        getWaiter().until(new ExpectedCondition<Boolean>()
        {
            public Boolean apply (WebDriver driver)
            {
                List<WebElement> AllElements = driver.findElements(By.cssSelector(selector));
                return AllElements.isEmpty() || AllElements.stream().allMatch(item -> !item.isDisplayed());
            }
        });
    }
}