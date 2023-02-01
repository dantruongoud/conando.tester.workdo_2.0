package testcase.Setting.OKRs_CFRsTest;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.OKRs_CFRsPage.cyclePage;
import setupbase.baseSetup;

public class cycleTest {
    int testcase;
    String cycleName, dayStar;

    public cycleTest(int testcase, String cycleName, String dayStar) {
        this.testcase = testcase;
        this.cycleName = cycleName;
        this.dayStar = dayStar;
    }

    public static void main(String[] args) {
        try {
            cycleTest[] data_test = {
                    new cycleTest(1, "", "01/02/2023"),
                    new cycleTest(2, "Cycle", "20/02/2023"),
                    new cycleTest(3, "Cycle", "01/02/2023")
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            cyclePage cycle = new cyclePage(driver);

            using.login();
            using.navigation();
            cycle.navigation_OKRs_CFRs();
            Thread.sleep(1000);

            if (cycle.verifytitle()) {

                cycle.create_btn.click();

                for (int i = 0; i < data_test.length; i++) {

                    cycle.cleartxt();
                    System.out.println("=========================");

                    System.out.println("Testcase: " + data_test[i].testcase);
                    cycle.create_cycle(data_test[i].cycleName, data_test[i].dayStar);
                    Thread.sleep(1000);

                    String noti = using.messgaeError_tagline();

                    switch (noti) {
                        case "Nhập các trường bắt buộc (*)":
                            using.passed();
                            break;
                        case "Ngày bắt đầu không thể lớn hơn ngày kết thúc !":
                            using.passed();
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
