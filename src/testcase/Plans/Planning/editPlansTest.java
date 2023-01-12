package testcase.Plans.Planning;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.Plans.PlansPage;
import setupbase.baseSetup;

public class editPlansTest {
    public static void main(String[] args) {
        try {
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("CreateWork");

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage index = new SignInPage(driver);
            PlansPage plans = new PlansPage(driver);

            index.login();

            plans.navigationToWorksDetails();

            plans.btnEditPlans.click();
            Thread.sleep(1000);

            if (index.verifyTitle(index.titlePagePlan)) {

                for (int i = 2; i < 4; i++) {

                    plans.clearDataTest();

                    System.out.println("=========================");
                    System.out.println("Test Case: " + excel.getCellData("TCID", i - 1));

                    plans.EditWorks(excel.getCellData("title", i), excel.getCellData("description", i));

                    String noti = index.messgaeError_tagline();
                    switch (noti) {
                        case "Bạn chưa nhập tiêu đề kế hoạch.":
                            index.passed();
                            break;
                        default:
                            if (noti.equals("Đã cập nhật thông tin của dự án.")) {
                                index.passed();
                            } else {
                                index.failed();
                            }
                            break;
                    }
                    Thread.sleep(1000);
                }
            } else {
                index.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
