package testcase.Setting.OKRs_CFRsTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.OKRs_CFRsPage.RaisePage;
import page_locators.Setting.OKRs_CFRsPage.cyclePage;
import page_locators.Setting.OKRs_CFRsPage.deleteRaisePage;
import setupbase.baseSetup;

public class deleteRaiseTest {
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
            deleteRaisePage del = new deleteRaisePage(driver);
            del.click_del();
            Thread.sleep(1000);
            Alert alert = driver.switchTo().alert();
            System.out.println("=========================");
            System.out.println(alert.getText().strip());
            System.out.println("PASSED");
            System.out.println("Xóa thành công");
            System.out.println("=========================");
            alert.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
