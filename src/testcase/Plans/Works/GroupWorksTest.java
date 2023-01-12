package testcase.Plans.Works;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.*;
import page_locators.Plans.*;
import setupbase.baseSetup;

public class GroupWorksTest {
    public static void main(String[] args) {
        try {

            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Works");

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage index = new SignInPage(driver);
            PlansPage plans = new PlansPage(driver);
            WorksPage works = new WorksPage(driver);

            index.login();

            plans.navigationToWorksDetails();

            if (index.verifyTitle(index.titlePagePlan)) {

                works.nvgToFormCreate_GourpWorks();

                if (index.verifyTitle(index.titlePageWorks)) {
                    for (int i = 1; i < 3; i++) {
                        System.out.println("=========================");
                        System.out.println("Test Case: " + excel.getCellData("TCID", i));

                        works.CreateGourpWorks(excel.getCellData("title", i));

                        String noti = index.messgaeError_tagline();

                        switch (noti) {
                            case "Bạn chưa nhập tiêu đề nhóm công việc!":
                                index.passed();
                                break;
                            case "Đã thêm nhóm công việc!":
                                index.passed();
                                break;
                            default:
                                index.failed();
                                break;
                        }
                    }
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
