package testcase.HRM.Setup;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.HRM.HRM_SetupPage;
import setupbase.baseSetup;

public class WorkShiftTest {
    public static void main(String[] args) {
        try {

            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("HRM-Setup-WorkShift");

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage index = new SignInPage(driver);
            HRM_SetupPage work_shift = new HRM_SetupPage(driver);

            index.login();

            work_shift.navigationHRM_Setup_WorkShift();

            if (index.verifyTitle(index.titleHRM_Setup_Work_shift)) {

                work_shift.OpenModal(index.btn_isLink);

                for (int i = 1; i < 6; i++) {

                    System.out.println("======================");
                    System.out.println("TestCase: " + excel.getCellData("TCID", i));

                    work_shift.CleartextworkshiftForm();

                    work_shift.setTextSetup_WorkShift(excel.getCellData("name", i), excel.getCellData("number", i));
                    Thread.sleep(500);
                    index.btn_isLink_Right.click();
                    Thread.sleep(500);

                    String noti = index.messgaeError_tagline();

                    switch (noti) {
                        case "Bạn chưa nhập tiêu đề địa điểm!":
                            index.passed();
                            index.btn_Deltagline.click();
                            break;
                        case "Bạn chưa chọn giờ bắt đầu!":
                            index.passed();
                            work_shift.SelectTimeStart_WorkShift();
                            break;
                        case "Bạn chưa nhập giờ kết thúc!":
                            index.passed();
                            work_shift.SelectTimeEnd_WorkShift();
                            break;
                        case "Bạn chưa nhập số công!":
                            index.passed();
                            break;
                        default:
                            if (work_shift.verifyCreate_WorkShift(excel.getCellData("name", 5))) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
