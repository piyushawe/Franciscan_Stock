package stepDef;

import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pageObjects.ActiveStockReport;
import pageObjects.ChallanReport;
import pageObjects.CumulativeStockStatementValueWise;
import pageObjects.EmployeeIssueReport;
import pageObjects.EmployeeReturnReport;
import pageObjects.ItemMasterReport;
import pageObjects.MaxStockReport;
import pageObjects.MinStockReport;
import pageObjects.OtherReturnReport;
import pageObjects.PurchaseReturnReport;
import pageObjects.StockBillReport;
import pageObjects.StockInEntryReport;
import pageObjects.StockIssueReport;
import pageObjects.StockLedger;
import pageObjects.StockOpeningReport;
import pageObjects.StockPurchaseOrderReport;
import pageObjects.Utility;

public class MyStepDef {
  WebDriver dr;
  Collection<String> tagname;
  String schoolname;
  Collection<String> scenario;

  @Before
  public void launchBrowser(Scenario sc)
  {
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chrome\\chromedriver.exe");
	  dr= new ChromeDriver();
	  dr.manage().window().maximize();
	  //System.out.println(s.getId());
	  scenario= sc.getSourceTagNames();
	 
  }
  
  @After
  public void closeBrowser() throws InterruptedException
  {
	  Thread.sleep(2000);
	  dr.quit();
  }
  
  @When("^passes school name \"([^\"]*)\"$")
  public void passes_school_name(String arg1) throws Throwable {
	  schoolname=arg1;
  }
  
  @Given("^user enter \"([^\"]*)\"$")
  public void user_enter(String arg1) throws Throwable {
     dr.get(arg1);
  }

  @When("^user enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void user_enter_username_and_password(String arg1, String arg2) throws Throwable {
	 dr.findElement(By.id("txtUserName")).sendKeys(arg1);
	 dr.findElement(By.id("txtPassword")).sendKeys(arg2);
  }

  @When("^click signin$")
  public void click_signin() throws Throwable {
	  dr.findElement(By.id("btnLogin")).click();
	  Thread.sleep(2000);
  }

  @Then("^stock home page is opened$")
  public void stock_home_page_is_opened() throws Throwable {
      dr.findElement(By.xpath("//img[@src='images/big/Stock-Manager.png']")).click();
  }

//stock purchase order report
  @Given("^opened stock purchase order report$")
  public void opened_stock_purchase_order_report() throws Throwable {
	  StockPurchaseOrderReport s= new StockPurchaseOrderReport(dr);
	  s.openStockPurchaseOrderReport();
  }
 
  @When("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on stock purchase order report page$")
  public void user_select_from_date_as_month_year_and_day_on_stock_purchase_order_report_page(String arg1, String arg2, String arg3) throws Throwable {
	  StockPurchaseOrderReport s= new StockPurchaseOrderReport(dr);
	  s.selectFromDate(arg1, arg2, arg3);
  }

  @When("^select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on stock purchase order report page$")
  public void select_to_date_as_month_year_and_day_on_stock_purchase_order_report_page(String arg1, String arg2, String arg3) throws Throwable {
	  StockPurchaseOrderReport s= new StockPurchaseOrderReport(dr);
	  s.selectToDate(arg1, arg2, arg3);
  }

  @When("^select item name \"([^\"]*)\" on stock purchase order report page$")
  public void select_item_name_on_stock_purchase_order_report_page(String arg1) throws Throwable {
	  StockPurchaseOrderReport s= new StockPurchaseOrderReport(dr);
	  s.selectItemName(arg1);
  }

  @When("^select brand name \"([^\"]*)\" on stock purchase order report page$")
  public void select_brand_name_on_stock_purchase_order_report_page(String arg1) throws Throwable {
	  StockPurchaseOrderReport s= new StockPurchaseOrderReport(dr);
	  s.selectBrandName(arg1);
  }

