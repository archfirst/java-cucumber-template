package org.archfirst.template.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.archfirst.template.domain.Account;
import org.archfirst.template.services.AccountService;
import org.archfirst.template.services.NotFoundException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AccountSteps {
	
	private AccountService accountService = new AccountService();

	private Account account;
	private String httpError;

	@Given("^an account called (.*)$")
	public void an_account_called_x(String accountName) {
        account = accountService.createAccount(new Account(accountName));
	}

	@When("^I create an account called (.*)$")
	public void i_create_an_account_called_x(String accountName) {
        account = accountService.createAccount(new Account(accountName));
	}

	@When("^I change the account name to (.*)$")
	public void i_change_the_account_name_to_x(String accountName) {
		account.setName(accountName);
        account = accountService.updateAccount(account);
	}

	@When("^I ask for the account$")
	public void i_ask_for_the_account() {
        try {
			account = accountService.getAccount(account.getId());
		}
        catch (NotFoundException e) {
        	httpError = "404 Not Found";
		}
	}

	@When("^I delete the account$")
	public void i_delete_the_account() {
        accountService.deleteAccount(account.getId());
	}

	@Then("^I should get the account called (.*)$")
	public void i_should_get_the_account_called_x(String expectedName) {
        assertThat(account.getName(), is(expectedName));
	}

	@Then("^a \"(.*)\" error should be returned$")
	public void a_Not_Found_error_should_be_returned(String expectedError) {
        assertThat(httpError, is(expectedError));
	}
}
