package testcase.Setting.OKRs_CFRsTest;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.OKRs_CFRsPage.SupplyStarPage;
import page_locators.Setting.OKRs_CFRsPage.cyclePage;
import setupbase.baseSetup;

public class SupplyStarTest {
    int testcase;
    String number;

    public SupplyStarTest(int testcase, String number) {
        this.testcase = testcase;
        this.number = number;
    }

    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            using.login();
            using.navigation();
            Thread.sleep(500);
            cyclePage cycle = new cyclePage(driver);
            cycle.navigation_OKRs_CFRs();
            SupplyStarPage supply = new SupplyStarPage(driver);
            supply.naviga_supplyStar();
            using.waitForPageLoaded();
            supply.click_create();
            SupplyStarTest[] data_test = {
                    new SupplyStarTest(1, ""),
                    new SupplyStarTest(2, ""),
                    new SupplyStarTest(3, "1"),
            };
            for (int i = 0; i < data_test.length; i++) {
                System.out.println("=========================");
                System.out.println("Testcase: " + data_test[i].testcase);
                supply.supply(data_test[i].number);
                Thread.sleep(1000);
                String noti = using.messgaeError_tagline();
                switch (noti) {
                    case "Bạn chưa chọn nhân viên cần cấp sao !":
                        using.passed();
                        supply.click_choseUser();
                        break;
                    case "Bạn chưa nhập số sao muốn cấp !":
                        using.passed();
                        break;
                    default:
                        supply.click_confirm();
                        noti = using.messgaeError_tagline();
                        if (noti.equals("Bạn đã cấp 1 sao cho 1 nhân sự.")) {
                            using.passed();
                        } else {
                            using.failed();
                        }
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
