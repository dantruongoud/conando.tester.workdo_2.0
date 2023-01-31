package testcase;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import setupbase.baseSetup;

public class SignInTest {

    public static void main(String[] args) {
        try {
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("login");

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);

            if (using.verifyTitle(using.titlePageSignIn)) {
                for (int i = 1; i < 6; i++) {

                    System.out.println("=========================");
                    System.out.println("Testcase: " + excel.getCellData("TCID", i));

                    using.cleartxt();
                    using.SignIn(excel.getCellData("username", i), excel.getCellData("password", i));

                    Thread.sleep(1200);

                    String noti = using.messgaeError_tagline();

                    for (int j = 0; j < using.taglinetext.length; j++) {
                        if (noti.equals(using.taglinetext[j])) {
                            using.passed();
                            break;
                        } else if (using.displayedlogout().contains("Xin chào !")) {
                            System.out.println("Đăng nhập thành công");
                            using.passed();
                            break;
                        } else {
                            using.failed();
                        }
                    }

                    // switch (noti) {

                    // case "Tên đăng nhập hoặc mật khẩu không đúng !":
                    // System.out.println(noti);
                    // using.passed();
                    // break;

                    // default:
                    // if (using.displayedlogout() != null) {
                    // System.out.println(using.displayedlogout());
                    // System.out.println("Đăng nhập thành công");
                    // using.passed();
                    // } else {
                    // using.failed();
                    // }
                    // break;
                    // }

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
