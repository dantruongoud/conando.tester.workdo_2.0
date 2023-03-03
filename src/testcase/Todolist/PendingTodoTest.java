package testcase.Todolist;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Todolist.CreatetodolistPage;
import page_locators.Todolist.PendingTodoPage;
import setupbase.baseSetup;

public class PendingTodoTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage index = new SignInPage(driver);
            CreatetodolistPage create = new CreatetodolistPage(driver);
            PendingTodoPage pending = new PendingTodoPage(driver);

            index.login();

            create.navigation_todolist();
            index.waitForPageLoaded();

            pending.createTodo();
            // pending.chosePending();

            if (pending.titleModal.getText().equals("CÔNG VIỆC CHỜ XỬ LÝ")) {
                pending.btnCheckoutModal.click();
                Thread.sleep(1000);
                String noti = index.messgaeError_tagline();
                if (noti.equals("Ngày thực hiện của công việc chờ xử lý phải sau ngày hôm nay!")) {
                    index.passed();
                    pending.btnNextday.click();
                    pending.btnCheckoutModal.click();
                    Thread.sleep(1000);
                    driver.switchTo().alert().accept();
                } else {
                    index.failed();
                }
            } else {
                index.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
