package testcase.Kaizen;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.Kaizen.CreateKaizenPage;
import setupbase.baseSetup;

public class CreateKaizenTest {

    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            CreateKaizenPage kaizen = new CreateKaizenPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Kaizen");

            using.login();
            kaizen.navigation_Kaizen();
            using.waitForPageLoaded();

            if (using.verifyTitle(using.titlePageKaizen)) {
                using.Button_Component();
                Thread.sleep(2000);

                kaizen.chose_catagory("Gia tăng năng suất");
                kaizen.chose_subCategory("Cải thiện cách đánh giá nhân sự");
                for (int i = 1; i < 4; i++) {
                    System.out.println("======================");

                    System.out.println("Testcase: " + excel.getCellData("TCID", i));
                    kaizen.createKaizen(excel.getCellData("title", i), excel.getCellData("content", i));
                    using.Button_Component();
                    Thread.sleep(1200);

                    String noti = using.messgaeError_tagline();

                    switch (noti) {
                        case "Nhập đủ tiêu đề và nội dung !":
                            kaizen.print();
                            break;
                        default:
                            if (noti.equals("Đã gửi góp ý Kaizen thành công!")) {
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
