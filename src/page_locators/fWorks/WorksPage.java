package page_locators.fWorks;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import page_locators.SignInPage;

public class WorksPage {

    public String[] tagline = {
            "Nhập tiêu đề của công việc!",
            "Chọn người tham gia của công việc!",
            "Nhập thời gian thực hiện của công việc!",
            "Chưa chọn nhóm của công việc!",
            "Đã tạo công việc thành công!"
    };

    WebDriver driver;

    @FindBy(xpath = "//a[@class='has-text-black'][contains(.,'Công việc')]")
    private WebElement btnWorkPage;

    @FindBy(id = "plan_bubble")
    private WebElement ddlbtnCreate;

    @FindBy(tagName = "textarea")
    private WebElement txa;

    // Element create group works page
    @FindBy(xpath = "//a[@class='button is-small is-rounded is-info']")
    private WebElement btnCreateGroupWorks;

    @FindBy(css = "[placeholder='Nhập tiêu đề nhóm công việc...']")
    private WebElement txttitleGroup;

    @FindBy(xpath = "//a[@title='Cập nhật']")
    private WebElement btnSaveGroup;

    // Element create works page
    @FindBy(xpath = "//a[@class='button is-small is-rounded is-success']")
    private WebElement btnCreateWorks;

    @FindBy(xpath = "//input[@id='task_name']")
    public WebElement txttitleWorks;

    @FindBy(xpath = "//div[@class='avatar_list']/a[.='add']")
    private WebElement btnAddMember;

    @FindBy(xpath = "//i[.='remove_circle_outline']")
    private WebElement btnReleaseMember;

    @FindBy(xpath = "//div[@class='dropdown-content px-3 has-text-left']/div[@class='buttons is-right']/a[1]")
    private WebElement btnDoneMember;

    @FindBy(xpath = "//a[.='add_circle_outline']")
    private WebElement btnAddUser;

    @FindBy(xpath = "//li[@class='column is-10 is-size-7 p-4']/div[3]//span[.='dd/mm/yyyy']")
    private WebElement btnDayWorks;

    // Chọn ngày bắt đầu công việc là ngày 23, có thể thay đổi ở phần contains
    @FindBy(xpath = "//li[@class='column is-10 is-size-7 p-4']/div[3]//td[contains(.,'20')]")
    private WebElement clickDay;

    @FindBy(xpath = "//li[@class='column is-10 is-size-7 p-4']/div[3]//button[@class='applyBtn button is-small is-link']")
    private WebElement btnApplyDay;

    @FindBy(xpath = "//div[@class='buttons is-right']/a[1]")
    private WebElement btnDoneCreateWorks;

    @FindBy(xpath = "//span[.='Chọn nhóm công việc']")
    private WebElement ddlGroupWorks;

    @FindBy(linkText = "Thực thi automation đạt chuẩn")
    private WebElement choseGroupWorks;

    // Element details 1 công việc
    @FindBy(linkText = "Lập plan để thực thi")
    private WebElement choseWorks;

    @FindBy(xpath = "//a[contains(.,'Công việc phụ')]")
    private WebElement btnSubWorks;

    @FindBy(xpath = "//div[@class='py-2']/a[1]")
    private WebElement btnAddSubWorks;

    @FindBy(css = "[placeholder='Nhập tiêu đề công việc']")
    private WebElement txttitleSubWorks;

    @FindBy(xpath = "//ul[@class='sub_task columns is-vcentered is-multiline is-variable is-size-7 mb-0 is-mobile is-0']//a[.='add']")
    private WebElement btnAddMemberSubWorks;

    @FindBy(xpath = "//i[.='add_circle_outline']")
    private WebElement btnAddUserSubWorks;

    @FindBy(xpath = "//div[@class='buttons is-right']/a[1]")
    private WebElement btnDoneMemberSubWorks;

    @FindBy(xpath = "//div[@class='buttons is-right mt-2']/a[1]")
    private WebElement btnSaveSubWorks;

    @FindBy(xpath = "//a[.='calendar_todayChọn ngày']")
    private WebElement btnChoseDaySubWorks;

    @FindBy(xpath = "//div[@class='daterangepicker show-calendar opensleft']/div[@class='drp-calendar left ']//td[contains(.,'20')]")
    private WebElement clickdaySubWorks;

    @FindBy(xpath = "//div[@class='daterangepicker show-calendar opensleft']//button[@class='applyBtn button is-small is-link']")
    private WebElement btnApplyDaySubWorks;

    @FindBy(xpath = "//a[@class='delete']")
    public WebElement btnDeleteTagline;

    // Elements verify create subworks
    @FindBy(how = How.CSS, using = ".item_name.has-text-info")
    private List<WebElement> lstSubworks;

    // Elements todolist link
    @FindBy(xpath = "//li[@class='column is-2 p-4']//a[contains(.,'Todolist liên kết')]")
    private WebElement btnTodolistlink;

    @FindBy(xpath = "//a[.='add_box']")
    private WebElement btnCreateTodolistLink;

