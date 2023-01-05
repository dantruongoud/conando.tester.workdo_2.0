package testcase.Setting.OKRs_CFRsTest;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.OKRs_CFRsPage.RaisePage;
import page_locators.Setting.OKRs_CFRsPage.cyclePage;
import setupbase.baseSetup;

public class RaiseTest {
    int testcase;
    String name;

    public RaiseTest(int testcase, String name) {
        this.testcase = testcase;
        this.name = name;
    }

    public static void main(String[] args) {
        try {
            RaiseTest[] data_test = {
                    new RaiseTest(1, ""),
                    new RaiseTest(2, "A"),
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            cyclePage cycle = new cyclePage(driver);
            RaisePage raise = new RaisePage(driver);

            using.login();
            using.navigation();
            cycle.navigation_OKRs_CFRs();
            using.waitForPageLoaded();

            raise.navigatoRaise();
            Thread.sleep(1000);
            raise.click_create();

            if (using.verifyTitle("Cấu hình loại phiếu góp ý")) {
                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("=========================");
                    System.out.println("Testcase: " + data_test[i].testcase);
                    raise.createRaise(data_test[i].name);
                    Thread.sleep(1000);
                    String noti = using.messgaeError_tagline();
                    switch (noti) {
                        case "Bạn cần nhập tên loại phiếu góp ý !":
                            using.passed();
                            break;
                        default:
                            if (raise.verifyText()) {
                                System.out.println("Tạo mới thành công");
                                using.passed();
                            } else {
                                using.failed();
                            }
                            break;
                    }
                }
            } else {
                using.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
