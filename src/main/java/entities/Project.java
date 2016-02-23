package entities;

public class Project {
    private String projectName;
    private String projectUrl;

    public Project(String projectName, String projectUrl)
    {
        this.projectName = projectName;
        this.projectUrl = projectUrl;
    }

    public String getProjectName()
    {
        return this.projectName;
    }

    public String getProjectUrl()
    {
        return projectUrl;
    }
}
