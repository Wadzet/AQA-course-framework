package aqa_course.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateUserPO {
    private WebDriver driver;

    private By usernameField = By.name("username");
    private By realNameField = By.name("realname");
    private By emailField = By.name("email");
    private By accessLevelDropdown = By.name("access_level");
    private By createUserButton = By.xpath("//input[@value='Create User']");

    public CreateUserPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterRealName(String realName) {
        driver.findElement(realNameField).sendKeys(realName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void selectAccessLevel(String level) {
        driver.findElement(accessLevelDropdown).sendKeys(level);
    }

    public void clickCreateUser() {
        driver.findElement(createUserButton).click();
    }
}
