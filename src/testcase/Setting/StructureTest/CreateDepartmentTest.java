package testcase.Setting.StructureTest;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.Setting.StructurePage.CreateDepartmentPage;
import setupbase.baseSetup;

public class CreateDepartmentTest {

    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            CreateDepartmentPage department = new CreateDepartmentPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Cấu hình - Phòng ban");

            using.login();
            using.navigation();
            department.navigation_structure();
            using.waitForPageLoaded();
            department.click_createBtn();
            Thread.sleep(1000);
            if (using.verifyTitle("Tạo phòng ban mới")) {

                for (int i = 1; i < 5; i++) {
                    System.out.println("=========================");
                    System.out.println("Testcase: " + excel.getCellData("TCID", i));
                    department.createDepartment(excel.getCellData("nameDepartment", i), excel.getCellData("manager", i),
                            excel.getCellData("deputy", i));
                    Thread.sleep(1200);

                    String noti = using.messgaeError_tagline();
                    switch (noti) {
                        case "Bạn cần nhập đầy đủ thông tin !":
                            department.print();
                            break;
                        default:
                            if (noti.equals("Đã tạo phòng ban " + excel.getCellData("nameDepartment", 4))) {
                                using.passed();
                            } else {
                                using.failed();
                            }
                            break;
                    }
                    Thread.sleep(1200);
                }
            } else {
                using.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
