package page_locators.HRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import page_locators.SignInPage;

public class HRM_SetupPage {

    WebDriver driver;

    public String[] taglineLocation = {
            "Bạn chưa nhập tiêu đề địa điểm!",
            "Bạn chưa nhập vĩ độ!",
            "Bạn chưa nhập kinh độ!",
            "Bạn chưa nhập địa điểm!",
            "Bạn chưa chọn công ty áp dụng!",
    };

    public String[] taglineWorkShift = {
            "Bạn chưa nhập tiêu đề địa điểm!",
            "Bạn chưa chọn giờ bắt đầu!",
            "Bạn chưa nhập giờ kết thúc!",
            "Bạn chưa nhập số công!",
    };

    public String taglineUserShift = "Đã phân ca thành công cho 1 tài khoản.";

    @FindBy(xpath = "//span[normalize-space()='HRM']")
    private WebElement nav_HRM;

    @FindBy(xpath = "//li[contains(@class,'is-active')]//ul//li//span[contains(text(),'Thiết lập')]")
    private WebElement nav_HRM_Setup;

    @FindBy(xpath = "//a[@href='hrm/setup/options']")
    private WebElement nav_HRM_Setup_Options;

    @FindBy(xpath = "//a[@href='hrm/setup/locations']")
    private WebElement nav_HRM_Setup_Locations;

    @FindBy(xpath = "//a[@href='hrm/setup/work-shift']")
    private WebElement nav_HRM_Setup_Work_shift;

    @FindBy(xpath = "//a[@href='hrm/setup/user-shift']")
    private WebElement nav_HRM_Setup_User_shift;

    @FindBy(xpath = "//section[@class='modal is-active']")
    private WebElement modalActive;

    @FindBy(className = "modal-card-title")
    private WebElement modalNameTitle;

    @FindBy(xpath = "//input[@placeholder='Tên nhân viên...']")
    private WebElement InputSearchMember_table;

    // Elements page Options
    @FindBy(xpath = "//a[.='Công ty']")
    public WebElement Options_Company;

    @FindBy(id = "option_name")
    private WebElement Options_txtNameOptions;

    @FindBy(xpath = "//a[@class='button is-white has-text-link']")
    private WebElement Options_btnAddOptions;

    @FindBy(xpath = "//select[@class='is-family-code']")
    private WebElement Options_selectDepartment;

    @FindBy(xpath = "//div[@class='avatar_list']")
    private WebElement Options_btnAddMember;

    @FindBy(id = "search_member")
    private WebElement Options_txtSearch;

    @FindBy(xpath = "(//i[contains(text(),'add_circle_outline')])[1]")
    private WebElement Options_ChoseMember;

    @FindBy(xpath = "//span[contains(text(),'Hoàn tất')]")
    private WebElement Options_btnDoneMember;

