package testcase.Setting.Gift_exchange.store;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.Gift_exchange.store.CreateProductPage;
import page_locators.Setting.Gift_exchange.store.editProductPage;
import setupbase.baseSetup;

public class editProductTest {
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
            editProductPage edit = new editProductPage(driver);
            edit.clickNameProduct();
            Thread.sleep(1000);
            create.clear();
            CreateProductTest[] data_test = {
                    new CreateProductTest(1, "", "0"),
                    new CreateProductTest(2, "name", "0"),
                    new CreateProductTest(3, "name", "1"),
            };
            for (int i = 0; i < data_test.length; i++) {
                System.out.println("=========================");
                System.out.println("Testcase: " + data_test[i].testcase);
                create.createProduct(data_test[i].name, data_test[i].number);
                Thread.sleep(1000);
                String noti = using.messgaeError_tagline();
                switch (noti) {
                    case "Nhập các trường bắt buộc (*)":
                        System.out.println(noti);
                        create.print();
                        break;
                    default:
                        if (create.verifyText()) {
                            System.out.println("Cập nhật thành công");
                            System.out.println("PASSED");
                            System.out.println("=========================");
                        } else {
                            System.out.println("FAILED");
                            System.out.println("=========================");
                        }
                        break;
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
