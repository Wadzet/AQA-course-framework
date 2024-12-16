package aqa_course.bo;

import aqa_course.po.LoginPO;

import static aqa_course.driver.DriverPool.getDriver;

public class LoginBO {
    private final LoginPO loginPO;

    public LoginBO() {
        this.loginPO = new LoginPO();
    }

    public void performLogin(String username, String password) {
        getDriver().get("http://localhost/login_page.php");
        loginPO.enterUsername(username);
        loginPO.enterPassword(password);
        loginPO.clickLogin();
    }
}
