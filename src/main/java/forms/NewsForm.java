package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class NewsForm extends Form {

    private final IButton userProfile = getElementFactory().getButton(By.xpath("//a[@id = 'top_profile_link']"),"Users Id");
    private final IButton myPage = getElementFactory().getButton(By.xpath("//li[@id = 'l_pr']"),"Button My Profile");

    public NewsForm() {
        super(By.id("post_field"), "News page");
    }

    public String getUsersId() {
        return userProfile.getAttribute("href");
    }

    public void goToMyPage() {
        myPage.click();
    }
}
