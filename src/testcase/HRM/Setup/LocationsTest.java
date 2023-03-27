package testcase.HRM.Setup;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page_locators.SignInPage;
import page_locators.HRM.HRM_SetupPage;
import setupbase.baseSetup;

public class LocationsTest {
    public static void main(String[] args) {
        try {

            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("HRM-Setup-Locations");

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage index = new SignInPage(driver);
            HRM_SetupPage locations = new HRM_SetupPage(driver);

            index.login();

            locations.navigationHRM_Setup_Locations();

            if (index.verifyTitle(index.titleHRM_Setup_locations)) {

                locations.OpenModal(index.btn_isLink);

                for (int i = 1; i < 7; i++) {
                    System.out.println("=========================");
                    System.out.println("Testcase: " + excel.getCellData("TCID", i));

                    locations.CleartextlocationForm();

                    locations.setTextSetup_Locations(excel.getCellData("title", i), excel.getCellData("latitude", i),
                            excel.getCellData("longitude", i), excel.getCellData("scope", i));
                    index.btn_isLink_Right.click();
                    Thread.sleep(500);

                    Boolean passed = false;
                    String noti = index.messgaeError_tagline();

                    for (int j = 0; j < locations.taglineLocation.length; j++) {
                        if (noti.equals(locations.taglineLocation[j])) {
                            passed = true;
                            index.passed();
                            if (j == 4) {
                                locations.Select_locationsCompany();
                                index.btn_Deltagline.click();
                            }
                            break;
                        }
                    }
                    if (!passed)
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