  @When("^select vendor name \"([^\"]*)\" on stock purchase order report page$")
  public void select_vendor_name_on_stock_purchase_order_report_page(String arg1) throws Throwable {
	  StockPurchaseOrderReport s= new StockPurchaseOrderReport(dr);
	  s.selectVendorName(arg1);
  }

  @When("^select order \"([^\"]*)\" on stock purchase order report page$")
  public void select_order_on_stock_purchase_order_report_page(String arg1) throws Throwable {
	  StockPurchaseOrderReport s= new StockPurchaseOrderReport(dr);
	  s.selectOrder(arg1);
  }

  @Then("^stock purchase order report is opened$")
  public void stock_purchase_order_report_is_opened() throws Throwable {
	  StockPurchaseOrderReport s= new StockPurchaseOrderReport(dr);
	  s.clickShow(schoolname, scenario);
  }

//challan report
  @Given("^opened challan report$")
  public void opened_challan_report() throws Throwable {
	  ChallanReport c= new ChallanReport(dr);
	  c.openChallanReport();
  }

  @When("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on challan report page$")
  public void user_select_from_date_as_month_year_and_day_on_challan_report_page(String arg1, String arg2, String arg3) throws Throwable {
	  ChallanReport c= new ChallanReport(dr);
	  c.selectFromDate(arg1, arg2, arg3);
  }

  @When("^select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on challan report page$")
  public void select_to_date_as_month_year_and_day_on_challan_report_page(String arg1, String arg2, String arg3) throws Throwable {
	  ChallanReport c= new ChallanReport(dr);
	  c.selectToDate(arg1, arg2, arg3);
  }

  @When("^select item name \"([^\"]*)\" on challan report page$")
  public void select_item_name_on_challan_report_page(String arg1) throws Throwable {
	  ChallanReport c= new ChallanReport(dr);
	  c.selectItemName(arg1);
  }

  @When("^select brand name \"([^\"]*)\" on challan report page$")
  public void select_brand_name_on_challan_report_page(String arg1) throws Throwable {
	  ChallanReport c= new ChallanReport(dr);
	  c.selectBrandName(arg1);
  }

  @When("^select vendor name \"([^\"]*)\" on challan report page$")
  public void select_vendor_name_on_challan_report_page(String arg1) throws Throwable {
	  ChallanReport c= new ChallanReport(dr);
	  c.selectVendorName(arg1);
  }

  @Then("^challan report is opened$")
  public void challan_report_is_opened() throws Throwable {
	  ChallanReport c= new ChallanReport(dr);
	  c.clickShow(schoolname,scenario);
  }

//purchase return report
  @Given("^opened purchase return report$")
  public void opened_purchase_return_report() throws Throwable {
	  PurchaseReturnReport p= new PurchaseReturnReport(dr);
	  p.openPurchaseReturnReport();
  }

  @When("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on purchase return report$")
  public void user_select_from_date_as_month_year_and_day_on_purchase_return_report(String arg1, String arg2, String arg3) throws Throwable {
	  PurchaseReturnReport p= new PurchaseReturnReport(dr);
	  p.selectFromDate(arg1, arg2, arg3);
  }

  @When("^select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on purchase return report$")
  public void select_to_date_as_month_year_and_day_on_purchase_return_report(String arg1, String arg2, String arg3) throws Throwable {
	  PurchaseReturnReport p= new PurchaseReturnReport(dr);
	  p.selectToDate(arg1, arg2, arg3);
  }

  @When("^select item name \"([^\"]*)\" on purchase return report$")
  public void select_item_name_on_purchase_return_report(String arg1) throws Throwable {
	  PurchaseReturnReport p= new PurchaseReturnReport(dr);
	  p.selectItemName(arg1);
  }

  @When("^select brand name \"([^\"]*)\" on purchase return report$")
  public void select_brand_name_on_purchase_return_report(String arg1) throws Throwable {
	  PurchaseReturnReport p= new PurchaseReturnReport(dr);
	  p.selectBrandName(arg1);
  }

