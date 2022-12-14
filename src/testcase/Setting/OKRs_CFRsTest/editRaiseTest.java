package testcase.Setting.OKRs_CFRsTest;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.OKRs_CFRsPage.RaisePage;
import page_locators.Setting.OKRs_CFRsPage.cyclePage;
import page_locators.Setting.OKRs_CFRsPage.editRaisePage;
import setupbase.baseSetup;

public class editRaiseTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            using.login();
            using.navigation();
            cyclePage cycle = new cyclePage(driver);
            cycle.navigation_OKRs_CFRs();
            using.waitForPageLoaded();
            RaisePage raise = new RaisePage(driver);
            raise.navigatoRaise();
            Thread.sleep(1000);
            editRaisePage edit = new editRaisePage(driver);
            edit.click_edit();
            Thread.sleep(1000);
            edit.cleartxt();
            raise.save_btn.click();
            String noti = using.messgaeError_tagline();
            System.out.println("=========================");
            System.out.println("Testcase: 1");
            if (noti != null) {
                System.out.println(noti);
                using.passed();
                edit.sendkeytxt();
                raise.save_btn.click();
                System.out.println("=========================");
                System.out.println("Testcase: 2");
                Thread.sleep(1000);
                if (raise.verifyText()) {
                    System.out.println("Cập nhật thành công");
                    using.passed();
                } else {
                    using.failed();
                }
            } else {
                using.failed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
