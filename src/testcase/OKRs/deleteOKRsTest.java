package testcase.OKRs;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.OKRs.CreateOKRsPage;
import page_locators.OKRs.deleteOKRsPage;
import page_locators.OKRs.editOKRsPage;
import setupbase.baseSetup;

public class deleteOKRsTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            using.login();
            CreateOKRsPage create = new CreateOKRsPage(driver);
            create.click_navigation_OKRs();
            Thread.sleep(1000);
            create.click_navigation_CreateOKRs();
            Thread.sleep(1000);
            create.click_navigation_CreatePage();
            Thread.sleep(1000);
            editOKRsPage edit = new editOKRsPage(driver);
            edit.chose_OKRsedit("OKRs QUY I");
            using.waitForPageLoaded();
            deleteOKRsPage delete = new deleteOKRsPage(driver);
            delete.click_delete();
            Thread.sleep(1000);
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            System.out.println("Xoá thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
