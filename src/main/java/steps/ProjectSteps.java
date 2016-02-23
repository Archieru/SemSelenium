package steps;

import entities.Project;
import entities.User;
import org.openqa.selenium.WebElement;
import pages.ProjectsPage;
import pages.dialogs.AuditConfigurationDialog;
import pages.dialogs.LoginDialog;
import pages.dialogs.NewProjectDialog;

/**
 * Created by Archie on 20.02.2016.
 */
public class ProjectSteps {
    protected ProjectsPage page;

    public void DriverInitialize()
    {
        page = new ProjectsPage();
    }

    public void DriverCleanup()
    {
        page.driverCleanup();
    };

    public void SwitchPageToProjects()
    {
        page.loadPage();
    }

    public void DoLogin(User userToLogin)
    {
        page.getLoginButton().click();
        LoginDialog loginDialog = page.getLoginDialog();
        loginDialog.getLoginFormEmailInput().sendKeys(userToLogin.getUserName());
        loginDialog.getLoginFormPasswordInput().sendKeys(userToLogin.getPassword());
        loginDialog.getSignInButton().click();
        page.waitPageUpdate();
    }

    public void createProject(Project projectToCreate)
    {
        page.getAddProjectButton().click();
        NewProjectDialog newProjectDialog = page.getProjectCreationDialog();
        newProjectDialog.getProjectDomainInput().sendKeys(projectToCreate.getProjectUrl());
        newProjectDialog.getProjectNameInput().sendKeys(projectToCreate.getProjectName());
        newProjectDialog.getSaveProjectButton().click();
        page.waitPageUpdate();
    }

    public void startAuditForProject()
    {
        page.getSiteAuditArea().getSetupAuditButton().click();
        AuditConfigurationDialog auditConfigurationDialog = page.getAuditConfigurationDialog();
        auditConfigurationDialog.getSendAuditEmailCheckbox().click();
        auditConfigurationDialog.getStartAuditButton().click();
        page.waitPageUpdate();
    }

    public WebElement getAuditResult()
    {
        return page.getSiteAuditArea().getAuditResultMainElement();
    }

    public void deleteProject()
    {
        page.loadPage();
        page.getDeleteProjectButton().click();
        page.getConfirmDialog().getConfirmActionButton().click();
        page.waitPageUpdate();
    }
}
