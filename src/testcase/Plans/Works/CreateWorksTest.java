package testcase.Plans.Works;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.Plans.PlansPage;
import page_locators.Plans.WorksPage;
import setupbase.baseSetup;

public class CreateWorksTest {

    public static void main(String[] args) {
        try {
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("WorkinGroup");

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage index = new SignInPage(driver);
            PlansPage plans = new PlansPage(driver);
            WorksPage works = new WorksPage(driver);

            index.login();

            plans.navigationToWorksDetails();

            if (index.verifyTitle(index.titlePagePlan)) {

                works.nvgToFormCreate_Works();

                if (index.verifyTitle(index.titlePageWorks)) {

                    works.clearMember();

                    for (int i = 1; i < 6; i++) {
                        System.out.println("=========================");

                        System.out.println("Test Case: " + excel.getCellData("TCID", i));

                        works.CreateWorks(excel.getCellData("title", i));

                        String noti = index.messgaeError_tagline();
                        switch (noti) {
                            case "Nhập tiêu đề của công việc!":
                                index.passed();
                                break;
                            case "Chọn người tham gia của công việc!":
                                index.passed();
                                works.addMember();
                                works.txttitleWorks.clear();
                                break;
                            case "Nhập thời gian thực hiện của công việc!":
                                index.passed();
                                works.choseDaysWorks();
                                works.txttitleWorks.clear();
                                break;
                            case "Chưa chọn nhóm của công việc!":
                                index.passed();
                                works.choseGroupWorks();
                                works.txttitleWorks.clear();
                                break;
                            case "Đã tạo công việc thành công!":
                                index.passed();
                                break;
                            default:
                                index.failed();
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
