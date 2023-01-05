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
            cyclePage cycle = new cyclePage(driver);
            CreateCriteriaPage criteria = new CreateCriteriaPage(driver);
            deleteCriteriaPage delete = new deleteCriteriaPage(driver);

            using.login();
            using.navigation();
            cycle.navigation_OKRs_CFRs();
            criteria.navigation_criteria();
            delete.click_delete();
            Thread.sleep(1000);

            Alert alert = driver.switchTo().alert();

            System.out.println(alert.getText());
            System.out.println("=========================");
            alert.accept();
            System.out.println("Xóa thành công");
            using.passed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
