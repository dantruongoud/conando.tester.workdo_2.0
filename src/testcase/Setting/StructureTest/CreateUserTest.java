package testcase.Setting.StructureTest;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.Setting.StructurePage.CreateDepartmentPage;
import page_locators.Setting.StructurePage.CreateUserPage;
import setupbase.baseSetup;

public class CreateUserTest {


    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            CreateDepartmentPage department = new CreateDepartmentPage(driver);
            CreateUserPage createUser = new CreateUserPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Cấu hình - Nhân sự");

            using.login();
            using.navigation();

            department.navigation_structure();
            createUser.navigation_user();
            using.waitForPageLoaded();

            createUser.click_create();
            Thread.sleep(1000);

            if (using.verifyTitle("Tạo tài khoản mới")) {

                for (int i = 1; i < 7; i++) {

                    System.out.println("=========================");

                    System.out.println("Testcase: " + excel.getCellData("TCID", i));
                    createUser.createUser(excel.getCellData("email", i), excel.getCellData("lastname", i),
                            excel.getCellData("firstname", i), excel.getCellData("password", i));
                    Thread.sleep(1200);

                    String noti = using.messgaeError_tagline();
                    switch (noti) {
                        case "Bạn chưa nhập địa chỉ email, hoặc địa chỉ email không đúng !":
                            createUser.print();
                            break;
                        case "Bạn chưa nhập họ và tên cho tài khoản !":
                            createUser.print();
                            break;
                        case "Bạn chưa nhật mật khẩu cho tài khoản !":
                            createUser.print();
                            break;
                        default:
                            noti = using.messgaeError_tagline();
                            if (noti != null) {
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