  @When("^select vendor name \"([^\"]*)\" on purchase return report$")
  public void select_vendor_name_on_purchase_return_report(String arg1) throws Throwable {
	  PurchaseReturnReport p= new PurchaseReturnReport(dr);
	  p.selectVendorName(arg1);
  }

  @Then("^purchase return report is opened$")
  public void purchase_return_report_is_opened() throws Throwable {
	  PurchaseReturnReport p= new PurchaseReturnReport(dr);
	  p.clickShow(schoolname,scenario);
  }

//stock in entry report
  @Given("^opened stock in entry report$")
  public void opened_stock_in_entry_report() throws Throwable {
	  StockInEntryReport s= new StockInEntryReport(dr);
	  s.openStockInEntryReport();
  }

  @When("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on stock in entry report$")
  public void user_select_from_date_as_month_year_and_day_on_stock_in_entry_report(String arg1, String arg2, String arg3) throws Throwable {
	  StockInEntryReport s= new StockInEntryReport(dr);
	  s.selectFromDate(arg1, arg2, arg3);
  }

  @When("^select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on stock in entry report$")
  public void select_to_date_as_month_year_and_day_on_stock_in_entry_report(String arg1, String arg2, String arg3) throws Throwable {
	  StockInEntryReport s= new StockInEntryReport(dr);
	  s.selectToDate(arg1, arg2, arg3);
  }

  @When("^select item name \"([^\"]*)\" on stock in entry report$")
  public void select_item_name_on_stock_in_entry_report(String arg1) throws Throwable {
	  StockInEntryReport s= new StockInEntryReport(dr);
	  s.selectItemName(arg1);
  }

  @When("^select brand name \"([^\"]*)\" on stock in entry report$")
  public void select_brand_name_on_stock_in_entry_report(String arg1) throws Throwable {
	  StockInEntryReport s= new StockInEntryReport(dr);
	  s.selectBrandName(arg1);
  }

  @When("^select vendor name \"([^\"]*)\" on stock in entry report$")
  public void select_vendor_name_on_stock_in_entry_report(String arg1) throws Throwable {
	  StockInEntryReport s= new StockInEntryReport(dr);
	  s.selectVendorName(arg1);
  }

  @When("^select receipt no \"([^\"]*)\" on stock in entry report$")
  public void select_receipt_no_on_stock_in_entry_report(String arg1) throws Throwable {
	  StockInEntryReport s= new StockInEntryReport(dr);
	  s.selectReceiptNo(arg1);
  }

  @Then("^stock in entry report is opened$")
  public void stock_in_entry_report_is_opened() throws Throwable {
	  StockInEntryReport s= new StockInEntryReport(dr);
	  s.clickShow(schoolname,scenario);
  }

//stock bill report
  @Given("^opened stock bill report$")
  public void opened_stock_bill_report() throws Throwable {
	  StockBillReport s= new StockBillReport(dr);
	  s.openStockBillReport();
  }

  @When("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on stock bill report$")
  public void user_select_from_date_as_month_year_and_day_on_stock_bill_report(String arg1, String arg2, String arg3) throws Throwable {
	  StockBillReport s= new StockBillReport(dr);
	  s.selectFromDate(arg1, arg2, arg3);
  }

  @When("^select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on stock bill report$")
  public void select_to_date_as_month_year_and_day_on_stock_bill_report(String arg1, String arg2, String arg3) throws Throwable {
	  StockBillReport s= new StockBillReport(dr);
	  s.selectToDate(arg1, arg2, arg3);
  }

  @When("^select item name \"([^\"]*)\" on stock bill report$")
  public void select_item_name_on_stock_bill_report(String arg1) throws Throwable {
	  StockBillReport s= new StockBillReport(dr);
	  s.selectItemName(arg1);
  }

