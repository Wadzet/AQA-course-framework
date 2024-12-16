package aqa_course.ui;

import aqa_course.bo.CreateUserBO;
import aqa_course.bo.LoginBO;
import aqa_course.driver.DriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateUserTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverPool.getDriver();
    }

    @Test
    public void testCreateUser() {
        driver.get("http://localhost/login_page.php");

        LoginBO loginBO = new LoginBO(driver);
        loginBO.performLogin("administrator", "root");

        driver.get("http://localhost/manage_user_create_page.php");

        CreateUserBO createUserBO = new CreateUserBO(driver);
        createUserBO.createNewUser("reporter123", "Rep Usr", "reporter123@gmail.com", "reporter");

        Assert.assertTrue(driver.getCurrentUrl().contains("manage_user_page.php"),
                "User creation failed! The URL does not contain 'manage_user_page.php'.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
