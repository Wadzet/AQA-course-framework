package aqa_course.bo;

import aqa_course.po.LoginPO;
import aqa_course.po.LoginPasswordPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginBO {
    private LoginPO loginPO;
    private LoginPasswordPO loginPasswordPO;
    private WebDriverWait wait;

    public LoginBO(WebDriver driver) {
        loginPO = new LoginPO(driver);
        loginPasswordPO = new LoginPasswordPO(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void performLogin(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(loginPO.getUsernameInput()));
        loginPO.getUsernameInput().sendKeys(username);

        wait.until(ExpectedConditions.elementToBeClickable(loginPO.getLoginButton()));
        loginPO.getLoginButton().click();

        wait.until(ExpectedConditions.visibilityOf(loginPasswordPO.getPasswordInput()));
        loginPasswordPO.getPasswordInput().sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(loginPasswordPO.getLoginButton()));
        loginPasswordPO.getLoginButton().click();
    }
}
