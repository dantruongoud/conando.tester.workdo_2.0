package testcase.CFRs.Recognition_Star;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.CFRs.Checkin.CreateDraftCheckinPage;
import page_locators.CFRs.Recognition_Star.recognitonPage;
import setupbase.baseSetup;

public class recognitionTest {
    int testcase;
    String content;

    public recognitionTest(int testcase, String content) {
        this.testcase = testcase;
        this.content = content;
    }

    public static void main(String[] args) {
        try {

            recognitionTest[] data_test = {
                    new recognitionTest(1, "content"),
                    new recognitionTest(2, "content"),
                    new recognitionTest(3, ""),
                    new recognitionTest(4, ""),
                    new recognitionTest(5, "content")
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            CreateDraftCheckinPage create = new CreateDraftCheckinPage(driver);
            recognitonPage use = new recognitonPage(driver);

            using.login();
            create.navigation_CFRs();
            Thread.sleep(1000);
            use.navigation_recognition();
            using.waitForPageLoaded();

            if (using.verifyTitle(using.titlePageGiftStar)) {

                for (int i = 0; i < data_test.length; i++) {

                    System.out.println("======================");
                    System.out.println("Testcase: " + data_test[i].testcase);

                    use.recognition(data_test[i].content);
                    using.Button_Component();
                    Thread.sleep(1200);

                    String noti = using.messgaeError_tagline();

                    switch (noti) {
                        case "Bạn chưa chọn người nhận !":
                            System.out.println(noti);
                            using.passed();
                            create.research("NGUYEN DAN TRUONG");
                            use.clear();
                            break;
                        case "Bạn không thể ghi nhận - tặng sao cho chính mình !":
                            create.clearSearch();
                            System.out.println(noti);
                            using.passed();
                            create.research("Dương Thanh Trúc");
                            use.clear();
                            break;
                        case "Bạn chưa chọn tiêu chí ghi nhận !":
                            System.out.println(noti);
                            using.passed();
                            use.select();
                            break;
                        case "Bạn chưa nhập nội dung !":
                            System.out.println(noti);
                            using.passed();
                            break;
                        default:
                            noti = using.messgaeError_tagline();
                            if (noti.equals("Bạn đã Gửi ghi nhận cho Dương Thanh Trúc thành công!")) {
                                System.out.println(noti);
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
