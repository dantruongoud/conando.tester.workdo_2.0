package testcase.Educate.lesson;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Educate.createEducatePage;
import page_locators.Educate.editEducatePage;
import page_locators.Educate.lesson.createLessonPage;
import setupbase.baseSetup;

public class createLessonTest {
    int testcase;
    String title, time;

    public createLessonTest(int testcase, String title, String time) {
        this.testcase = testcase;
        this.title = title;
        this.time = time;
    }

    public static void main(String[] args) {
        try {
            createLessonTest[] data_test = {
                    new createLessonTest(1, "", ""),
                    new createLessonTest(2, "Bài giảng", ""),
                    new createLessonTest(3, "Bài giảng", "2")
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            createEducatePage create = new createEducatePage(driver);
            createLessonPage lesson = new createLessonPage(driver);
            editEducatePage edit = new editEducatePage(driver);

            using.login();
            create.navigation_educate();
            Thread.sleep(1000);

            create.CrudEducate();
            using.waitForPageLoaded();

            edit.choseEducate("Automation");
            Thread.sleep(1200);

            lesson.navigation_lesson();
            Thread.sleep(2000);

            if (edit.verifyLesson("CHI TIẾT BÀI GIẢNG")) {
                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");

                    System.out.println("Testcase: " + data_test[i].testcase);
                    lesson.create_lesson(data_test[i].title, data_test[i].time);
                    using.Button_Component();
                    Thread.sleep(1200);

                    String noti = using.messgaeError_tagline();
                    switch (noti) {
                        case "Nhập tiêu đề và thời lượng bải giảng !":
                            lesson.print();
                            break;
                        default:
                            if (noti.equals("Đã cập nhật thông tin bài giảng")) {
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
