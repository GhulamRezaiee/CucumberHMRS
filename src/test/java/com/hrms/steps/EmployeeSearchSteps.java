package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.GlobalVariables;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class EmployeeSearchSteps extends CommonMethods {
	@Given("User navigated to HMRS")
	public void user_navigated_to_HMRS() {
		setUp();
	}

	@Given("user is logged in with valid admin credentials")
	public void user_is_logged_in_with_valid_admin_credentials() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
	}

	@Given("user navigate to employee list page")
	public void user_navigate_to_employee_list_page() {
		jsClick(dashboard.PIM);
		jsClick(dashboard.empListPage);
	}

	@When("user enters valid employee id {string}")
	public void user_enters_valid_employee_id(String id){
		sendText(viewEmp.empID, id);
		GlobalVariables.empID = id;
	}

	@When("click on search button")
	public void click_on_search_button() {
		jsClick(viewEmp.searchBtn);
	}

	@Then("user see employee information is displayed")
	public void user_see_employee_information_is_displayed() {
		System.out.println("Employee Displayed");
//		String ID = viewEmp.searchedID.getAttribute("Text");
//		if (ID.equals("10097")) {
//			System.out.println("Test Pass");
//		}else {
//			System.out.println("Test Feild");
//		}
		
	}

	//@When("User enters valid employee first name and last name")
	//public void user_enters_valid_employee_first_name_and_last_name() {
	//}
	
	
	
	@Then("verify table is displayed")
	public void verify_table_is_displayed() {
		Assert.assertEquals(true, viewEmp.isTableDisplayed());
	}

	@Then("get first name from table")
	public void get_first_name_from_table() {
		System.out.println(viewEmp.tableFirstName);
	}
	
	@Then("Validate first name from UI against DB")
	public void validate_first_name_from_UI_against_DB() {
		Assert.assertEquals(DBSteps.dbData, viewEmp.getFirstNameFromTable());
	}
}
