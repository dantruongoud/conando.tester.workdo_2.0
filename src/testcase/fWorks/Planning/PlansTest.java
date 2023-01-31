package testcase.fWorks.Planning;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.fWorks.PlansPage;
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

                // Gọi hàm Clear member để xảy ra trường hợp User tạo Plan với 0 user
                plans.clearMember();

                for (int i = 1; i < 4; i++) {
                    System.out.println("======================");
                    System.out.println("Test Case: " + excel.getCellData("TCID", i));

                    plans.clearDataTest();
                    plans.CreateWork(excel.getCellData("title", i), excel.getCellData("description", i));
                    Thread.sleep(1000);

                    boolean passed = false;

                    String noti = index.messgaeError_tagline();

                    for (int j = 0; j < plans.taglinetext.length; j++) {

                        if (noti.equals(plans.taglinetext[j])) {
                            passed = true;
                            index.passed();
                            if (j == 0)
                                plans.addMember();
                            break;
                        } else if (noti.contains("Đã tạo kế hoạch: ")) {
                            passed = true;
                            index.passed();
                            break;
                        }
                    }

                    if (!passed)
                        index.failed();

                    // switch (noti) {
                    // case "Kế hoạch chưa có thành viên.":
                    // index.passed();
                    // plans.addMember();
                    // plans.clearDataTest();
                    // break;
                    // case "Bạn chưa nhập tiêu đề kế hoạch.":
                    // index.passed();
                    // plans.clearDataTest();
                    // break;
                    // default:
                    // if (noti.equals("Đã tạo kế hoạch: " + excel.getCellData("title", 3))) {
                    // index.passed();
                    // } else {
                    // index.failed();
                    // }
                    // break;
                    // }

                }
            } else {
                index.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}