    @FindBy(xpath = "//li[@class='column has-text-weight-medium']")
    private WebElement DisplayedAddMemberSuccess;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'plk-dd-dropzone')]//div[contains(@class,'plk-dd-draggable')]")
    private List<WebElement> Options_List;

    // Elements page locations
    @FindBy(xpath = "//ul[@class='columns is-multiline is-variable is-2']/li[1]//input[@class='input']")
    private WebElement location_txtTitle;

    @FindBy(xpath = "//ul[@class='columns is-multiline is-variable is-2']/li[2]//input[@class='input']")
    private WebElement location_txtLatitude;

    @FindBy(xpath = "//ul[@class='columns is-multiline is-variable is-2']/li[3]//input[@class='input']")
    private WebElement location_txtLongitude;

    @FindBy(xpath = "//ul[@class='columns is-multiline is-variable is-2']/li[4]//input[@class='input']")
    private WebElement location_txtScope;

    @FindBy(xpath = "//div[@class='select is-fullwidth']//select")
    private WebElement locations_SelectCompany;

    // Elements Work-shift
    @FindBy(xpath = "//input[@type='text']")
    private WebElement workShift_txtNameWorkShift;

    @FindBy(xpath = "//input[@type='number']")
    private WebElement workShift_txttxtNumberWorkShift;

    @FindBy(xpath = "//ul[@class='columns is-multiline is-variable is-2']/li[2]//select[1]")
    private WebElement workShift_timeStart;

    @FindBy(xpath = "//ul[@class='columns is-multiline is-variable is-2']/li[3]//select[1]")
    private WebElement workShift_timeEnd;

    // Element User-Shift
    @FindBy(how = How.XPATH, using = "//li[@class='column is-half']")
    private List<WebElement> listSelect_UserShift;

    public HRM_SetupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private SignInPage index = new SignInPage(driver);

    // Setup User Shift
    public void Select_UserShift(String s, String c) {
        try {
            for (int i = 0; i < 22; i++) {
                int a = i + 1;
                String element_Select = "//ul[@class='columns is-multiline is-variable is-2']/li[" + a + "]//select[1]";
                switch (a) {
                    case 2, 5, 8, 11, 14, 17:
                        WebElement element = driver.findElement(By.xpath(element_Select));
                        Select select = new Select(element);
                        select.selectByVisibleText(s);
                        break;
                    case 3, 6, 9, 12, 15:
                        element = driver.findElement(By.xpath(element_Select));
                        select = new Select(element);
                        select.selectByVisibleText(c);
                        break;
                    case 1, 4, 7, 10, 13, 16, 19:
                        break;
                }
            }
            index.btn_isLink_Right.click();
            String noti = index.messgaeError_tagline();
            if (noti.equals(taglineUserShift)) {
                index.passed();
            } else {
                index.failed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choseMember_UserShift() {
        try {
            SearchMember_Table("hải");

            List<WebElement> tr_List = driver.findElements(By.xpath("//tbody/tr"));
            for (int i = 0; i < tr_List.size(); i++) {
                List<WebElement> td_List = tr_List.get(i).findElements(By.tagName("td"));
                String nameUser = td_List.get(1).getText().strip();
                if (nameUser.equals("Nguyễn Hải")) {
                    WebElement aTag = td_List.get(0).findElement(By.tagName("a"));
                    OpenModal(aTag);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Setup Work Shift
    public void setTextSetup_WorkShift(String name, String number) {
        try {
            workShift_txtNameWorkShift.sendKeys(name);
            workShift_txttxtNumberWorkShift.sendKeys(number);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CleartextworkshiftForm() {
        try {
            workShift_txtNameWorkShift.clear();
            workShift_txttxtNumberWorkShift.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SelectTimeStart_WorkShift() {
        try {
            Select time = new Select(workShift_timeStart);
            time.selectByValue("07:30");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SelectTimeEnd_WorkShift() {
        try {
            Select time = new Select(workShift_timeEnd);
            time.selectByValue("17:30");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyCreate_WorkShift(String a) {
        try {
            String tdname = "";
            List<WebElement> trlist = driver.findElements(By.className("has-text-dark"));
            for (int i = 0; i < trlist.size(); i++) {
                tdname = trlist.get(i).getText().strip();
                System.out.println(tdname);
            }
            return tdname.equals(a);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Setup Locations
    public void setTextSetup_Locations(String title, String latitude, String longitude, String scope) {
        try {
            location_txtTitle.sendKeys(title);
            location_txtLatitude.sendKeys(latitude);
            location_txtLongitude.sendKeys(longitude);
            location_txtScope.sendKeys(scope);

            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CleartextlocationForm() {
        try {
            location_txtTitle.clear();
            location_txtLatitude.clear();
            location_txtLongitude.clear();
            location_txtScope.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Select_locationsCompany() {
        try {
            Select choseCompany = new Select(locations_SelectCompany);
            choseCompany.selectByVisibleText("department");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Setup Options
    public boolean verifyCreateOptions(String condition) {
        try {
            String name = "";
            for (int i = 0; i < Options_List.size(); i++) {
                List<WebElement> nameListOptions = Options_List.get(i).findElements(By.tagName("li"));
                System.out.println(nameListOptions.size());
                if (nameListOptions.size() == 4) {
                    WebElement litag1 = nameListOptions.get(0).findElement(By.xpath("//span[2]"));
                    name = litag1.getText().strip();
                    if (name.equals(condition)) {
                        System.out.println(name);
                    }
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void choseMember() {
        try {
            Options_btnAddMember.click();
            index.waitForElementToBeClickable(driver, Options_btnAddMember, 2);

            Options_txtSearch.sendKeys("truong");
            Thread.sleep(1000);

            Options_ChoseMember.click();
            Thread.sleep(500);

            index.waitForElementVisible(driver, DisplayedAddMemberSuccess, 2);

            Options_btnDoneMember.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigationHRM_Setup_WorkShift() {
        try {
            nav_HRM.click();
            index.waitForElementToBeClickable(driver, nav_HRM, 2);

            nav_HRM_Setup.click();
            index.waitForElementToBeClickable(driver, nav_HRM_Setup, 2);

            nav_HRM_Setup_Work_shift.click();
            index.waitForElementToBeClickable(driver, nav_HRM_Setup_Work_shift, 2);

            index.waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigationHRM_Setup_Options() {
        try {
            nav_HRM.click();
            index.waitForElementToBeClickable(driver, nav_HRM, 2);

            nav_HRM_Setup.click();
            index.waitForElementToBeClickable(driver, nav_HRM_Setup, 2);

            nav_HRM_Setup_Options.click();
            index.waitForElementToBeClickable(driver, nav_HRM_Setup_Options, 2);

            index.waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigationHRM_Setup_UserShift() {
        try {
            nav_HRM.click();
            index.waitForElementToBeClickable(driver, nav_HRM, 2);

            nav_HRM_Setup.click();
            index.waitForElementToBeClickable(driver, nav_HRM_Setup, 2);

            nav_HRM_Setup_User_shift.click();
            index.waitForElementToBeClickable(driver, nav_HRM_Setup_User_shift, 2);

            index.waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choseDepartment() {
        try {
            Select choseDepartment = new Select(Options_selectDepartment);
            choseDepartment.selectByVisibleText("└─ department");

            Thread.sleep(500);
            choseMember();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTextSetup_Options(String name) {
        try {
            Options_txtNameOptions.sendKeys(name);

            Options_btnAddOptions.click();
            index.waitForElementToBeClickable(driver, Options_btnAddOptions, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigationHRM_Setup_Locations() {
        try {
            nav_HRM.click();
            index.waitForElementToBeClickable(driver, nav_HRM, 2);

            nav_HRM_Setup.click();
            index.waitForElementToBeClickable(driver, nav_HRM_Setup, 2);

            nav_HRM_Setup_Locations.click();
            index.waitForElementToBeClickable(driver, nav_HRM_Setup_Locations, 2);

            index.waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void OpenModal(WebElement element) {
        try {
            element.click();
            index.waitForElementToBeClickable(driver, element, 2);

            index.waitForElementVisible(driver, modalActive, 2);

            System.out.println("Open Modal success, Title Modal: " + modalNameTitle.getText().strip());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SearchMember_Table(String condition) {
        try {

            InputSearchMember_table.sendKeys(condition);

            Robot rb = null;
            try {
                rb = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }

            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);

            index.waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
