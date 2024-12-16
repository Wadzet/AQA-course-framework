package aqa_course.ui;

import aqa_course.bo.CreateProjectBO;
import aqa_course.bo.LoginBO;
import aqa_course.driver.DriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateProjectTest {
    private WebDriver driver;
    private LoginBO loginBO;
    private CreateProjectBO createProjectBO;

    @BeforeClass
    public void setUp() {
        driver = DriverPool.getDriver();
        driver.get("http://localhost/login_page.php");

        loginBO = new LoginBO(driver);
        loginBO.performLogin("administrator", "root");

        String expectedUrl = "http://localhost/manage_proj_page.php";
        Assert.assertNotEquals(driver.getCurrentUrl(), "http://localhost/login_page.php", "Login failed!");

        createProjectBO = new CreateProjectBO(driver);
    }

    @Test
    public void testCreateProject() {
        driver.get("http://localhost/manage_proj_page.php");

        String projectName = "NewTestProject";
        String projectDescription = "This is a test project";
        createProjectBO.createProject(projectName, projectDescription);

        Assert.assertTrue(driver.getPageSource().contains(projectName), "Project creation failed!");
    }

    @AfterClass
    public void tearDown() {
        DriverPool.quitDriver();
    }
}
