package aqa_course.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static aqa_course.driver.DriverPool.getDriver;

public class GoogleSearchPO {
    @FindBy(xpath = "//input[@name='q']")
    WebElement searchBox;

    public GoogleSearchPO() {
        PageFactory.initElements(getDriver(), this);
    }

    public void search(String query) {
        searchBox.sendKeys(query);
    }
}
