package testcase.Setting.Educate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.Educate.CreateCategoryPage;
import page_locators.Setting.Educate.edit_del_CategoryPage;
import setupbase.baseSetup;

public class deleteCategoryTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            CreateCategoryPage create = new CreateCategoryPage(driver);
            edit_del_CategoryPage edit = new edit_del_CategoryPage(driver);
            using.login();
            using.navigation();
            create.navigation_educate();
            using.waitForPageLoaded();
            edit.click_del();
            Thread.sleep(1000);
            
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            System.out.println("=====================");
            alert.accept();
            System.out.println("Xóa thành công");
            using.passed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
