package testcase.Todolist;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Todolist.CreatetodolistPage;
import setupbase.baseSetup;

public class CreateTodolistTest {
    int testcase;
    String todolist;

    public CreateTodolistTest(int testcase, String todolist) {
        this.testcase = testcase;
        this.todolist = todolist;
    }

    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage using = new SignInPage(driver);
            CreatetodolistPage create = new CreatetodolistPage(driver);

            using.login();

            create.navigation_todolist();
            using.waitForPageLoaded();

            if (using.verifyTitle("Todolist")) {
                create.click_nextday();
                Thread.sleep(1500);
                create.click_addWork();
                CreateTodolistTest[] data_test = {
                        new CreateTodolistTest(1, ""),
                        new CreateTodolistTest(2, "todolist")
                };
                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");

                    System.out.println("Testcase: " + data_test[i].testcase);
                    create.create_todolist(data_test[i].todolist);
                    Thread.sleep(1000);

                    String noti = using.messgaeError_tagline();
                    switch (noti) {

                        case "Bạn chưa nhập tên công việc !":
                            using.passed();
                            break;

                        default:
                            if (create.check_todolist()) {
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
