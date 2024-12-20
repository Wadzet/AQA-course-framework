package aqa_course.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPO {
    private WebDriver driver;

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(xpath = "//*[@id='login-form']/fieldset/input[2]")
    private WebElement loginButton;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getUsernameInput() {
        return usernameInput;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
}
