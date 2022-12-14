package testcase.Setting.OKRs_CFRsTest;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.OKRs_CFRsPage.CreateCriteriaPage;
import page_locators.Setting.OKRs_CFRsPage.cyclePage;
import setupbase.baseSetup;

public class CreateCriteriaTest {
    int testcase;
    String name;

    public CreateCriteriaTest(int testcase, String name) {
        this.testcase = testcase;
        this.name = name;
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
            CreateCriteriaPage criteria = new CreateCriteriaPage(driver);
            criteria.navigation_criteria();
            using.waitForPageLoaded();
            criteria.click_create();
            CreateCriteriaTest[] data_test = {
                    new CreateCriteriaTest(1, ""),
                    new CreateCriteriaTest(2, "A")
            };
            for (int i = 0; i < data_test.length; i++) {
                System.out.println("=========================");
                System.out.println("Testcase: " + data_test[i].testcase);
                criteria.create_criteria(data_test[i].name);
                Thread.sleep(1000);
                String noti = using.messgaeError_tagline();
                switch (noti) {
                    case "Bạn cần nhập tên tiêu chí !":
                        using.passed();
                        break;
                    default:
                        if (criteria.verifyText()) {
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
