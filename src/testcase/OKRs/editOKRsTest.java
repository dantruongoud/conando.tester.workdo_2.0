package testcase.OKRs;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.OKRs.CreateOKRsPage;
import page_locators.OKRs.editOKRsPage;
import setupbase.baseSetup;

public class editOKRsTest {

    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            CreateOKRsPage create = new CreateOKRsPage(driver);
            excelhelpers excel = new excelhelpers();
            editOKRsPage edit = new editOKRsPage(driver);
            excel.setExcelSheet("Tạo OKRs");

            using.login();
            create.click_navigation_OKRs();
            Thread.sleep(1000);

            create.click_navigation_CreateOKRs();
            Thread.sleep(1000);

            create.click_navigation_CreatePage();
            Thread.sleep(1000);
            edit.chose_OKRsedit("OKRs QUY I");
            using.waitForPageLoaded();

            create.cleartxt();

            for (int i = 1; i < 6; i++) {

                System.out.println("======================");

                System.out.println("Testcase: " + excel.getCellData("TCID", i));
                create.create_OKRs(excel.getCellData("nameOKRs", i), excel.getCellData("nameResult", i),
                        excel.getCellData("number", i), excel.getCellData("unit", i));
                Thread.sleep(1200);

                String noti = using.messgaeError_tagline();
                switch (noti) {
                    case "Nhập các mục tiêu của bạn !":
                        create.print();
                        break;
                    case "Nhập đầy đủ tiêu đề của các kết quả then chốt hoặc xóa kết quả then chốt không cần thiết !":
                        create.print();
                        break;
                    case "Nhập đầy đủ mục tiêu của các kết quả then chốt !":
                        create.print();
                        break;
                    default:
                        if (create.verifyOKRs("OKRs QUY I")) {
                            using.passed();
                        } else {
                            using.failed();
                        }
                        break;
                }
                Thread.sleep(1200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
