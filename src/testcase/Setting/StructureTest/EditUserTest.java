package testcase.Setting.StructureTest;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.Setting.StructurePage.CreateDepartmentPage;
import page_locators.Setting.StructurePage.CreateUserPage;
import page_locators.Setting.StructurePage.EditUserPage;
import setupbase.baseSetup;

public class EditUserTest {

    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            CreateDepartmentPage department = new CreateDepartmentPage(driver);
            CreateUserPage createUser = new CreateUserPage(driver);
            EditUserPage edit = new EditUserPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Cấu hình - Sửa Nhân sự");

            using.login();
            using.navigation();

            department.navigation_structure();
            createUser.navigation_user();

            using.waitForPageLoaded();

            edit.enterSearch("email");
            Thread.sleep(1000);

            edit.click_search();
            using.waitForPageLoaded();

            edit.click_choseUser();
            Thread.sleep(1000);

            edit.cleartxt();

            for (int i = 1; i < 4; i++) {
                System.out.println("=========================");
                System.out.println("Testcase: " + excel.getCellData("TCID", i));
                edit.editUser(excel.getCellData("lastname", i), excel.getCellData("firstname", i));
                Thread.sleep(1200);

                String noti = using.messgaeError_tagline();
                switch (noti) {
                    case "Bạn chưa nhập họ và tên cho tài khoản !":
                        edit.print();
                        break;
                    default:
                        if (noti.equals("Đã cập nhật thông tin thành công !")) {
                            using.passed();
                        } else {
                            using.failed();
                        }
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
