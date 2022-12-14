package testcase.Setting.Educate;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.Educate.CreateCategoryPage;
import page_locators.Setting.Educate.CreateCertificationPage;
import setupbase.baseSetup;

public class CreateCertificationTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            CreateCategoryPage create = new CreateCategoryPage(driver);
            CreateCertificationPage create_certification = new CreateCertificationPage(driver);
            using.login();

            using.navigation();
            Thread.sleep(1000);
            create.navigation_educate();
            using.waitForPageLoaded();

            create_certification.navigation_certification();
            create_certification.click_create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
