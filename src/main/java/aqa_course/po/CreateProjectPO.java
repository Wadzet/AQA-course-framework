package aqa_course.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProjectPO {
    private WebDriver driver;

    @FindBy(xpath = "//button[text()='Створити новий проєкт']")
    private WebElement createNewProjectButton;

    @FindBy(id = "project-name")
    private WebElement projectNameField;

    @FindBy(id = "project-description")
    private WebElement projectDescriptionField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    public CreateProjectPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateNewProject() {
        createNewProjectButton.click();
    }

    public void enterProjectName(String projectName) {
        projectNameField.sendKeys(projectName);
    }

    public void enterProjectDescription(String description) {
        projectDescriptionField.sendKeys(description);
    }

    public void clickSubmit() {
        submitButton.click();
    }
}