  @When("^select brand name \"([^\"]*)\" on stock bill report$")
  public void select_brand_name_on_stock_bill_report(String arg1) throws Throwable {
	  StockBillReport s= new StockBillReport(dr);
	  s.selectBrandName(arg1);
  }

  @When("^select vendor name \"([^\"]*)\" on stock bill report$")
  public void select_vendor_name_on_stock_bill_report(String arg1) throws Throwable {
	  StockBillReport s= new StockBillReport(dr);
	  s.selectVendorName(arg1);
  }

  @Then("^stock bill report is opened$")
  public void stock_bill_report_is_opened() throws Throwable {
	  StockBillReport s= new StockBillReport(dr);
	  s.clickShow(schoolname,scenario);
  }

//employee issue report
  @Given("^opened employee issue report$")
  public void opened_employee_issue_report() throws Throwable {
	  EmployeeIssueReport e= new EmployeeIssueReport(dr);
	  e.openEmployeeIssueReport();
  }

  @When("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on employee issue report$")
  public void user_select_from_date_as_month_year_and_day_on_employee_issue_report(String arg1, String arg2, String arg3) throws Throwable {
	  EmployeeIssueReport e= new EmployeeIssueReport(dr);
	  e.selectFromDate(arg1, arg2, arg3);
  }

  @When("^select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on employee issue report$")
  public void select_to_date_as_month_year_and_day_on_employee_issue_report(String arg1, String arg2, String arg3) throws Throwable {
	  EmployeeIssueReport e= new EmployeeIssueReport(dr);
	  e.selectToDate(arg1, arg2, arg3);
  }

  @When("^select item name \"([^\"]*)\" on employee issue report$")
  public void select_item_name_on_employee_issue_report(String arg1) throws Throwable {
	  EmployeeIssueReport e= new EmployeeIssueReport(dr);
	  e.selectItemName(arg1);
  }

  @When("^select brand name \"([^\"]*)\" on employee issue report$")
  public void select_brand_name_on_employee_issue_report(String arg1) throws Throwable {
	  EmployeeIssueReport e= new EmployeeIssueReport(dr);
	  e.selectBrandName(arg1);
  }

  @When("^select employee name \"([^\"]*)\" on employee issue report$")
  public void select_employee_name_on_employee_issue_report(String arg1) throws Throwable {
	  EmployeeIssueReport e= new EmployeeIssueReport(dr);
	  e.selectEmployeeName(arg1);
  }

  @Then("^employee issue report is opened$")
  public void employee_issue_report_is_opened() throws Throwable {
	  EmployeeIssueReport e= new EmployeeIssueReport(dr);
	  e.clickShow(schoolname,scenario);
  }

//employee return report
  @Given("^opened employee return report$")
  public void opened_employee_return_report() throws Throwable {
	  EmployeeReturnReport e= new EmployeeReturnReport(dr);
	  e.openEmployeeReturnReport();
  }

  @When("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on employee return report$")
  public void user_select_from_date_as_month_year_and_day_on_employee_return_report(String arg1, String arg2, String arg3) throws Throwable {
	  EmployeeReturnReport e= new EmployeeReturnReport(dr);
	  e.selectFromDate(arg1, arg2, arg3);
  }

  @When("^select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on employee return report$")
  public void select_to_date_as_month_year_and_day_on_employee_return_report(String arg1, String arg2, String arg3) throws Throwable {
	  EmployeeReturnReport e= new EmployeeReturnReport(dr);
	  e.selectToDate(arg1, arg2, arg3);
  }

  @When("^select item name \"([^\"]*)\" on employee return report$")
  public void select_item_name_on_employee_return_report(String arg1) throws Throwable {
	  EmployeeReturnReport e= new EmployeeReturnReport(dr);
	  e.selectItemName(arg1);
  }

