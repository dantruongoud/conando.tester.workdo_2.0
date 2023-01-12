package testcase.Plans.Planning;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Plans.PlansPage;
import setupbase.baseSetup;

public class StickerTest {
    int testcase;
    String title;

    public StickerTest(int testcase, String title) {
        this.testcase = testcase;
        this.title = title;
    }

    public static void main(String[] args) {
        try {

            StickerTest[] data = {
                    new StickerTest(1, ""),
                    new StickerTest(2, "Hằng tháng"),
            };
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage index = new SignInPage(driver);
            PlansPage plans = new PlansPage(driver);

            index.login();

            plans.navigationToWorksDetails();

            if (index.verifyTitle(index.titlePagePlan)) {
                for (int i = 0; i < data.length; i++) {
                    System.out.println("=========================");
                    System.out.println("Test Case: " + data[i].testcase);

                    plans.CreateSticker(data[i].title);

                    String noti = index.messgaeError_tagline();
                    switch (noti) {
                        case "Bạn chưa nhập tiêu đề nhãn.":
                            index.passed();
                            break;
                        case "Đã cập nhật nhãn công việc.":
                            index.passed();
                            break;
                        default:
                            index.failed();
                            break;
                    }
                }
            } else {
                index.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
