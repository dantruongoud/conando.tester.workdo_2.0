package testcase.Setting.Gift_exchange.category;

import org.openqa.selenium.WebDriver;

import page_locators.SignInPage;
import page_locators.Setting.Gift_exchange.category.categoryPage;
import page_locators.Setting.Gift_exchange.store.CreateProductPage;
import setupbase.baseSetup;

public class categoryTest {
    int testcase;
    String cate;

    public categoryTest(int testcase, String cate) {
        this.testcase = testcase;
        this.cate = cate;
    }

    public static void main(String[] args) {
        try {
            categoryTest[] data = {
                    new categoryTest(1, "Category"),
                    new categoryTest(2, ""),
                    new categoryTest(3, "Category")
            };
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            SignInPage index = new SignInPage(driver);
            CreateProductPage create = new CreateProductPage(driver);
            categoryPage category = new categoryPage(driver);

            index.login();
            index.navigation();
            create.navigation_exchange();

            category.nvgCategory.click();
            index.waitForPageLoaded();

            if (index.verifyTitle(index.titlePageStore)) {

                index.Button_Component();

                for (int i = 0; i < data.length; i++) {
                    category.txtCate.clear();

                    System.out.println("=========================");
                    System.out.println("Testcase: " + data[i].testcase);

                    category.CreateCate(data[i].cate);

                    Boolean passed = false;
                    String noti = index.messgaeError_tagline();
                    for (int j = 0; j < category.tagline.length; j++) {
                        if (noti.equals(category.tagline[j])) {
                            passed = true;
                            index.passed();
                            if (j == 1)
                                index.uploadImage("//div[@class='field']//div[@class='control is-expanded']", "xpath");
                            break;
                        } else if (noti.equals(category.tagline[2])) {
                            passed = true;
                            index.passed();
                            break;
                        }
                    }
                    if (!passed)
                        index.passed();
                    // switch (noti) {
                    // case "Chưa nhập tên danh mục!":
                    // index.passed();
                    // break;
                    // case "Chưa chọn hình ảnh danh mục!":
                    // index.passed();
                    // index.uploadImage("//div[@class='field']//div[@class='control is-expanded']",
                    // "xpath");
                    // break;
                    // case "Đã tạo danh mục sản phẩm mới.":
                    // index.passed();
                    // break;
                    // default:
                    // index.failed();
                    // break;
                    // }
                }

            } else {
                index.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}