package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import methods.*;
import org.json.JSONObject;

import java.math.BigDecimal;

public class AddMoneySteps {
    // `functions` sınıfı örneği oluşturuyoruz.
    private final functions helper = new functions();
    private final ClickHelper clickHelper = new ClickHelper();
    private final VisibleHelper visibleHelper = new VisibleHelper();
    private final WaitHelper waitHelper = new WaitHelper();
    private final WriteHelper writeHelper = new WriteHelper();

    @And("Click Add Money Button")
    public void clickAddMoneyButton() {
        waitHelper.waitForTwoSeconds();
        clickHelper.clickElementWithHighlight("addMoneyButton");
        helper.logAction("addMoneyButton", "addMoneyButton Tıklama Tamamlandı.");
    }

    @And("Write Card Number {string}")
    public void writeCardNumber(String keyword) {
        writeHelper.writeToElement("cardNumber", keyword);
        helper.logAction("cardNumber","cardNumber Yazma işlemi Tamamlandı");

    }

    @And("Write Card Holder {string}")
    public void writeCardHolder(String keyword) {
        writeHelper.writeToElement("cardHolder", keyword);
        helper.logAction("cardHolder","cardHolder Yazma işlemi Tamamlandı");

    }

    @And("Write Card Expire Date {string}")
    public void writeCardExpireDate(String keyword) {
        writeHelper.writeToElement("cardDate", keyword);
        helper.logAction("cardDate","cardDate Yazma işlemi Tamamlandı");

    }

    @And("Write Card Cvv {string}")
    public void writeCardCvv(String keyword) {
        writeHelper.writeToElement("cardCvv", keyword);
        helper.logAction("Cvv","Cvv Yazma işlemi Tamamlandı");
    }

    @And("Write Card Amount {string}")
    public void writeCardAmount(String keyword) {
        writeHelper.writeToElement("cardAmount", keyword);
        helper.logAction("cardAmount","cardAmount Yazma işlemi Tamamlandı");
        waitHelper.waitForTwoSeconds();
    }

    @And("Click Add Button")
    public void clickAddButton() {
        waitHelper.waitForTwoSeconds();
        clickHelper.clickElement("addButton");
        helper.logAction("addButton", "addMoneyButton Tıklama Tamamlandı.");
    }

    @And("Check Card Number")
    public void checkCardNumber() {
        helper.compareTextbox("cardNumberRequired","Wrong Card Number");
        helper.deletePlaceholder("cardNumber");
    }
    @And("Check Card Number For Blank")
    public void checkCardNumberForBlank() {
        helper.compareTextbox("cardHolderRequired","Required");
        helper.deletePlaceholder("cardNumber");
    }

    @And("Check Card Holder")
    public void checkCardHolder() {
        helper.compareTextbox("cardHolderRequired","Too Short!");
        helper.deletePlaceholder("cardHolder");
    }

    @And("Check Card Holder For Blank")
    public void checkCardHolderForBlank() {
        helper.compareTextbox("cardHolderRequired","Required");
        helper.deletePlaceholder("cardHolder");
    }

    @And("Check Expire Date")
    public void checkExpireDate() {
        helper.compareTextbox("expiredateRequired","Wrong date. Please give a correct date");
        helper.deletePlaceholder("cardDate");
    }

    @And("Check Expire Date For Blank")
    public void checkExpireDateForBlank() {
        helper.compareTextbox("expiredateRequired","Required");
        helper.deletePlaceholder("cardDate");
    }

    @And("Check Wrong Cvv")
    public void checkWrongCvv() {
        helper.compareTextbox("cardCvvRequired","Too short");
        helper.deletePlaceholder("cardCvv");
    }

    @And("Check Cvv For Blank")
    public void checkCvvForBlank() {
        helper.compareTextbox("cvvRequired","Required");
        helper.deletePlaceholder("cardCvv");
    }

    @And("Check Card Amount For Blank")
    public void checkCardAmountForBlank() {
        helper.compareTextbox("amountRequired","Required");
    }

    @And("Check Card Amount For Negative")
    public void checkCardAmountForNegative() {
        helper.compareTextbox("amountRequired","Can not be Negative Numbers");
    }

    @And("Check Card Amount For Too Much Amount")
    public void checkCardAmountForTooMuchAmount() {
        helper.compareTextbox("amountRequired","This is not valid numbers");
    }




}
