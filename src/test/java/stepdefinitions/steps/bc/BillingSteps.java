package stepdefinitions.steps.bc;

import actions.bc.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class BillingSteps {
    SearchAccountPolicy searchAccountPolicy = new SearchAccountPolicy();
    NegativeWriteOff negativeWriteoff = new NegativeWriteOff();
    CheckProducerCode checkProducerCode = new CheckProducerCode();
    CheckProducer checkProducer = new CheckProducer();
    NewActivity newActivity = new NewActivity();
    NewDisbursement newDisbursement = new NewDisbursement();
    NewPayment_WithDistribution newpWd = new NewPayment_WithDistribution();
    SearchAccountPolicy searchAcc = new SearchAccountPolicy();
    NewPayment_WithoutDistribution newpWithoutd = new NewPayment_WithoutDistribution();
    NewTroubleTicket newTroubleTicket = new NewTroubleTicket();
    Payment_Suspense paysusp = new Payment_Suspense();
    PaymentTransfer paymentTransfer = new PaymentTransfer();
    RecapturePayment recapturePayment = new RecapturePayment();
    ReversalNegativeWriteOff revWriteOff = new ReversalNegativeWriteOff();
    ReversePayment reversePay = new ReversePayment();
    ReverseWriteOff reverseWriteOff = new ReverseWriteOff();
    WriteOff writeOff = new WriteOff();

    public BillingSteps() throws IOException, ParseException {
    }

    @When("^User searches for a policy$")
    public void userSearchesForPolicy() throws Exception {
        searchAccountPolicy.searchPolicy();
    }

    @Then("^policy should be retrieved successfully$")
    public void userVerifiesForPolicy() throws Exception {
        searchAccountPolicy.verifySearchedPolicy();
    }

    @Then("User searches for a account")
    public void searchAccount() throws IOException, ParseException {
        searchAccountPolicy.searchAccount();
    }

    @Then("User creates a negative write-off")
    public void NegWriteOff() throws IOException, ParseException {
        negativeWriteoff.createNegWriteOff();

    }

    @When("User searches for producer code")
    public void searchProducerCode() throws IOException, ParseException{
        checkProducerCode.searchProducerCode();
    }

    @Then("producer code is retrived and validated successfully")
    public void UserVerifyProducerCode() throws IOException, ParseException {
        checkProducerCode.verifyProducerCode();
    }

    @When("User searches for producer")
    public void searchProducerName() throws IOException, ParseException{
        checkProducer.searchProducers();
    }

    @Then("producer is retrived and validated successfully")
    public void verifyProduerName() throws IOException, ParseException{
        checkProducer.verifyProduerName();
    }

    @Then("User creates a new activity")
    public void CreateActivity() throws IOException, ParseException {
        newActivity.createActivity();
    }

    @Then("activity is created successfully")
    public void ValidateActivity() throws IOException, ParseException {
        newActivity.validatecreatedActivity();
    }

    @Then("User creates a new disbursement")
    public void CreateDisbursement() throws IOException, ParseException {
        newDisbursement.createDisbursement();
    }

    @Then("Validate the disbursement created successfully")
    public void ValidateDisbursement() throws IOException, ParseException {
        newDisbursement.validateCreatedDisbursement();
    }

    @Then("User makes direct bill payment with distribution")
    public void CreateNewPaymentWd() throws IOException, ParseException, InterruptedException {
        searchAcc.searchAccount();
        newpWd.CreateNewPayment();
    }

    @Then("User makes direct bill payment without distribution")
    public void CreateNewPaymentWithoutd() throws IOException, ParseException, InterruptedException {
        searchAcc.searchAccount();
        newpWithoutd.CreateNewPayment();
    }

    @Then("User get the count of existing trouble tickets")
    public void getTroubleTicketCount() throws IOException, ParseException, InterruptedException {
        newTroubleTicket.getTroubleTicketCount();
    }

    @Then("User creates a new trouble ticket")
    public void createTroubleTicket() throws IOException, ParseException, InterruptedException {
        newTroubleTicket.createTroubleTicket();
    }

    @Then("the trouble ticket is created successfully")
    public void validateTroubleTicket() throws IOException, ParseException, InterruptedException {
        newTroubleTicket.validateTroubleTicket();
    }

    @Then("User make a payment suspense")
    public void CreatePaymentSuspense() throws IOException, ParseException {
        paysusp.createPaymentSuspense();
    }

    @Then("Validate the payment suspense created successfully")
    public void ValidatePaymentSuspense() throws IOException, ParseException {
        paysusp.validatePaymentSuspense();
    }

    @Then("User transfer the payment to other account")
    public void Tootheraccount() throws IOException, ParseException {
        paymentTransfer.tootheraccount();
    }

    @Then("Payment should be Transfer to other account successfully")
    public void Transfertootheraccountsuccessfully() throws IOException, ParseException, InterruptedException {
        paymentTransfer.transfertootheraccountsuccessfully();
    }

    @Then("User Creates a recapture")
    public void CreateRecapture() throws IOException, ParseException {
        recapturePayment.recaptureCreate();
    }

    @Then("User should be able to create and validates the \"Recapture\"")
    public void ValidateRecapture() throws IOException, ParseException, java.text.ParseException {
        recapturePayment.validateRecapture();
    }

    @Then("User initiates a Negative Write Off Reversal transaction")
    public void initialReversalNegativeWriteOff() throws IOException, ParseException {
        revWriteOff.initialReversalNegativeWriteOff();
    }

    @Then("the Negative Write-Off Reversal transaction is created successfully")
    public void validateReversalNegativeWriteOff() throws IOException, ParseException {
        revWriteOff.validateReversalNegativeWriteOff();
    }

    @Then("User creates a payment reverse")
    public void CreateReversePayment() throws IOException, ParseException, InterruptedException {
        reversePay.createReversalPayment();
    }
    @Then("Validate payment reverse successfully")
    public void ValidationReversePayment() throws IOException, ParseException, InterruptedException {
        reversePay.validationReversePayment();
    }

    @Then("User initiates a Reverse Write Off transaction")
    public void CreateReverseWriteOff() throws IOException, ParseException {
        reverseWriteOff.createReverseWriteOff();
    }

    @Then("Validate the Reverse Write Off created successfully")
    public void ValidateReverseWriteOff() throws IOException, ParseException {
        reverseWriteOff.validateReverseWriteOff();
    }

    @Then("User initiates a Write Off transaction")
    public void createWriteOff() throws IOException, ParseException {
        writeOff.initialWriteOff();
    }

    @Then("the Write-Off transaction is created successfully")
    public void ValidateWriteOff() throws IOException, ParseException {
        writeOff.validateWriteOff();
    }
}
