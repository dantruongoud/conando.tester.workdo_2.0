package testcase.CFRs.Checkin;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.CFRs.Checkin.CreateDraftCheckinPage;
import setupbase.baseSetup;

public class CreateDraftCheckinTest {

    public static void main(String[] args) {
        try {
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("CheckinDraft");

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            CreateDraftCheckinPage create = new CreateDraftCheckinPage(driver);

            using.login();
            create.navigation_CFRs();
            Thread.sleep(1000);

            create.navigation_checkin();
            using.waitForPageLoaded();

            if (using.verifyTitle(using.titlePageCheckin)) {

                create.chose_OKRs("");
                using.waitForPageLoaded();
                create.click_checkin11();
                Thread.sleep(1000);
                using.Button_Component();
                Thread.sleep(1000);

                for (int i = 1; i < 8; i++) {
                    System.out.println("======================");
                    System.out.println("Testcase: " + excel.getCellData("TCID", i));

                    create.cleartxt();
                    create.create_checkin(excel.getCellData("text1", i), excel.getCellData("text2", i),
                            excel.getCellData("text3", i), excel.getCellData("text4", i));
                    Thread.sleep(1200);

                    String noti = using.messgaeError_tagline();

                    switch (noti) {
                        case "Chưa nhập mức độ tự tin của Mục tiêu !":
                            System.out.println(noti);
                            create.print();
                            create.selectConfidentOKRs();
                            break;
                        case "Bạn cần nhập đầy đủ tất cả thông tin bắt buộc !":
                            System.out.println(noti);
                            create.print();
                            break;
                        case "Bạn chưa chọn quản lý sẽ check-in với bạn !":
                            System.out.println(noti);
                            create.print();
                            create.research("Trần xuân tấn");
                            using.Button_Component();
                            break;
                        default:
                            if (create.verify_checkinDraft()) {
                                System.out.println("Cập nhật Checkin Nháp thành công");
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
