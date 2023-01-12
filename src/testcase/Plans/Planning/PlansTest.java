package testcase.Plans.Planning;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.Plans.PlansPage;
import setupbase.baseSetup;

public class PlansTest {
    public static void main(String[] args) {
        try {
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("CreateWork");

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage index = new SignInPage(driver);
            PlansPage plans = new PlansPage(driver);

            index.login();

            plans.navigationToFormCreate();

            if (index.verifyTitle(index.myWorkPage)) {

                // Clear member để xảy ra trường hợp User tạo Work với 0 user
                plans.clearMember();

                for (int i = 1; i < 4; i++) {
                    System.out.println("=========================");
                    System.out.println("Test Case: " + excel.getCellData("TCID", i));

                    plans.CreateWork(excel.getCellData("title", i), excel.getCellData("description", i));
                    Thread.sleep(1000);

                    String noti = index.messgaeError_tagline();
                    switch (noti) {
                        case "Kế hoạch chưa có thành viên.":
                            index.passed();
                            plans.addMember();
                            plans.clearDataTest();
                            break;
                        case "Bạn chưa nhập tiêu đề kế hoạch.":
                            index.passed();
                            plans.clearDataTest();
                            break;
                        default:
                            if (noti.equals("Đã tạo kế hoạch: " + excel.getCellData("title", 3))) {
                                index.passed();
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
