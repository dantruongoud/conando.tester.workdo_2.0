package testcase.CFRs.Checkin;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.CFRs.Checkin.CreateDraftCheckinPage;
import page_locators.CFRs.Checkin.RepplyPage;
import setupbase.baseSetup;

public class RepplyTest {
    int testcase;
    String repply;

    public RepplyTest(int testcase, String repply) {
        this.testcase = testcase;
        this.repply = repply;
    }

    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            CreateDraftCheckinPage create = new CreateDraftCheckinPage(driver);
            RepplyPage Repply = new RepplyPage(driver);

            using.login();
            create.navigation_CFRs();
            Thread.sleep(1000);
            create.navigation_checkin();
            using.waitForPageLoaded();

            create.chose_OKRs("Đã check-in");
            Thread.sleep(1000);
            Repply.navigation_repply();
            using.waitForPageLoaded();

            if (using.verifyTitle("CFRs - Phản hồi Check-in")) {
                RepplyTest[] data_test = {
                        new RepplyTest(1, ""),
                        new RepplyTest(2, "Cảm ơn Ngài!!!")
                };
                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");
                    System.out.println("Testcase: " + data_test[i].testcase);
                    Repply.enterRepply(data_test[i].repply);
                    using.Button_Component();
                    
                    Thread.sleep(1000);
                    String noti = using.messgaeError_tagline();
                    switch (noti) {
                        case "Bạn chưa nhập nội dung phản hồi !":
                            System.out.println(noti);
                            using.passed();
                            Repply.uploadImage();
                            break;
                        default:
                            if (Repply.verifyCmt("Cảm ơn Ngài!!!")) {
                                System.out.println("Phản hồi thành công");
                                using.passed();
                            } else {
                                using.failed();
                            }
                            break;
                    }
                }
            } else {
                using.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
