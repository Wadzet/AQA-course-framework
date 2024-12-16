package aqa_course.bo;

import aqa_course.po.CreateUserPO;
import org.openqa.selenium.WebDriver;

public class CreateUserBO {
    private CreateUserPO createUserPO;

    public CreateUserBO(WebDriver driver) {
        this.createUserPO = new CreateUserPO(driver);
    }

    public void createNewUser(String username, String realName, String email, String accessLevel) {
        createUserPO.enterUsername(username);
        createUserPO.enterRealName(realName);
        createUserPO.enterEmail(email);
        createUserPO.selectAccessLevel(accessLevel);
        createUserPO.clickCreateUser();
    }
}
