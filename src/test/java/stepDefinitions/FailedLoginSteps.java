package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import methods.*;
import utilities.DriverManager;


public class FailedLoginSteps {
    // `functions` sınıfı örneği oluşturuyoruz.
    private final functions helper = new functions();
    private final ClickHelper clickHelper = new ClickHelper();
    private final VisibleHelper visibleHelper = new VisibleHelper();
    private final WaitHelper waitHelper = new WaitHelper();
    private final WriteHelper writeHelper = new WriteHelper();

    @When("Open Catchylabs")
    public void openCatchylabs() {
        // Catchylabs anasayfasını açar.
        DriverManager.getDriver().get("https://catchylabs-webclient.testinium.com/");
        // Loglama
        helper.logAction("openCatchylabs", "Catchylabs ana sayfası açıldı.");
    }
    @And("Login Username {string}")
    public void loginUsername(String keyword) {
        // Arama kutusunu bekler ve metni girer.
        waitHelper.waitForElement("loginUsernamePlaceHolder", 10);
        clickHelper.clickElement("loginUsernamePlaceHolder");
        writeHelper.writeToElement("loginUsernamePlaceHolder", keyword);
        // Loglama
        helper.logAction("Username", "Arama işlemi gerçekleştirildi. Kelime: " + keyword);
    }
    @And("Login Password {string}")
    public void loginPassword(String keyword) {
        // Arama kutusunu bekler ve metni girer.
        waitHelper.waitForElement("loginPasswordPlaceHolder", 10);
        clickHelper.clickElement("loginPasswordPlaceHolder");
        writeHelper.writeToElement("loginPasswordPlaceHolder", keyword);
        // Loglama
        helper.logAction("Password", "Arama işlemi gerçekleştirildi. Kelime: " + keyword);
    }
    @And("Click Submit Button")
    public void clickSubmitButton(){
        clickHelper.clickElement("submitButton");
        helper.logAction("Submit Button", "Submit Butonuna tıklandı.");
    }
    @Then("Check Warning Box")
    public void checkWarningBox(){
        visibleHelper.isElementVisible("checkBox");
        helper.compareTextbox("checkBox","Username or Password Invalid!");
        helper.logAction("checekBox","Warning box kontrol edildi ve istenileni karşılıyor.");
    }
}