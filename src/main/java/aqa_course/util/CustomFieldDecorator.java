package aqa_course.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;

public class CustomFieldDecorator extends DefaultFieldDecorator {

    public CustomFieldDecorator(org.openqa.selenium.support.pagefactory.ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        Object original = super.decorate(loader, field);

        if (original instanceof WebElement) {
            return new CustomElement((WebElement) original);
        }

        return original;
    }
}
