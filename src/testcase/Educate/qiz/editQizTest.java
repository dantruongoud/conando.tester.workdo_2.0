package testcase.Educate.qiz;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.Educate.createEducatePage;
import page_locators.Educate.editEducatePage;
import page_locators.Educate.qiz.createQizPage;
import setupbase.baseSetup;

public class editQizTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            createEducatePage create = new createEducatePage(driver);
            editEducatePage edit = new editEducatePage(driver);
            createQizPage qiz = new createQizPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Sửa bài trắc nghiệm");

            using.login();
            create.navigation_educate();
            Thread.sleep(1000);
            create.CrudEducate();
            using.waitForPageLoaded();
            edit.choseEducate("Automation");
            Thread.sleep(1200);
            edit.choseLesson("Bài thi trắc nghiệm");
            using.waitForPageLoaded();
            if (edit.verifyLesson("CHI TIẾT BÀI TRẮC NGHIỆM")) {
                qiz.clearTXT();
                Thread.sleep(1000);

                for (int i = 1; i < 9; i++) {
                    System.out.println("======================");
                    System.out.println("Testcase: " + excel.getCellData("TCID", i));
                    qiz.create_qiz(excel.getCellData("title", i), excel.getCellData("time", i),
                            excel.getCellData("point", i), excel.getCellData("content", i),
                            excel.getCellData("result", i));
                    using.Button_Component();
                    Thread.sleep(1200);
                    String noti = using.messgaeError_tagline();
                    switch (noti) {
                        case "Nhập tiêu đề và thời lượng bài trắc nghiệm !":
                            qiz.print();
                            break;
                        case "Giá trị mức điểm đạt phải lớn hơn hoặc bằng 1 !":
                            qiz.print();
                            break;
                        case "Mức điểm đạt được của bài thi phải nhỏ hơn tổng điểm bài thi !":
                            qiz.print();
                            break;
                        case "Có câu hỏi chưa nhập nội dung, vui lòng nhập nội dung cho câu hỏi":
                            qiz.print();
                            break;
                        case "Có đáp án chưa có nội dung, vui lòng nhập nội dung cho đáp án !":
                            qiz.print();
                            break;
                        // Khi sửa thì trường hợp này luôn luôn đúng nên k cần check
                        // case "Có câu hỏi chưa có đáp án đúng, vui lòng chọn 1 đáp án đúng cho câu hỏi
                        // !":
                        // System.out.println(noti);
                        // qiz.check_checkbox();
                        // qiz.print();
                        // break;
                        default:
                            if (noti.equals("Đã cập nhật thông tin bài trắc nghiệm !")) {
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
