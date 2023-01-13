package testcase.Setting.Gift_exchange.store;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.Gift_exchange.store.CreateProductPage;
import setupbase.baseSetup;

public class CreateProductTest {
    int testcase;
    String name, number;

    public CreateProductTest(int testcase, String name, String number) {
        this.testcase = testcase;
        this.name = name;
        this.number = number;
    }

    public static void main(String[] args) {
        try {
            CreateProductTest[] data_test = {
                    new CreateProductTest(1, "", "0"),
                    new CreateProductTest(2, "name", "0"),
                    new CreateProductTest(3, "name", "1"),
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            CreateProductPage create = new CreateProductPage(driver);

            using.login();

            using.navigation();

            create.navigation_exchange();
            using.waitForPageLoaded();

            create.click_create();

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
                            System.out.println("Tạo mới thành công");
                            using.passed();
                        } else {
                            using.failed();
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
