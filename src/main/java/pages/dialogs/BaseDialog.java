package pages.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import pages.BaseSeleniumHelper;

import java.util.List;

/**
 * Created by Archie on 22.02.2016.
 */
public abstract class BaseDialog<dialogType> extends BaseSeleniumHelper
{
    protected WebElement baseElement;

    public dialogType attachToDialog(WebElement baseElement)
    {
        this.baseElement = baseElement;
        return (dialogType) this;
    }

    public WebElement waitForElementBySelector(final String selector)
    {
        return getWaiter().until((ExpectedCondition<WebElement>) webDriver -> baseElement.findElement(By.cssSelector(selector)));
    }

    public List<WebElement> waitForElementsBySelector(final String selector)
    {
        return getWaiter().until((ExpectedCondition<List<WebElement>>) webDriver -> baseElement.findElements(By.cssSelector(selector)));
    }
}
