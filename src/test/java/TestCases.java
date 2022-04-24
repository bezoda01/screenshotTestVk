import aquality.selenium.browser.AqualityServices;
import forms.AuthenticationForm;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases {
    @Test
    public void test() {
        AqualityServices.getBrowser().goTo("https://vk.com/");
        Logger.getLogger().info("Open authentication page");
        AuthenticationForm authenticationForm = new AuthenticationForm();
        Assert.assertTrue(authenticationForm.state().waitForDisplayed(), "Page was not open");
        authenticationForm.clickToEntire();
        Logger.getLogger().info("Open entire page");
        BrowserUtils.getScreenShot();
        AqualityServices.getBrowser().quit();
    }
}
