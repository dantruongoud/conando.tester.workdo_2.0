package testcase.fWorks.Planning;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.fWorks.PlansPage;
import setupbase.baseSetup;

public class HistoryTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage index = new SignInPage(driver);
            PlansPage plans = new PlansPage(driver);

            index.login();

            plans.navigationToWorksDetails();

            if (index.verifyTitle(index.titlePagePlan)) {
                plans.getHistoryPlan();
            } else {
                index.error_titlePage();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
