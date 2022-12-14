package page_locators.Educate.essay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createEssayPage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Thêm bài tự luận')]")
    private WebElement naviga_essay;

    @FindBy(css = "input[placeholder='Nhập tiêu đề bài tự luận...']")
    private WebElement title_input;

    @FindBy(xpath = "//input[@class='input is_bg']")
    private WebElement time_input;

    @FindBy(tagName = "textarea")
    private WebElement content_input;

    @FindBy(css = "input[class='input']")
    private WebElement point_input;

    public createEssayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigation_essay() {
        try {
            if (naviga_essay.isDisplayed()) {
                naviga_essay.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createEssay(String title, String time, String point, String content) {
        title_input.sendKeys(title);
        time_input.sendKeys(time);
        point_input.sendKeys(point);
        content_input.sendKeys(content);
    }

    public void clearTXT() {
        title_input.clear();
        time_input.clear();
        point_input.clear();
        content_input.clear();
    }

    public void print() {
        System.out.println("Status: PASSED");
        System.out.println("======================");
        clearTXT();
    }
}
