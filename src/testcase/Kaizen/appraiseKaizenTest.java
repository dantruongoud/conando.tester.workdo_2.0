package testcase.Kaizen;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Kaizen.CreateKaizenPage;
import page_locators.Kaizen.appraiseKaizenPage;
import setupbase.baseSetup;

public class appraiseKaizenTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            using.login();
            CreateKaizenPage kaizen = new CreateKaizenPage(driver);
            kaizen.navigation_Kaizen();
            using.waitForPageLoaded();
            appraiseKaizenPage appraise = new appraiseKaizenPage(driver);
            appraise.chose_Kaizen("Tôi cần góp ý");
            using.waitForPageLoaded();
            if (using.verifyTitle(using.titlePageDetailsKaizen)) {
                appraise.chose_menu();
                Thread.sleep(1000);
                appraise.chose_submenu();
                Thread.sleep(1000);
                appraise.chose_criteria();
                Thread.sleep(1000);
                appraise.click_save();
                System.out.println("Đánh giá thành công");
                System.out.println("======================");
                appraise.verify_appraise();
            } else {
                using.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
