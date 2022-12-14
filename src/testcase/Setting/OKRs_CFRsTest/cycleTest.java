package testcase.Setting.OKRs_CFRsTest;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.OKRs_CFRsPage.cyclePage;
import setupbase.baseSetup;

public class cycleTest {
    int testcase;
    String cycleName;

    public cycleTest(int testcase, String cycleName) {
        this.testcase = testcase;
        this.cycleName = cycleName;
    }

    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            using.login();
            using.navigation();
            cyclePage cycle = new cyclePage(driver);
            cycle.navigation_OKRs_CFRs();
            Thread.sleep(1000);
            if (cycle.verifytitle()) {
                cycle.click_create();
                cycleTest[] data_test = {
                        new cycleTest(1, ""),
                        new cycleTest(2, "Cycle")
                };
                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("=========================");
                    System.out.println("Testcase: " + data_test[i].testcase);
                    cycle.create_cycle(data_test[i].cycleName);
                    Thread.sleep(1000);
                    String noti = using.messgaeError_tagline();
                    switch (noti) {
                        case "Nhập các trường bắt buộc (*)":
                            cycle.print();
                            break;
                        case "Ngày bắt đầu không thể lớn hơn ngày kết thúc !":
                            cycle.print();
                            break;
                        default:
                            if (cycle.verifycyclenew()) {
                                System.out.println("Tạo mới thành công");
                                using.passed();
                            } else {
                                using.failed();
                            }
                            break;
                    }
                    Thread.sleep(1000);
                }
            } else {
                using.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
