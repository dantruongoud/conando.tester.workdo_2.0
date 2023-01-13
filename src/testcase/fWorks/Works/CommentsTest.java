package testcase.fWorks.Works;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.fWorks.PlansPage;
import page_locators.fWorks.WorksPage;
import setupbase.baseSetup;

public class CommentsTest {
    public static void main(String[] args) {
        try {
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Comments");

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage index = new SignInPage(driver);
            PlansPage plans = new PlansPage(driver);
            WorksPage works = new WorksPage(driver);

            index.login();

            plans.navigationToWorksDetails();

            if (index.verifyTitle(index.titlePagePlan)) {

                works.nvgToComments();

                if (index.verifyTitle(index.titlePageWorks)) {

                    for (int i = 1; i < 3; i++) {
                        System.out.println("=========================");

                        System.out.println("Test Case: " + excel.getCellData("TCID", i));

                        works.CreateComments(excel.getCellData("content", i));

                        String noti = index.messgaeError_tagline();
                        switch (noti) {
                            case "Bạn chưa nhập nội dung bình luận!":
                                index.passed();
                                works.btnDeleteTagline.click();
                                break;
                            default:
                                if (works.verifyComments(excel.getCellData("content", 2))) {
                                    System.out.println("Create Success");
                                    index.passed();
                                } else {
                                    index.failed();
                                }
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