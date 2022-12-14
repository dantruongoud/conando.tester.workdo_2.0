package testcase.Setting.OKRs_CFRsTest;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.OKRs_CFRsPage.CreateCriteriaPage;
import page_locators.Setting.OKRs_CFRsPage.cyclePage;
import page_locators.Setting.OKRs_CFRsPage.editCriteriaPage;
import setupbase.baseSetup;

public class editCriteriaTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            cyclePage cycle = new cyclePage(driver);
            CreateCriteriaPage criteria = new CreateCriteriaPage(driver);
            editCriteriaPage edit = new editCriteriaPage(driver);

            using.login();
            using.navigation();
            cycle.navigation_OKRs_CFRs();
            criteria.navigation_criteria();
            edit.click_edit();
            Thread.sleep(1000);

            edit.cleartxt();
            criteria.click_save();
            System.out.println("=========================");
            System.out.println("Testcase: 1");
            String noti = using.messgaeError_tagline();
            if (noti.equals("Bạn cần nhập tên tiêu chí !")) {
                System.out.println(noti);
                System.out.println("PASSED");
                System.out.println("=========================");
                criteria.enterNameCriteria("A");
                criteria.enterStarNumber("1");
                criteria.click_save();
                if (criteria.verifyText()) {
                    System.out.println("=========================");
                    System.out.println("Testcase: 2");
                    System.out.println("Cập nhật thành công");
                    using.passed();
                } else {
                    using.failed();
                }
            } else {
                using.failed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
