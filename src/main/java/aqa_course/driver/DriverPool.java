package aqa_course.driver;

import aqa_course.util.PropertyUtil;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverPool {
    public static void main(String[] args) {
        getDriver().manage().window().maximize();
    }
    public static WebDriver getDriver() {
        String browser = PropertyUtil.getProperty("browser");
        System.out.println(browser);
        WebDriver driver = null;
        switch (browser) {
            case "chrome": {
                ChromeDriverManager.getInstance().setup();
                driver=new ChromeDriver();
                break;
            }
            case "safari": {
                driver=new SafariDriver();
                break;
            }
        }
        return driver;
    }
}