  @When("^select brand name \"([^\"]*)\" on employee return report$")
  public void select_brand_name_on_employee_return_report(String arg1) throws Throwable {
	  EmployeeReturnReport e= new EmployeeReturnReport(dr);
	  e.selectBrandName(arg1);
  }

  @When("^select employee name \"([^\"]*)\" on employee return report$")
  public void select_employee_name_on_employee_return_report(String arg1) throws Throwable {
	  EmployeeReturnReport e= new EmployeeReturnReport(dr);
	  e.selectEmployeeName(arg1);
  }

  @Then("^employee return report is opened$")
  public void employee_return_report_is_opened() throws Throwable {
	  EmployeeReturnReport e= new EmployeeReturnReport(dr);
	  e.clickShow(schoolname,scenario);
  }

//stock issue report
  @Given("^opened stock issue report$")
  public void opened_stock_issue_report() throws Throwable {
	  StockIssueReport s= new StockIssueReport(dr);
	  s.openStockIssueReport();
  }

  @When("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on stock issue report$")
  public void user_select_from_date_as_month_year_and_day_on_stock_issue_report(String arg1, String arg2, String arg3) throws Throwable {
	  StockIssueReport s= new StockIssueReport(dr);
	  s.selectFromDate(arg1, arg2, arg3);
  }

  @When("^select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on stock issue report$")
  public void select_to_date_as_month_year_and_day_on_stock_issue_report(String arg1, String arg2, String arg3) throws Throwable {
	  StockIssueReport s= new StockIssueReport(dr);
	  s.selectToDate(arg1, arg2, arg3);
  }

  @When("^select item name \"([^\"]*)\" on stock issue report$")
  public void select_item_name_on_stock_issue_report(String arg1) throws Throwable {
	  StockIssueReport s= new StockIssueReport(dr);
	  s.selectItemName(arg1);
  }

  @When("^select brand name \"([^\"]*)\" on stock issue report$")
  public void select_brand_name_on_stock_issue_report(String arg1) throws Throwable {
	  StockIssueReport s= new StockIssueReport(dr);
	  s.selectBrandName(arg1);
  }

  @When("^click employee on stock issue report$")
  public void click_employee_on_stock_issue_report() throws Throwable {
	  StockIssueReport s= new StockIssueReport(dr);
	  s.clickEmployee();
  }

  @When("^select issue to \"([^\"]*)\" on stock issue report$")
  public void select_issue_to_on_stock_issue_report(String arg1) throws Throwable {
	  StockIssueReport s= new StockIssueReport(dr);
	  s.selectIssueTo(arg1);
  }

  @When("^click other on stock issue report$")
  public void click_other_on_stock_issue_report() throws Throwable {
	  StockIssueReport s= new StockIssueReport(dr);
	  s.clickOther();
  }
  
  @Then("^stock issue report is opened$")
  public void stock_issue_report_is_opened() throws Throwable {
	  StockIssueReport s= new StockIssueReport(dr);
	  s.clickShow(schoolname,scenario);
  }

//other return report
  @Given("^opened other return report$")
  public void opened_other_return_report() throws Throwable {
	  OtherReturnReport r= new OtherReturnReport(dr);
	  r.openOtherReturnReport();
  }

  @When("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on other return report$")
  public void user_select_from_date_as_month_year_and_day_on_other_return_report(String arg1, String arg2, String arg3) throws Throwable {
	  OtherReturnReport r= new OtherReturnReport(dr);
	  r.selectFromDate(arg1, arg2, arg3);
  }

  @When("^select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on other return report$")
  public void select_to_date_as_month_year_and_day_on_other_return_report(String arg1, String arg2, String arg3) throws Throwable {
	  OtherReturnReport r= new OtherReturnReport(dr);
	  r.selectToDate(arg1, arg2, arg3);
  }

  @When("^select item name \"([^\"]*)\" on other return report$")
  public void select_item_name_on_other_return_report(String arg1) throws Throwable {
	  OtherReturnReport r= new OtherReturnReport(dr);
	  r.selectItemName(arg1);
  }

