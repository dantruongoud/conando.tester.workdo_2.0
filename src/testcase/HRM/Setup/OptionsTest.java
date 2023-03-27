package testcase.HRM.Setup;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.HRM.HRM_SetupPage;
import setupbase.baseSetup;

public class OptionsTest {
    public static void main(String[] args) {
        try {

            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("HRM-Setup-Options");

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage index = new SignInPage(driver);
            HRM_SetupPage options = new HRM_SetupPage(driver);

            index.login();

            options.navigationHRM_Setup_Options();

            if (index.verifyTitle(index.titleHRM_Setup_Options)) {

                options.OpenModal(options.Options_Company);
                index.btn_isLink.click();

                for (int i = 1; i < 3; i++) {
                    System.out.println("======================");
                    System.out.println("Testcase: " + excel.getCellData("TCID", i));

                    options.setTextSetup_Options(excel.getCellData("name", i));

                    String noti = index.messgaeError_tagline();

                    switch (noti) {
                        case "Bạn chưa nhập tên hạng mục!":
                            index.passed();
                            index.btn_Deltagline.click();
                            options.choseDepartment();
                            break;
                        default:
                            if (options.verifyCreateOptions(excel.getCellData("name", 2))) {
                                index.passed();
                                index.btn_isLink.click();
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
