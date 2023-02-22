package code.stepsDefinitions;

import code.pages.guru99GatewayHome;
import code.pages.guru99GatewayOrderSuccess;
import code.pages.guru99GatewayPaymentPage;

import code.utils.BrowserUtils;
import code.utils.ConfigurationsReader;
import code.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class guru99Steps extends BrowserUtils {

    guru99GatewayHome guru99GatewayHome=new guru99GatewayHome();
    guru99GatewayOrderSuccess guru99GatewayOrderSuccess=new guru99GatewayOrderSuccess();
    guru99GatewayPaymentPage guru99GatewayPaymentPage=new guru99GatewayPaymentPage();




    @Given("The user wants to go Payment Gateway Website")
    public void the_user_wants_to_go_payment_gateway_website() {
        Driver.getDriver().get(ConfigurationsReader.getProperties("demoURL"));
        setWaitTime();


    }
    @When("The user wants to buy an elephant toy")
    public void the_user_wants_to_buy_an_elephant_toy() {
        guru99GatewayHome.getQuantityDropDown("1");
        guru99GatewayHome.getBuyNow();


    }
    @Then("The user wants to provide payment Information")
    public void the_user_wants_to_provide_payment_information() {
        guru99GatewayPaymentPage.setCardNumber("5454545454545454");
        guru99GatewayPaymentPage.setMonth("10");
        guru99GatewayPaymentPage.setYear("2022");
        guru99GatewayPaymentPage.setCvv_code("369");

    }
    @Then("The user wants wo click on pay now")
    public void the_user_wants_wo_click_on_pay_now() {
        guru99GatewayPaymentPage.setPayButton();

    }
    @Then("The user wants to verify message is succesful")
    public void the_user_wants_to_verify_message_is_succesful() {
        guru99GatewayOrderSuccess.setVerificationText("Payment successfull!");

    }
    // ikinci

    @When("The user wants to buy elephant toy as {string}")
    public void the_user_wants_to_buy_elephant_toy_as(String string) { // burdaki stringler seneryoda yazdik ya verdik tum rakamlari ordan geliyor
        guru99GatewayHome.getQuantityDropDown(string);
        guru99GatewayHome.getBuyNow();

    }
    @Then("The user wants to enter Credit Card Number as {string}")
    public void the_user_wants_to_enter_credit_card_number_as(String string) {
        guru99GatewayPaymentPage.setCardNumber(string);

    }
    @Then("The user wants to enter Expriration Monts as {string}")
    public void the_user_wants_to_enter_expriration_monts_as(String string) {
        guru99GatewayPaymentPage.setMonth(string);

    }
    @Then("The user wants to enter Expriration Year as {string}")
    public void the_user_wants_to_enter_expriration_year_as(String string) {
        guru99GatewayPaymentPage.setYear(string);

    }
    @Then("The user wants to enter CVV Code as {string}")
    public void the_user_wants_to_enter_cvv_code_as(String string) {
        guru99GatewayPaymentPage.setCvv_code(string);

    }

    @Then("The user wants to verify message as {string}")
    public void the_user_wants_to_verify_message_as(String string) {
       guru99GatewayOrderSuccess.setVerificationText(string);

    }
    @Then("The user wants to provide enter payment information as following")
    public void the_user_wants_to_provide_enter_payment_information_as_following(Map<String,String> dataTable) {
        guru99GatewayPaymentPage.setCardNumber(dataTable.get("CNumber"));
        guru99GatewayPaymentPage.setMonth(dataTable.get("EMonth"));
        guru99GatewayPaymentPage.setYear(dataTable.get("EYear"));
        guru99GatewayPaymentPage.setCvv_code(dataTable.get("CvvCode"));

    }

    @When("The user wants to buy elephant toy as following quantity")
    public void the_user_wants_to_buy_elephant_toy_as_following_quantity(List<List<String>> dataTable) {
        guru99GatewayHome.getQuantityDropDown(dataTable.get(0).get(0));
        guru99GatewayHome.getBuyNow();


    }
    @Then("The user wants to provide enter payment information as following as a List")
    public void the_user_wants_to_provide_enter_payment_information_as_following_as_a_list(List<List<String>> dataTable)  {
      guru99GatewayPaymentPage.setCardNumber(dataTable.get(0).get(0));
      guru99GatewayPaymentPage.setMonth(dataTable.get(0).get(1));
      guru99GatewayPaymentPage.setYear(dataTable.get(0).get(2));
      guru99GatewayPaymentPage.setCvv_code(dataTable.get(0).get(3));
    }





}
