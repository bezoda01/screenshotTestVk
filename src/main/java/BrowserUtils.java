import aquality.selenium.browser.AqualityServices;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class BrowserUtils {

    public static void getScreenShot() {
        TakesScreenshot scrShot =((TakesScreenshot) AqualityServices.getBrowser().getDriver());
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File dest = new File("src/main/resources/test.png");
        try {
            FileUtils.copyFile(SrcFile, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
