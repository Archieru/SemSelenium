package pages;

import org.openqa.selenium.WebElement;
import pages.dialogs.*;

/**
 * Created by Archie on 20.02.2016.
 */
public class ProjectsPage extends BaseTestPage
{
    @Override
    protected String getPageUrl() {
        return "http://www.semrush.com/projects";
    }

    public WebElement getLoginButton()
    {
        return waitForButtonBySelector("button.js-authentication-login");
    }

    public LoginDialog getLoginDialog()
    {
        return new LoginDialog().attachToDialog(waitForElementBySelector("div.auth-popup"));
    }

    public WebElement getAddProjectButton()
    {
        return waitForButtonBySelector("div.no-projects-page-content button.projects-tool-btn-green");
    }

    public NewProjectDialog getProjectCreationDialog()
    {
        return new NewProjectDialog().attachToDialog(waitForElementBySelector("div.pr-projectCreate"));
    }

    public SiteAuditArea getSiteAuditArea()
    {
        return new SiteAuditArea().attachToDialog(FilterElementByCustomParameter(
                waitForElementsBySelector("div.pr-cell"), "data-scroll", "siteaudit"));
    }

    public AuditConfigurationDialog getAuditConfigurationDialog()
    {
        return new AuditConfigurationDialog().attachToDialog(waitForElementBySelector("div.sa-wizard"));
    }

    public WebElement getDeleteProjectButton()
    {
        return waitForButtonBySelector("div.sa-project-header-actions>a.sa-icn-trash");
    }

    public ConfirmDialog getConfirmDialog()
    {
        return new ConfirmDialog().attachToDialog(waitForElementBySelector("div.pr-confirm"));
    }

    public void waitPageUpdate()
    {
        WaitForLoadingElementSelector("div.projects-loader");
    }
}
