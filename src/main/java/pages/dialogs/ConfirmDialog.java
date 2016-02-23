package pages.dialogs;

import org.openqa.selenium.WebElement;

/**
 * Created by Archie on 22.02.2016.
 */
public class ConfirmDialog extends BaseDialog<ConfirmDialog> {
    public WebElement getConfirmActionButton()
    {
        return waitForElementBySelector("div.pr-save");
    }
}
