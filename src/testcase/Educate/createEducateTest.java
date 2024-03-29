package testcase.Educate;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.Educate.createEducatePage;
import setupbase.baseSetup;

public class createEducateTest {
    

    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            createEducatePage create = new createEducatePage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Tạo khoá học");

            using.login();
            create.navigation_educate();
            Thread.sleep(1000);

            create.CrudEducate();
            using.waitForPageLoaded();

            using.Button_Component();
            Thread.sleep(2000);
            
            if (using.verifyTitle(using.titlePageEducate)) {

                for (int i = 1; i < 4; i++) {
                    System.out.println("======================");

                    System.out.println("Testcase: " + excel.getCellData("TCID", i));
                    create.createEducate(excel.getCellData("title", i), excel.getCellData("number", i),
                            excel.getCellData("time", i));
                    Thread.sleep(1200);

                    String noti = using.messgaeError_tagline();
                    switch (noti) {
                        case "Nhập tiêu đề và hình ảnh khóa học !":
                            create.print();
                            Thread.sleep(1000);
                            using.uploadImage("//li[@class='column is-half']//div[@class='control']", "xpath");
                            break;
                        case "Nhập số bài học và thời lượng khóa học !":
                            create.print();
                            break;
                        default:
                            if (create.verifyEducatenew("Automation")) {
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
