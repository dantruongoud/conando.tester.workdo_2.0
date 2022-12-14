package testcase.Setting.Educate;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.Educate.CreateCategoryPage;
import setupbase.baseSetup;

public class CreateCategoryTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            CreateCategoryPage create = new CreateCategoryPage(driver);

            using.login();

            using.navigation();
            create.navigation_educate();
            using.waitForPageLoaded();

            if (using.verifyTitle("Quản lý danh mục đào tạo")) {

                create.click_create();

                Thread.sleep(1000);
                System.out.println("========================");
                System.out.println("Testcase: 1");
                create.click_save();
                String noti = using.messgaeError_tagline();
                if (noti != null) {
                    System.out.println(noti);
                    using.passed();

                    create.enterName("AAAA");
                    using.uploadImage("//input[@type='file']", "xpath");

                    System.out.println("========================");
                    System.out.println("Testcase: 2");
                    create.click_save();
                    Thread.sleep(1000);

                    if (create.verifyText()) {
                        System.out.println("Tạo mới thành công");
                        using.passed();
                    } else {
                        using.failed();
                    }
                } else {
                    using.failed();
                }
            } else {
                using.error_titlePage();
            }
        } catch (

        Exception e) {
            e.printStackTrace();
        }
    }
}
