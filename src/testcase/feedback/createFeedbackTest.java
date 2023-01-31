package testcase.feedback;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.feedback.createFeedbackPage;
import setupbase.baseSetup;

public class createFeedbackTest {
    int testcase;
    String title, content;

    public createFeedbackTest(int testcase, String title, String content) {
        this.testcase = testcase;
        this.title = title;
        this.content = content;
    }

    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            createFeedbackPage create = new createFeedbackPage(driver);
            excelhelpers excel = new excelhelpers();

            excel.setExcelSheet("Góp ý hệ thống");
            using.login();
            create.navigation_feedback();
            using.waitForPageLoaded();

            if (using.verifyTitle(using.titlePageFeedback)) {
                using.Button_Component();
                for (int i = 1; i < 4; i++) {

                    System.out.println("======================");

                    System.out.println("Testcase: " + excel.getCellData("TCID", i));
                    create.createFeedback(excel.getCellData("title", i), excel.getCellData("content", i));
                    using.Button_Component();
                    Thread.sleep(1200);

                    String noti = using.messgaeError_tagline();
                    switch (noti) {
                        case "Nhập đủ tiêu đề và nội dung !":
                            create.print();
                            break;
                        default:
                            if (noti.equals("Đã gửi góp ý thành công")) {
                                using.passed();
                            } else {
                                using.failed();
                            }
                            break;
                    }
                    Thread.sleep(1000);
                }
            } else {
                using.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
