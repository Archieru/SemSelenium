package pages.dialogs;

import org.openqa.selenium.WebElement;

/**
 * Created by Archie on 22.02.2016.
 */
public class NewProjectDialog extends BaseDialog<NewProjectDialog>
{
    public WebElement getProjectDomainInput()
    {
        return waitForElementBySelector(".pr-projectCreate input.pr-domain");
    }

    public WebElement getProjectNameInput()
    {
        return FilterElementByCustomParameter(waitForElementsBySelector(".pr-projectCreate input"), "placeholder", "Project name");
    }

    public WebElement getSaveProjectButton()
    {
        return waitForElementBySelector("div.pr-save");
    }
}