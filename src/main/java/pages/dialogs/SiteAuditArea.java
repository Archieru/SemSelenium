package pages.dialogs;

import org.openqa.selenium.WebElement;

/**
 * Created by Archie on 22.02.2016.
 */
public class SiteAuditArea extends BaseDialog<SiteAuditArea>
{
    public WebElement getSetupAuditButton()
    {
        return waitForElementBySelector("button.projects-tool-btn-green.js-trigger-audit-wizard");
    }

    public WebElement getAuditProgressElement()
    {
        return waitForElementBySelector("div.projects-tool-info-crawling div.projects-tool-info-crawling-progress-fill");
    }

    public int getAuditProgress()
    {
        String elementStyle = getAuditProgressElement().getAttribute("style");
        try {
            return Integer.parseInt(elementStyle.split(":")[1].split("%")[0]);
        } catch (NumberFormatException e){
            throw new NumberFormatException(elementStyle);
        }
    }

    public WebElement getAuditResultMainElement()
    {
        return waitForElementBySelector("div.sa-tool-stats-overall");
    }
}
