package testcase.fWorks.Works;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.fWorks.PlansPage;
import page_locators.fWorks.WorksPage;
import setupbase.baseSetup;

public class CreateSubWorksTest {
    public static void main(String[] args) {
        try {
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("SubWorks");

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage index = new SignInPage(driver);
            PlansPage plans = new PlansPage(driver);
            WorksPage works = new WorksPage(driver);

            index.login();

            plans.navigationToWorksDetails();

            if (index.verifyTitle(index.titlePagePlan)) {

                works.nvgToSubWorks();

                if (index.verifyTitle(index.titlePageWorks)) {
                    for (int i = 1; i < 5; i++) {
                        works.clearDataTestSubWorks();
                        System.out.println("=========================");

                        System.out.println("Test Case: " + excel.getCellData("TCID", i));

                        works.CreateSubWorks(excel.getCellData("title", i), excel.getCellData("description", i));

                        String noti = index.messgaeError_tagline();

                        switch (noti) {
                            case "Nhập tiêu đề của công việc":
                                index.passed();
                                works.btnDeleteTagline.click();
                                break;
                            case "Nhập thời gian thực hiện của công việc.":
                                index.passed();
                                works.choseDaySubWorks();
                                break;
                            case "Chọn người tham gia của công việc.":
                                index.passed();
                                works.addMemberSubWorks();
                                break;
                            default:
                                if (works.verifyCreate_Subwork(excel.getCellData("title", 4))) {
                                    index.passed();
                                } else {
                                    index.failed();
                                }
                                break;
                        }
                        Thread.sleep(1200);
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
