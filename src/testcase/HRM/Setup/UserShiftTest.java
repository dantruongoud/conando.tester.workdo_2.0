package testcase.HRM.Setup;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.HRM.HRM_SetupPage;
import setupbase.baseSetup;

public class UserShiftTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            
            SignInPage index = new SignInPage(driver);
            HRM_SetupPage user_shift = new HRM_SetupPage(driver);

            index.login();

            user_shift.navigationHRM_Setup_UserShift();

            if (index.verifyTitle(index.titleHRM_Setup_User_shift)) {

                user_shift.choseMember_UserShift();

                user_shift.Select_UserShift("Không có ca làm", "Không có ca làm");
            } else {
                index.error_titlePage();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
