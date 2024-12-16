package aqa_course.util;

import org.openqa.selenium.WebElement;

public class CustomElement {
    private final WebElement element;

    public CustomElement(WebElement element) {
        this.element = element;
    }

    public void sendKeys(String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void click() {
        element.click();
    }

    public String getText() {
        return element.getText();
    }
}