  @When("^select brand name \"([^\"]*)\" on other return report$")
  public void select_brand_name_on_other_return_report(String arg1) throws Throwable {
	  OtherReturnReport r= new OtherReturnReport(dr);
	  r.selectBrandName(arg1);
  }

  @Then("^other return report is opened$")
  public void other_return_report_is_opened() throws Throwable {
	  OtherReturnReport r= new OtherReturnReport(dr);
	  r.clickShow(schoolname, scenario);
  }

//stock opening report
  @Given("^opened stock opening report$")
  public void opened_stock_opening_report() throws Throwable {
	  StockOpeningReport s= new StockOpeningReport(dr);
	  s.openStockOpeningReport();
  }

  @When("^user select on dated as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on stock opening report$")
  public void user_select_on_dated_as_month_year_and_day_on_stock_opening_report(String arg1, String arg2, String arg3) throws Throwable {
	  StockOpeningReport s= new StockOpeningReport(dr);
	  s.selectOnDated(arg1, arg2, arg3);
  }

  @When("^select item name \"([^\"]*)\" on stock opening report$")
  public void select_item_name_on_stock_opening_report(String arg1) throws Throwable {
	  StockOpeningReport s= new StockOpeningReport(dr);
	  s.selectItemName(arg1);
  }

  @When("^select brand name \"([^\"]*)\" on stock opening report$")
  public void select_brand_name_on_stock_opening_report(String arg1) throws Throwable {
	  StockOpeningReport s= new StockOpeningReport(dr);
	  s.selectBrandName(arg1);
  }

  @Then("^stock opening report is opened$")
  public void stock_opening_report_is_opened() throws Throwable {
	  StockOpeningReport s= new StockOpeningReport(dr);
	  s.clickShow(schoolname,scenario);
  }

//active stock report
  @Given("^opened active stock report$")
  public void opened_active_stock_report() throws Throwable {
	  ActiveStockReport r= new ActiveStockReport(dr);
	  r.openActiveStockReport();
  }

  @When("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on active stock report$")
  public void user_select_from_date_as_month_year_and_day_on_active_stock_report(String arg1, String arg2, String arg3) throws Throwable {
	  ActiveStockReport r= new ActiveStockReport(dr);
	  r.selectFromDate(arg1, arg2, arg3);
  }

  @When("^select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on active stock report$")
  public void select_to_date_as_month_year_and_day_on_active_stock_report(String arg1, String arg2, String arg3) throws Throwable {
	  ActiveStockReport r= new ActiveStockReport(dr);
	  r.selectToDate(arg1, arg2, arg3);
  }

  @When("^select category \"([^\"]*)\" on active stock report$")
  public void select_category_on_active_stock_report(String arg1) throws Throwable {
	  ActiveStockReport r= new ActiveStockReport(dr);
	  r.selectCategory(arg1);
  }

  @When("^select sub category \"([^\"]*)\" on active stock report$")
  public void select_sub_category_on_active_stock_report(String arg1) throws Throwable {
	  ActiveStockReport r= new ActiveStockReport(dr);
	  r.selectSubCategory(arg1);
  }

  @When("^select item name \"([^\"]*)\" on active stock report$")
  public void select_item_name_on_active_stock_report(String arg1) throws Throwable {
	  ActiveStockReport r= new ActiveStockReport(dr);
	  r.selectItemName(arg1);
  }

  @When("^select brand name \"([^\"]*)\" on active stock report$")
  public void select_brand_name_on_active_stock_report(String arg1) throws Throwable {
	  ActiveStockReport r= new ActiveStockReport(dr);
	  r.selectBrandName(arg1);
  }

