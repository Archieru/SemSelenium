package tests;

import entities.Project;
import entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import steps.ProjectSteps;

/**
 * Created by Archie on 20.02.2016.
 */
public class UiProjectRunTest extends ProjectSteps {
    protected User archie = new User("archie-ru@ya.ru", "SEMrush2016");
    protected Project a42project = new Project("a42", "a.42bar.ru");

    @Before
    public void BeforeTest()
    {
        DriverInitialize();
        SwitchPageToProjects();
        DoLogin(archie);
        try {
            deleteProject();
        } catch (Exception e) {}
    }

    @After
    public void AfterTest()
    {
        DriverCleanup();
    }


    @Test
    public void ShouldAuditSite()
    {
        createProject(a42project);
        startAuditForProject();
        String auditResultText = getAuditResult().getText();
        deleteProject();
        Assert.assertTrue(auditResultText + " does not contain 8", auditResultText.contains("8"));
    }
}
