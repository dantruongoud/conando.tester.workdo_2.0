package testcase.fWorks.Works;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.fWorks.PlansPage;
import page_locators.fWorks.WorksPage;
import setupbase.baseSetup;

public class HistoryTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage index = new SignInPage(driver);
            PlansPage plans = new PlansPage(driver);
            WorksPage works = new WorksPage(driver);

            index.login();

            plans.navigationToWorksDetails();

            if (index.verifyTitle(index.titlePagePlan)) {
                
                works.nvgToHistoryWorks();

                if (index.verifyTitle(index.titlePageWorks)) {
                    plans.getHistoryPlan();
                } else {
                    index.error_titlePage();
                }
            } else {
                index.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
