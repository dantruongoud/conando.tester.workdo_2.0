package testcase.CFRs.Recognition_Star;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.CFRs.Checkin.CreateDraftCheckinPage;
import page_locators.CFRs.Recognition_Star.giftStartPage;
import page_locators.CFRs.Recognition_Star.recognitonPage;
import setupbase.baseSetup;

public class giftStartTest {
    int testcase;
    String number;

    public giftStartTest(int testcase, String number) {
        this.testcase = testcase;
        this.number = number;
    }

    public static void main(String[] args) {
        try {
            giftStartTest[] data_test = {
                    new giftStartTest(1, "2"),
                    new giftStartTest(2, "2"),
                    new giftStartTest(3, "0"),
                    new giftStartTest(4, "1"),
                    new giftStartTest(5, "1"),
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

                giftStartPage Star = new giftStartPage(driver);
                Star.select();

                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");
                    System.out.println("Testcase: " + data_test[i].testcase);
                    Star.Stargift(data_test[i].number);
                    using.Button_Component();

                    Thread.sleep(1000);
                    String noti = using.messgaeError_tagline();
                    switch (noti) {
                        case "Bạn chưa chọn người nhận !":
                            System.out.println(noti);
                            Star.print();
                            create.research("NGUYEN DAN TRUONG");
                            break;
                        case "Bạn không thể ghi nhận - tặng sao cho chính mình !":
                            create.clearSearch();
                            System.out.println(noti);
                            Star.print();
                            create.research("Dương Thanh Trúc");
                            break;
                        case "Bạn chưa chọn số sao muốn tặng !":
                            System.out.println(noti);
                            Star.print();
                            break;
                        case "Bạn chưa nhập nội dung !":
                            System.out.println(noti);
                            Star.print();
                            use.enterContent("content");
                            break;
                        default:
                            noti = using.messgaeError_tagline();
                            if (noti.equals("Bạn đã Tặng 1 sao cho Dương Thanh Trúc thành công!")) {
                                System.out.println(noti);
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
