package testcase.Setting.Gift_exchange.store;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.Gift_exchange.store.CreateProductPage;
import page_locators.Setting.Gift_exchange.store.deleteProductPage;
import setupbase.baseSetup;

public class deleteProductTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            using.login();
            Thread.sleep(1000);
            using.navigation();
            CreateProductPage create = new CreateProductPage(driver);
            create.navigation_exchange();
            using.waitForPageLoaded();
            deleteProductPage del = new deleteProductPage(driver);
            del.click_delete();
            Thread.sleep(1000);
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            System.out.println("=======================");
            alert.accept();
            System.out.println("Xóa thành công");
            System.out.println("PASSED");
            System.out.println("=======================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
