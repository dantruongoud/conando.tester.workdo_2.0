package testcase.Setting.Educate;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.Educate.CreateCategoryPage;
import page_locators.Setting.Educate.edit_del_CategoryPage;
import setupbase.baseSetup;

public class editCategoryTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            using.login();
            using.navigation();
            CreateCategoryPage create = new CreateCategoryPage(driver);
            create.navigation_educate();
            using.waitForPageLoaded();
            edit_del_CategoryPage edit = new edit_del_CategoryPage(driver);
            edit.enterSearch("AAAA");
            edit.click_search();
            using.waitForPageLoaded();
            edit.click_edit();
            Thread.sleep(1000);
            edit.cleartxt();
            create.click_save();
            System.out.println("=====================");
            System.out.println("Testcase: 1");
            String noti = using.messgaeError_tagline();
            if (noti != null) {
                System.out.println(noti);
                System.out.println("PASSED");
                System.out.println("=====================");
                create.enterName("A");
                create.click_save();
                System.out.println("=====================");
                System.out.println("Testcase: 2");
                if (edit.verifyText()) {
                    System.out.println("Cập nhật thành công");
                    System.out.println("PASSED");
                    System.out.println("=====================");
                } else {
                    System.out.println("FAILED");
                    System.out.println("=====================");
                }
            } else {
                System.out.println("FAILED");
                System.out.println("=====================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