  @Then("^active stock report is opened$")
  public void active_stock_report_is_opened() throws Throwable {
	  ActiveStockReport r= new ActiveStockReport(dr);
	  r.clickShow(schoolname,scenario);
  }

//cucmulative stock statement value wise
  @Given("^opened cucmulative stock statement value wise$")
  public void opened_cucmulative_stock_statement_value_wise() throws Throwable {
	  CumulativeStockStatementValueWise s= new CumulativeStockStatementValueWise(dr);
	  s.openCumulativeStockStatementValueWise();
  }
  
  @When("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on cucmulative stock statement value wise$")
  public void user_select_from_date_as_month_year_and_day_on_cucmulative_stock_statement_value_wise(String arg1, String arg2, String arg3) throws Throwable {
	  CumulativeStockStatementValueWise s= new CumulativeStockStatementValueWise(dr);
	  s.selectFromDate(arg1, arg2, arg3);
  }

  @When("^select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on cucmulative stock statement value wise$")
  public void select_to_date_as_month_year_and_day_on_cucmulative_stock_statement_value_wise(String arg1, String arg2, String arg3) throws Throwable {
	  CumulativeStockStatementValueWise s= new CumulativeStockStatementValueWise(dr);
	  s.selectToDate(arg1, arg2, arg3);
  }

  @When("^select category \"([^\"]*)\" on cucmulative stock statement value wise$")
  public void select_category_on_cucmulative_stock_statement_value_wise(String arg1) throws Throwable {
	  CumulativeStockStatementValueWise s= new CumulativeStockStatementValueWise(dr);
	  s.selectCategory(arg1);
  }

  @When("^select sub category \"([^\"]*)\" on cucmulative stock statement value wise$")
  public void select_sub_category_on_cucmulative_stock_statement_value_wise(String arg1) throws Throwable {
	  CumulativeStockStatementValueWise s= new CumulativeStockStatementValueWise(dr);
	  s.selectSubCategory(arg1);
  }

  @When("^select item name \"([^\"]*)\" on cucmulative stock statement value wise$")
  public void select_item_name_on_cucmulative_stock_statement_value_wise(String arg1) throws Throwable {
	  CumulativeStockStatementValueWise s= new CumulativeStockStatementValueWise(dr);
	  s.selectItem(arg1);
  }

  @Then("^cucmulative stock statement value wise  is opened$")
  public void cucmulative_stock_statement_value_wise_is_opened() throws Throwable {
	  CumulativeStockStatementValueWise s= new CumulativeStockStatementValueWise(dr);
	  s.clickShow(schoolname,scenario);
  }

//stock ledger
  @Given("^opened stock ledger$")
  public void opened_stock_ledger() throws Throwable {
	  StockLedger s= new StockLedger(dr);
	  s.openStockLedger();
  }

  @When("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on stock ledger$")
  public void user_select_from_date_as_month_year_and_day_on_stock_ledger(String arg1, String arg2, String arg3) throws Throwable {
	  StockLedger s= new StockLedger(dr);
	  s.selectFromDate(arg1, arg2, arg3);
  }

  @When("^select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on stock ledger$")
  public void select_to_date_as_month_year_and_day_on_stock_ledger(String arg1, String arg2, String arg3) throws Throwable {
	  StockLedger s= new StockLedger(dr);
	  s.selectToDate(arg1, arg2, arg3);
  }

  @When("^select category \"([^\"]*)\" on stock ledger$")
  public void select_category_on_stock_ledger(String arg1) throws Throwable {
	  StockLedger s= new StockLedger(dr);
	  s.selectCategory(arg1);
  }

  @When("^select sub category \"([^\"]*)\" on stock ledger$")
  public void select_sub_category_on_stock_ledger(String arg1) throws Throwable {
	  StockLedger s= new StockLedger(dr);
	  s.selectSubCategory(arg1);
  }

  @When("^select item name \"([^\"]*)\" on stock ledger$")
  public void select_item_name_on_stock_ledger(String arg1) throws Throwable {
	  StockLedger s= new StockLedger(dr);
	  s.selectItem(arg1);
  }

