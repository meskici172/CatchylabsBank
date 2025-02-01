package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import methods.*;
import utilities.DriverManager;

public class SuccessLoginSteps {
    // `functions` sınıfı örneği oluşturuyoruz.
    private final functions helper = new functions();
    private final ClickHelper clickHelper = new ClickHelper();
    private final VisibleHelper visibleHelper = new VisibleHelper();
    private final WaitHelper waitHelper = new WaitHelper();
    private final WriteHelper writeHelper = new WriteHelper();
    @When("Open Catchylabs For Login")
    public void openCatchylabsForLogin() {
        // Catchylabs anasayfasını açar.
        DriverManager.getDriver().get("https://catchylabs-webclient.testinium.com/");
        // Loglama
        helper.logAction("openCatchylabs", "Catchylabs ana sayfası açıldı.");
    }
    @And("Login Username {string} For Login")
    public void loginUsernameForLogin(String keyword) {
        // Arama kutusunu bekler ve metni girer.
        waitHelper.waitForElement("loginUsernamePlaceHolder", 10);
        clickHelper.clickElement("loginUsernamePlaceHolder");
        writeHelper.writeToElement("loginUsernamePlaceHolder", keyword);
        // Loglama
        helper.logAction("Username", "Arama işlemi gerçekleştirildi. Kelime: " + keyword);
    }
    @And("Login Password {string} For Login")
    public void loginPasswordForLogin(String keyword) {
        // Arama kutusunu bekler ve metni girer.
        waitHelper.waitForElement("loginPasswordPlaceHolder", 10);
        clickHelper.clickElement("loginPasswordPlaceHolder");
        writeHelper.writeToElement("loginPasswordPlaceHolder", keyword);
        // Loglama
        helper.logAction("Password", "Arama işlemi gerçekleştirildi. Kelime: " + keyword);
    }
    @And("Click Submit Button For Login")
    public void clickSubmitButtonForLogin(){
        clickHelper.clickElement("submitButton");
        helper.logAction("Submit Button", "Submit Butonuna tıklandı.");
    }
    @And("Check Info")
    public void checkInfo(){
        waitHelper.waitForElement("challengeName",5);
        helper.compareTextbox("challengeName","Challenge name: QA ve/veya QE Uygulaması 28.01.25");
        helper.compareTextbox("startTime","Start time: 28-01-2025 11:20:42");
        helper.compareTextbox("endTime","End time: 02-02-2025 23:59:42");
        helper.compareTextbox("managerName","Manager name: QAManager");
        helper.compareTextbox("companyName","Company name: Testinium");
    }
    @Then("Before Click Logout Button Click Open Button")
    public void clickLogoutButton(){
        clickHelper.clickElementWithHighlight("openMoneyTransferBtn");
        helper.logAction("Open Money Button", "Open Money Butonuna tıklandı.");
        clickHelper.clickElementWithHighlight("backBtn");
        helper.logAction("Back Button", "Back Butonuna tıklandı.");
        waitHelper.waitForElement("logout",5);
        clickHelper.clickElementWithHighlight("logout");
        helper.logAction("Logout Button", "Logout Butonuna tıklandı.");
    }
}
