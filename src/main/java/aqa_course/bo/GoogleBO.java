package aqa_course.bo;

import aqa_course.po.GoogleSearchPO;

import static aqa_course.driver.DriverPool.getDriver;

public class GoogleBO {
    GoogleSearchPO googleSearchPO = new GoogleSearchPO();
    public GoogleBO search(String query) {
        getDriver().get("https://www.google.com/");
        googleSearchPO.search(query);
        return this;
    }

    public void checkResults() {
    }
}
