package testcase.Setting.OKRs_CFRsTest;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.OKRs_CFRsPage.SupplyStarPage;
import page_locators.Setting.OKRs_CFRsPage.cyclePage;
import page_locators.Setting.OKRs_CFRsPage.minusSatrsPage;
import setupbase.baseSetup;

public class minusStarsTest {
    int testcase;
    String number;

    public minusStarsTest(int testcase, String number) {
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
            minusSatrsPage minus = new minusSatrsPage(driver);
            minus.naviga_minusStar();
            using.waitForPageLoaded();
            minus.click_create();
            minusStarsTest[] data_test = {
                    new minusStarsTest(1, ""),
                    new minusStarsTest(2, ""),
                    new minusStarsTest(3, "1"),
            };
            for (int i = 0; i < data_test.length; i++) {
                System.out.println("=========================");
                System.out.println("Testcase: " + data_test[i].testcase);
                supply.supply(data_test[i].number);
                Thread.sleep(1000);
                String noti = using.messgaeError_tagline();
                switch (noti) {
                    case "Bạn chưa chọn nhân viên cần trừ sao !":
                        using.passed();
                        supply.click_choseUser();
                        break;
                    case "Bạn chưa nhập số sao muốn trừ !":
                        using.passed();
                        break;
                    default:
                        supply.click_confirm();
                        if (noti.equals("Bạn đã trừ 1 sao cho 1 nhân sự.")) {
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