  @When("^select brand name \"([^\"]*)\" on stock ledger$")
  public void select_brand_name_on_stock_ledger(String arg1) throws Throwable {
	  StockLedger s= new StockLedger(dr);
	  s.selectBrandName(arg1);
  }

  @Then("^stock ledger is opened$")
  public void stock_ledger_is_opened() throws Throwable {
	  StockLedger s= new StockLedger(dr);
	  s.clickShow(schoolname,scenario);
  }

//max stock report
  @Given("^opened max stock report$")
  public void opened_max_stock_report() throws Throwable {
	  MaxStockReport s= new MaxStockReport(dr);
	  s.openMaxStockReport();
  }

  @When("^user select date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on max stock report$")
  public void user_select_date_as_month_year_and_day_on_max_stock_report(String arg1, String arg2, String arg3) throws Throwable {
	  MaxStockReport s= new MaxStockReport(dr);
	  s.selectDate(arg1, arg2, arg3);
  }

  @When("^select item name \"([^\"]*)\" on max stock report$")
  public void select_item_name_on_max_stock_report(String arg1) throws Throwable {
	  MaxStockReport s= new MaxStockReport(dr);
	  s.selectItemName(arg1);
  }

  @When("^select brand name \"([^\"]*)\" on max stock report$")
  public void select_brand_name_on_max_stock_report(String arg1) throws Throwable {
	  MaxStockReport s= new MaxStockReport(dr);
	  s.selectBrandName(arg1);
  }

  @Then("^max stock report is opened$")
  public void max_stock_report_is_opened() throws Throwable {
	  MaxStockReport s= new MaxStockReport(dr);
	  s.clickShow(schoolname,scenario);
  }

//min stock report
  @Given("^opened min stock report$")
  public void opened_min_stock_report() throws Throwable {
	  MinStockReport r= new MinStockReport(dr);
	  r.openMinStockReport();
  }
  
  @When("^user select date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on min stock report$")
  public void user_select_date_as_month_year_and_day_on_min_stock_report(String arg1, String arg2, String arg3) throws Throwable {
	  MinStockReport r= new MinStockReport(dr);
	  r.selectDate(arg1, arg2, arg3);
  }

  @When("^select item name \"([^\"]*)\" on min stock report$")
  public void select_item_name_on_min_stock_report(String arg1) throws Throwable {
	  MinStockReport r= new MinStockReport(dr);
	  r.selectItemName(arg1);
  }

  @When("^select brand name \"([^\"]*)\" on min stock report$")
  public void select_brand_name_on_min_stock_report(String arg1) throws Throwable {
	  MinStockReport r= new MinStockReport(dr);
	  r.selectBrandName(arg1);
  }

  @Then("^min stock report is opened$")
  public void min_stock_report_is_opened() throws Throwable {
	  MinStockReport r= new MinStockReport(dr);
	  r.clickShow(schoolname,scenario);
  }

//item master report
  @Given("^opened item master report$")
  public void opened_item_master_report() throws Throwable {
	  ItemMasterReport r= new ItemMasterReport(dr);
	  r.openItemMasterReport();
  }

  @Given("^select category \"([^\"]*)\" on item master report$")
  public void select_category_on_item_master_report(String arg1) throws Throwable {
	  ItemMasterReport r= new ItemMasterReport(dr);
	  r.selectCategory(arg1);
  }

  @Given("^select sub category \"([^\"]*)\" on item master report$")
  public void select_sub_category_on_item_master_report(String arg1) throws Throwable {
	  ItemMasterReport r= new ItemMasterReport(dr);
	  r.selectSubCategory(arg1);
  }

  @Then("^item master report is opened$")
  public void item_master_report_is_opened() throws Throwable {
	  ItemMasterReport r= new ItemMasterReport(dr);
	  r.clickShow(schoolname,scenario);
  }


}
