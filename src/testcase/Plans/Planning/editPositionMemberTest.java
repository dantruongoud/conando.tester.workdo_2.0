package testcase.Plans.Planning;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Plans.PlansPage;
import setupbase.baseSetup;

public class editPositionMemberTest {

    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage index = new SignInPage(driver);
            PlansPage plans = new PlansPage(driver);

            index.login();

            plans.navigationToWorksDetails();

            if (index.verifyTitle(index.titlePagePlan)) {

                plans.EditPosition();
                System.out.println("=========================");
                System.out.println("Test Case: 1");

                String noti = index.messgaeError_tagline();
                switch (noti) {
                    case "Bạn không thể xóa hết quản lý của kế hoạch.":
                        index.passed();
                        break;
                    default:
                        index.failed();
                        break;
                }
            } else {
                index.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
