package aqa_course.ui;

import aqa_course.bo.LoginBO;
import aqa_course.driver.DriverPool;
import aqa_course.util.PropertyUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest {
    @Test
    public void testValidLogin() {
        String username = PropertyUtil.getProperty("username");
        String password = PropertyUtil.getProperty("password");

        LoginBO loginBO = new LoginBO();
        loginBO.performLogin(username, password);

        assertTrue(DriverPool.getDriver().getCurrentUrl().contains("my_view_page.php"),
                "User failed to login with valid credentials!");
    }

    @AfterMethod
    public void tearDown() {
        DriverPool.quitDriver();
    }
}
