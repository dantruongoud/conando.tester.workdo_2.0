package page_locators.fWorks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import page_locators.SignInPage;

public class PlansPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@href='work']")
    private WebElement mnuWork;

    @FindBy(xpath = "//a[@class='button is-info is-fullwidth']")
    private WebElement btnCreateWork;

    @FindBy(how = How.CSS, using = "a[class='has-text-info']")
    private List<WebElement> listWorks;

    // Element Form create Work
    @FindBy(xpath = "//input[@id='plan_name']")
    private WebElement txtTitle;

    @FindBy(xpath = "//div[@class='avatar_list']//i[@class='material-icons-outlined is-size-6']")
    private WebElement btnaddMember;

    @FindBy(xpath = "//a[.='remove_circle_outline']")
    private WebElement btnRelease;

    @FindBy(xpath = "//input[@id='search_member']")
    private WebElement txtSearchMember;

    @FindBy(xpath = "(//a[contains(@class,'icon is-small has-text-info')])[1]")
    private WebElement btnAddUser;

    @FindBy(xpath = "//div[@class='scrolly py-1']//li[3]")
    private WebElement ddlPosition;

    @FindBy(how = How.CSS, using = ".dropdown-item.py-1")
    private List<WebElement> listPosition;

    @FindBy(xpath = "//div[@class='buttons is-right']/a[1]")
    private WebElement btnDoneMember;

    @FindBy(xpath = "//span[.='dd/mm/yyyy']")
    public WebElement timeEnd;

    @FindBy(xpath = "//section[@class='modal-card-foot is-right']/a[1]")
    private WebElement btnDoneWork;

    @FindBy(tagName = "textarea")
    private WebElement txtDesc;

    // Element form edit works
    // 2 thẻ input cuar title và description dùng chung với form tạo vì nó k khác
    @FindBy(xpath = "//a[@class='icon-text has-text-link']")
    public WebElement btnEditPlans;

    @FindBy(xpath = "//a[@class='button is-link is-small']")
    private WebElement btnSave;

    // Element edit position member
    // Release btn sử dụng lại form tạo btnRelease
    // Hoàn tất btn sử dụng lại form edit btnSave
    @FindBy(css = ".has-background-white")
    private WebElement btnEditPosition;

    // Element create sticker
    @FindBy(xpath = "//input[@placeholder='Nhập tiêu đề nhãn']")
    private WebElement txtTitleSticker;

    @FindBy(xpath = "//a[@class='button is-link']")
    private WebElement btnSticker;

    // Element History
    @FindBy(how = How.CSS, using = ".item.pb-4")
    private List<WebElement> listTask;

    public String[] taglinetext = { "Kế hoạch chưa có thành viên1.", "Bạn chưa nhập1 tiêu đề kế hoạch." };

    public PlansPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    SignInPage index = new SignInPage(driver);

    public void navigationToFormCreate() {
        try {
            mnuWork.click();
            index.waitForPageLoaded();
            btnCreateWork.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearMember() {
        try {
            btnaddMember.click();
            Thread.sleep(1000);
            btnRelease.click();
            Thread.sleep(500);
            btnDoneMember.click();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMember() {
        try {
            btnaddMember.click();
            Thread.sleep(500);
            txtSearchMember.sendKeys("truong");
            Thread.sleep(1000);
            btnAddUser.click();
            Thread.sleep(500);
            ddlPosition.click();
            Thread.sleep(500);
            for (int i = 0; i < listPosition.size(); i++) {
                String position = listPosition.get(i).getText().strip();
                if (position.equals("Quản lý")) {
                    listPosition.get(i).click();
                    Thread.sleep(1000);
                    break;
                }
            }
            btnDoneMember.click();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CreateWork(String title, String desc) {
        try {
            txtTitle.sendKeys(title);
            txtDesc.sendKeys(desc);
            Thread.sleep(500);
            btnDoneWork.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearDataTest() {
        try {
            txtTitle.clear();
            txtDesc.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choseWorks() {
        try {
            for (WebElement row : listWorks) {
                String nameWorks = row.getText().strip();
                if (nameWorks.equals("fWorks: Prepare for Testing")) {
                    row.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigationToWorksDetails() {
        try {
            mnuWork.click();
            index.waitForPageLoaded();
            choseWorks();
            index.waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EditWorks(String title, String desc) {
        try {
            txtTitle.sendKeys(title);
            txtDesc.sendKeys(desc);
            Thread.sleep(1000);
            btnSave.click();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EditPosition() {
        try {
            btnEditPosition.click();
            Thread.sleep(1000);
            btnRelease.click();
            Thread.sleep(500);
            btnSave.click();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CreateSticker(String title) {
        try {
            txtTitleSticker.sendKeys(title);
            btnSticker.click();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getHistoryPlan() {
        System.out.println();
        for (int i = 0; i < listTask.size(); i++) {
            String title = listTask.get(i).getText().strip();
            System.out.println(title);
            String user_incharge = listTask.get(i).findElement(By.cssSelector(".image.is-24x24.is-rounded"))
                    .getAttribute("title");

            System.out.println(user_incharge);
            System.out.println();
        }
    }
}
