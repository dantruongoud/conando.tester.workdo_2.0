package testcase.Setting.OKRs_CFRsTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.OKRs_CFRsPage.CreateCriteriaPage;
import page_locators.Setting.OKRs_CFRsPage.cyclePage;
import page_locators.Setting.OKRs_CFRsPage.deleteCriteriaPage;
import setupbase.baseSetup;

public class deleteCriteriaTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            using.login();
            using.navigation();
            cyclePage cycle = new cyclePage(driver);
            cycle.navigation_OKRs_CFRs();
            CreateCriteriaPage criteria = new CreateCriteriaPage(driver);
            criteria.navigation_criteria();
            deleteCriteriaPage delete = new deleteCriteriaPage(driver);
            delete.click_delete();
            Thread.sleep(1000);
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            System.out.println("=========================");
            alert.accept();
            System.out.println("Xóa thành công");
            System.out.println("PASSED");
            System.out.println("=========================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