    @FindBy(xpath = "//input[@id='task_todo']")
    public WebElement txtTitleTodolist;

    @FindBy(css = ".mr-3")
    private WebElement btnSaveTodolist;

    // Elements Comments
    @FindBy(xpath = "//a[contains(text(),'Bình luận')]")
    private WebElement btnComments;

    @FindBy(xpath = "//a[@class='icon is-right has-text-link']")
    private WebElement btnSendComments;

    @FindBy(css = ".has-text-grey.pl-5.ml-2.mt-1")
    public WebElement resultComments;

    // Element History
    @FindBy(xpath = "//a[contains(text(),'Lịch sử cập nhật')]")
    private WebElement historyWorks;

    public WorksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private SignInPage index = new SignInPage(driver);

    public void nvgToFormCreate_GourpWorks() {
        try {
            btnWorkPage.click();
            index.waitForPageLoaded();
            if (btnCreateGroupWorks.isDisplayed()) {
                btnCreateGroupWorks.click();
                Thread.sleep(1000);
            } else {
                ddlbtnCreate.click();
                Thread.sleep(500);
                btnCreateGroupWorks.click();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void nvgToFormCreate_Works() {
        try {
            btnWorkPage.click();
            index.waitForPageLoaded();
            if (btnCreateWorks.isDisplayed()) {
                btnCreateWorks.click();
                Thread.sleep(1000);
            } else {
                ddlbtnCreate.click();
                Thread.sleep(500);
                btnCreateWorks.click();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CreateGourpWorks(String title) {
        try {
            txttitleGroup.sendKeys(title);
            Thread.sleep(500);
            btnSaveGroup.click();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CreateWorks(String title) {
        try {
            txttitleWorks.sendKeys(title);
            Thread.sleep(500);
            btnDoneCreateWorks.click();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearMember() {
        try {
            btnAddMember.click();
            Thread.sleep(500);
            btnReleaseMember.click();
            Thread.sleep(500);
            btnDoneMember.click();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMember() {
        try {
            btnAddMember.click();
            Thread.sleep(500);
            btnAddUser.click();
            Thread.sleep(500);
            btnDoneMember.click();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choseDaysWorks() {
        try {
            btnDayWorks.click();
            Thread.sleep(500);
            clickDay.click();
            Thread.sleep(500);
            btnApplyDay.click();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choseGroupWorks() {
        try {
            ddlGroupWorks.click();
            Thread.sleep(500);
            choseGroupWorks.click();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void nvgToSubWorks() {
        try {
            btnWorkPage.click();
            index.waitForPageLoaded();
            choseWorks.click();
            index.waitForPageLoaded();
            btnSubWorks.click();
            Thread.sleep(1000);
            btnAddSubWorks.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CreateSubWorks(String title, String desc) {
        try {
            txttitleSubWorks.sendKeys(title);
            txa.sendKeys(desc);
            Thread.sleep(500);
            btnSaveSubWorks.click();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearDataTestSubWorks() {
        try {
            txttitleSubWorks.clear();
            txa.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choseDaySubWorks() {
        try {
            btnChoseDaySubWorks.click();
            Thread.sleep(500);
            clickdaySubWorks.click();
            Thread.sleep(500);
            clickdaySubWorks.click();
            Thread.sleep(500);
            btnApplyDaySubWorks.click();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMemberSubWorks() {
        try {
            btnAddMemberSubWorks.click();
            Thread.sleep(500);
            btnAddUserSubWorks.click();
            Thread.sleep(500);
            btnDoneMemberSubWorks.click();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyCreate_Subwork(String condition) {
        if (lstSubworks.size() > 0) {
            for (WebElement row : lstSubworks) {
                String nameSubworks = row.getText().strip();
                if (nameSubworks.equals(condition)) {
                    System.out.println(nameSubworks);
                    break;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void nvgToTodolistLink() {
        try {
            btnWorkPage.click();
            index.waitForPageLoaded();
            choseWorks.click();
            index.waitForPageLoaded();
            btnTodolistlink.click();
            Thread.sleep(1000);
            btnCreateTodolistLink.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CreateTodolistLink(String title) {
        try {
            txtTitleTodolist.sendKeys(title);
            Thread.sleep(500);
            btnSaveTodolist.click();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CreateComments(String title) {
        try {
            txa.sendKeys(title);
            Thread.sleep(500);
            btnSendComments.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void nvgToComments() {
        try {
            btnWorkPage.click();
            index.waitForPageLoaded();
            choseWorks.click();
            index.waitForPageLoaded();
            btnComments.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyComments(String condition) {
        try {
            String nameResult = resultComments.getText().strip();
            return nameResult.equals(condition);
        } catch (Exception e) {
            return false;
        }
    }

    public void nvgToHistoryWorks() {
        try {
            btnWorkPage.click();
            index.waitForPageLoaded();
            choseWorks.click();
            index.waitForPageLoaded();
            historyWorks.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
