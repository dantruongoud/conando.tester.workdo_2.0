package testcase.Setting.Gift_exchange.discount;

import org.openqa.selenium.WebDriver;
import page_locators.SignInPage;
import page_locators.Setting.Gift_exchange.discount.CreateDiscountPage;
import page_locators.Setting.Gift_exchange.store.CreateProductPage;
import setupbase.baseSetup;

public class CreatediscountTest {
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
            CreateDiscountPage discount = new CreateDiscountPage(driver);
            discount.navigation_discount();
            using.waitForPageLoaded();
            discount.click_create();
            Thread.sleep(1000);
            discount.click_save();
            System.out.println("Testcase: 1");
            System.out.println("=====================");
            String noti = using.messgaeError_tagline();
            if (noti != null) {
                System.out.println(noti);
                System.out.println("PASSED");
                discount.enterName("name");
                System.out.println("=====================");
                discount.click_save();
                System.out.println("Testcase: 2");
                System.out.println("=====================");
                noti = using.messgaeError_tagline();
                if (noti != null) {
                    System.out.println(noti);
                    System.out.println("PASSED");
                    using.uploadImage("//div[@class='field']//div[@class='control// is-expanded']", "xpath");
                    discount.click_save();
                    System.out.println("Testcase: 3");
                    System.out.println("=====================");
                    if (discount.verifyText()) {
                        System.out.println("Tạo mới thành công");
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
            } else {
                System.out.println("FAILED");
                System.out.println("=====================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
