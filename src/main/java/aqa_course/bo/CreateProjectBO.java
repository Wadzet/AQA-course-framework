package aqa_course.bo;

import aqa_course.po.CreateProjectPO;
import org.openqa.selenium.WebDriver;

public class CreateProjectBO {
    private final CreateProjectPO createProjectPO;

    public CreateProjectBO(WebDriver driver) {
        this.createProjectPO = new CreateProjectPO(driver);
    }

    public void createProject(String projectName, String description) {
        createProjectPO.clickCreateNewProject();
        createProjectPO.enterProjectName(projectName);
        createProjectPO.enterProjectDescription(description);
        createProjectPO.clickSubmit();
    }
}
