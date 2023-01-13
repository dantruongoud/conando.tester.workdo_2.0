package testcase.fWorks.Works;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.fWorks.PlansPage;
import page_locators.fWorks.WorksPage;
import setupbase.baseSetup;

public class TodolistLinkTest {
    public static void main(String[] args) {
        try {
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("TodolistLink");

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage index = new SignInPage(driver);
            PlansPage plans = new PlansPage(driver);
            WorksPage works = new WorksPage(driver);

            index.login();

            plans.navigationToWorksDetails();

            if (index.verifyTitle(index.titlePagePlan)) {

                works.nvgToTodolistLink();

                if (index.verifyTitle(index.titlePageWorks)) {

                    for (int i = 1; i < 4; i++) {

                        works.txtTitleTodolist.clear();
                        System.out.println("=========================");

                        System.out.println("Test Case: " + excel.getCellData("TCID", i));

                        works.CreateTodolistLink(excel.getCellData("title", i));

                        String noti = index.messgaeError_tagline();
                        switch (noti) {
                            case "Nhập tiêu đề của Todolist":
                                index.passed();
                                break;
                            case "Chọn ngày tạo Todolist":
                                index.passed();
                                works.choseDaySubWorks();
                                break;
                            case "Đã tạo Todolist liên kết với công việc":
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
