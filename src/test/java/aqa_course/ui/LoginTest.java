package aqa_course.ui;

import aqa_course.bo.LoginBO;
import aqa_course.driver.DriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginBO loginBO;

    @BeforeClass
    public void setUp() {
        driver = DriverPool.getDriver();
        driver.get("http://localhost/login_page.php");
        loginBO = new LoginBO(driver);
    }

    @Test
    public void testValidLogin() {
        loginBO.performLogin("administrator", "root");
    }

    @AfterClass
    public void tearDown() {
        DriverPool.quitDriver();
    }
}
