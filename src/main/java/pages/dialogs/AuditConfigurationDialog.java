package pages.dialogs;

import org.openqa.selenium.WebElement;

/**
 * Created by Archie on 22.02.2016.
 */
public class AuditConfigurationDialog extends BaseDialog<AuditConfigurationDialog>
{
    public WebElement getSendAuditEmailCheckbox()
    {
        return waitForElementBySelector("label.sa-wizard-content-buttons-notify>input.js-checkbox");
    }

    public WebElement getStartAuditButton()
    {
        return waitForElementBySelector("button.btn.btn-with-icon.js-collect>span.icon");
    }
}
