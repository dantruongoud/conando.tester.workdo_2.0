package testcase.Kaizen;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Kaizen.CreateKaizenPage;
import page_locators.Kaizen.appraiseKaizenPage;
import page_locators.Kaizen.repplyKaizenPage;
import setupbase.baseSetup;

public class repplyKaizenTest {
    int testcase;
    String content;

    public repplyKaizenTest(int testcase, String content) {
        this.testcase = testcase;
        this.content = content;
    }

    public static void main(String[] args) {
        try {
            repplyKaizenTest[] data_test = {
                    new repplyKaizenTest(1, ""),
                    new repplyKaizenTest(2, "Tôi hơi bị kết cái Kaizen của bạn đấy"),
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            CreateKaizenPage kaizen = new CreateKaizenPage(driver);
            appraiseKaizenPage appraise = new appraiseKaizenPage(driver);
            repplyKaizenPage repply = new repplyKaizenPage(driver);

            using.login();
            kaizen.navigation_Kaizen();
            using.waitForPageLoaded();

            appraise.chose_Kaizen("Tôi cần góp ý");
            using.waitForPageLoaded();

            if (using.verifyTitle(using.titlePageDetailsKaizen)) {
                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");
                    System.out.println("Testcase: " + data_test[i].testcase);
                    repply.enterContent(data_test[i].content);
                    using.Button_Component();
                    Thread.sleep(1000);

                    String noti = using.messgaeError_tagline();
                    switch (noti) {
                        case "Chưa nhập nội dung bình luận !":
                            using.passed();
                            using.uploadImage("//a[@title='Đính kèm hình ảnh']", "");
                            break;
                        default:
                            if (repply.verifyContent("Tôi hơi bị kết cái Kaizen của bạn đấy")) {
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
