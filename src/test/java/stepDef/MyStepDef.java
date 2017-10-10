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
import globalMastersPageObject.DefineAcademicYear;
import globalMastersPageObject.DefineBrandName;
import globalMastersPageObject.DefineFinancialYear;
import globalMastersPageObject.DefineItemCategory;
import globalMastersPageObject.DefineItems;
import globalMastersPageObject.DefineItemsSubCategory;
import globalMastersPageObject.DefineSmsTemplate;
import globalMastersPageObject.DefineUnit;
import masterSettingsPageObject.DefineItemUniqueEntity;
import masterSettingsPageObject.NotificationScheduler;
import masterSettingsPageObject.StockMasterSetting;
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
import stockPageObject.AssetOpeningEntry;
import stockPageObject.MultipleStockIssue;
import stockPageObject.OpeningQuantity;
import stockPageObject.PurchaseOrder;
import stockPageObject.PurchaseReturnEntry;
import stockPageObject.RequisitionOrder;
import stockPageObject.StockBillEntry;
import stockPageObject.StockInEntry;
import stockPageObject.StockIssue;
import stockPageObject.StockReturn;
import stockPageObject.StockReturnItemWise;

public class MyStepDef {
  WebDriver dr;
  Collection<String> tagname;
  String schoolname;
  Collection<String> scenario;

  @Before
  public void launchBrowser(Scenario sc)
  {
	  //System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chrome\\chromedriver.exe");
      System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
	  dr= new ChromeDriver();
	  dr.manage().window().maximize();
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

//notification scheduler
  @When("^user open notification scheduler page$")
  public void user_open_notification_scheduler_page() throws Throwable {
	  NotificationScheduler ns= new NotificationScheduler(dr);
	  ns.openNotificationScheduler();
  }

  @Then("^verify notification scheduler page$")
  public void verify_notification_scheduler_page() throws Throwable {
	  NotificationScheduler ns= new NotificationScheduler(dr);
	  ns.verifyPage(schoolname, scenario);
  }
  
//define item unique entity
  @When("^user open define item unique entity page$")
  public void user_open_define_item_unique_entity_page() throws Throwable {
	  DefineItemUniqueEntity diue= new DefineItemUniqueEntity(dr);
	  diue.openDefineItemUniqueEntity();
  }

  @Then("^verify define item unique entity page$")
  public void verify_define_item_unique_entity_page() throws Throwable {
	  DefineItemUniqueEntity diue= new DefineItemUniqueEntity(dr);
	  diue.verifyPage(schoolname, scenario);
  }

//stock master setting
  @When("^user open stock master setting page$")
  public void user_open_stock_master_setting_page() throws Throwable {
	  StockMasterSetting sms= new StockMasterSetting(dr);
	  sms.openStockMasterSetting();
  }

  @Then("^verify stock master setting page$")
  public void verify_stock_master_setting_page() throws Throwable {
	  StockMasterSetting sms= new StockMasterSetting(dr);
	  sms.verifyPage(schoolname, scenario);
  }

//define item category
  @When("^user open define item category page$")
  public void user_open_define_item_category_page() throws Throwable {
	  DefineItemCategory dic= new DefineItemCategory(dr);
	  dic.openDefineItemCategory();
  }

  @Then("^verify define item category page$")
  public void verify_define_item_category_page() throws Throwable {
	  DefineItemCategory dic= new DefineItemCategory(dr);
	  dic.verifyPage(schoolname, scenario);
  }

  @When("^enter item category as \"([^\"]*)\" on define item category page$")
  public void enter_item_category_as_on_define_item_category_page(String arg1) throws Throwable {
      DefineItemCategory dic= new DefineItemCategory(dr);
      dic.enterItemCategory(arg1);
  }

  @When("^enter description as \"([^\"]*)\" on define item category page$")
  public void enter_description_as_on_define_item_category_page(String arg1) throws Throwable {
      DefineItemCategory dic= new DefineItemCategory(dr);
      dic.enterDescription(arg1);
  }

  @Then("^click save on define item category page$")
  public void click_save_on_define_item_category_page() throws Throwable {
      DefineItemCategory dic= new DefineItemCategory(dr);
      dic.clickSave(schoolname, scenario);
  }

  @Then("^click view on define item category page$")
  public void click_view_on_define_item_category_page() throws Throwable {
      DefineItemCategory dic= new DefineItemCategory(dr);
      dic.clickView(schoolname, scenario);
  }

//define unit
  @When("^user open define unit page$")
  public void user_open_define_unit_page() throws Throwable {
	  DefineUnit du= new DefineUnit(dr); 
	  du.openDefineUnit();
  }

  @Then("^verify define unit page$")
  public void verify_define_unit_page() throws Throwable {
	  DefineUnit du= new DefineUnit(dr);
	  du.verifyPage(schoolname, scenario);
  }

  @When("^enter unit name as \"([^\"]*)\" on define unit page$")
  public void enter_unit_name_as_on_define_unit_page(String arg1) throws Throwable {
      DefineUnit du= new DefineUnit(dr);
      du.enterUnitName(arg1);
  }

  @When("^enter description as \"([^\"]*)\" on define unit page$")
  public void enter_description_as_on_define_unit_page(String arg1) throws Throwable {
      DefineUnit du= new DefineUnit(dr);
      du.enterShortName(arg1);
  }

  @Then("^click save on define unit page$")
  public void click_save_on_define_unit_page() throws Throwable {
      DefineUnit du= new DefineUnit(dr);
      du.clickSave(schoolname, scenario);
  }

  @Then("^click view on define unit page$")
  public void click_view_on_define_unit_page() throws Throwable {
      DefineUnit du= new DefineUnit(dr);
      du.clickView(schoolname, scenario);
  }

//define items  
  @When("^user open define items page$")
  public void user_open_define_items_page() throws Throwable {
	  DefineItems di= new DefineItems(dr);
	  di.openDefineItems();
  }

  @Then("^verify define items page$")
  public void verify_define_items_page() throws Throwable {
	  DefineItems di= new DefineItems(dr);
	  di.verifyPage(schoolname, scenario);
  }

  @When("^select item category on define items page$")
  public void select_item_category_on_define_items_page() throws Throwable {
      DefineItems di= new DefineItems(dr);
      di.selectItemCategory();
  }

  @When("^select sub category on define items page$")
  public void select_sub_category_on_define_items_page() throws Throwable {
      DefineItems di= new DefineItems(dr);
      di.selectSubCategory();
  }

  @When("^enter item name as \"([^\"]*)\" on define items page$")
  public void enter_item_name_as_on_define_items_page(String arg1) throws Throwable {
      DefineItems di= new DefineItems(dr);
      di.enterItemName(arg1);
  }

  @When("^enter item code as \"([^\"]*)\" on define items page$")
  public void enter_item_code_as_on_define_items_page(String arg1) throws Throwable {
      DefineItems di= new DefineItems(dr);
      di.enterItemCode(arg1);
  }

  @When("^select unit on define items page$")
  public void select_unit_on_define_items_page() throws Throwable {
      DefineItems di= new DefineItems(dr);
      di.selectUnit();
  }

  @When("^select maximum quantity \"([^\"]*)\" on define items page$")
  public void select_maximum_quantity_on_define_items_page(String arg1) throws Throwable {
      DefineItems di= new DefineItems(dr);
      di.enterMaximumQuantity(arg1);
  }

  @When("^select minimum quantity \"([^\"]*)\" on define items page$")
  public void select_minimum_quantity_on_define_items_page(String arg1) throws Throwable {
      DefineItems di= new DefineItems(dr);
      di.enterMinimumQuantity(arg1);
  }

  @When("^select is fixed asset on define items page$")
  public void select_is_fixed_asset_on_define_items_page() throws Throwable {
      DefineItems di= new DefineItems(dr);
      di.selectIsFixedAsset();
  }

  @Then("^click save on define items page$")
  public void click_save_on_define_items_page() throws Throwable {
      DefineItems di= new DefineItems(dr);
      di.clickSave(schoolname, scenario);
  }

  @Then("^click view on define items page$")
  public void click_view_on_define_items_page() throws Throwable {
      DefineItems di= new DefineItems(dr);
      di.clickView(schoolname, scenario);
  }

//define items sub category
  @When("^user open define items sub category page$")
  public void user_open_define_items_sub_category_page() throws Throwable {
	  DefineItemsSubCategory disc= new DefineItemsSubCategory(dr);
	  disc.openDefineItemsSubCategory();
  }

  @Then("^verify define items sub category page$")
  public void verify_define_items_sub_category_page() throws Throwable {
	  DefineItemsSubCategory disc= new DefineItemsSubCategory(dr);
	  disc.verifyPage(schoolname, scenario);
  }

  @When("^select item category name on define items sub category page$")
  public void select_item_category_name_on_define_items_sub_category_page() throws Throwable {
      DefineItemsSubCategory disc= new DefineItemsSubCategory(dr);
      disc.selectItemCategoryName();
  }

  @When("^enter item sub category as \"([^\"]*)\" on define items sub category page$")
  public void enter_item_sub_category_as_on_define_items_sub_category_page(String arg1) throws Throwable {
      DefineItemsSubCategory disc= new DefineItemsSubCategory(dr);
      disc.enterItemSubCategory(arg1);
  }

  @When("^enter description as \"([^\"]*)\" on define items sub category page$")
  public void enter_description_as_on_define_items_sub_category_page(String arg1) throws Throwable {
      DefineItemsSubCategory disc= new DefineItemsSubCategory(dr);
      disc.enterDescription(arg1);
  }

  @Then("^click save on define items sub category page$")
  public void click_save_on_define_items_sub_category_page() throws Throwable {
      DefineItemsSubCategory disc= new DefineItemsSubCategory(dr);
      disc.clickSave(schoolname, scenario);
  }

  @Then("^click view on define items sub category page$")
  public void click_view_on_define_items_sub_category_page() throws Throwable {
      DefineItemsSubCategory disc= new DefineItemsSubCategory(dr);
      disc.clickView(schoolname, scenario);
  }

//define brand name
  @When("^user open define brand name page$")
  public void user_open_define_brand_name_page() throws Throwable {
	  DefineBrandName dbn= new DefineBrandName(dr);
	  dbn.openDefineBrandName();
  }

  @Then("^verify define brand name page$")
  public void verify_define_brand_name_page() throws Throwable {
	  DefineBrandName dbn= new DefineBrandName(dr);
	  dbn.verifyPage(schoolname, scenario);
  }

  @When("^enter brand name as \"([^\"]*)\" on define brand name page$")
  public void enter_brand_name_as_on_define_brand_name_page(String arg1) throws Throwable {
      DefineBrandName dbn= new DefineBrandName(dr);
      dbn.enterBrandName(arg1);
  }

  @Then("^click save on define brand name page$")
  public void click_save_on_define_brand_name_page() throws Throwable {
      DefineBrandName dbn= new DefineBrandName(dr);
      dbn.clickSave(schoolname,scenario);
  }

  @Then("^click view on define brand name page$")
  public void click_view_on_define_brand_name_page() throws Throwable {
      DefineBrandName dbn= new DefineBrandName(dr);
      dbn.clickView(schoolname, scenario);
  }

//define academic year
  @When("^user open define academic year page$")
  public void user_open_define_academic_year_page() throws Throwable {
	  DefineAcademicYear day= new DefineAcademicYear(dr);
	  day.openDefineAcademicYear();
  }

  @Then("^verify define academic year page$")
  public void verify_define_academic_year_page() throws Throwable {
	  DefineAcademicYear day= new DefineAcademicYear(dr);
	  day.verifyPage(schoolname, scenario);
  }
  
//define financial year
  @When("^user open define financial year page$")
  public void user_open_define_financial_year_page() throws Throwable {
	  DefineFinancialYear dfy= new DefineFinancialYear(dr);
	  dfy.openDefineFinancialYear();
  }

  @Then("^verify define financial year page$")
  public void verify_define_financial_year_page() throws Throwable {
	  DefineFinancialYear dfy= new DefineFinancialYear(dr);
	  dfy.verifyPage(schoolname, scenario);
  }

//define sms template
  @When("^user open define sms template page$")
  public void user_open_define_sms_template_page() throws Throwable {
	  DefineSmsTemplate dst= new DefineSmsTemplate(dr);
	  dst.openDefineSmsTemplate();
  }

  @Then("^verify define sms template page$")
  public void verify_define_sms_template_page() throws Throwable {
	  DefineSmsTemplate dst= new DefineSmsTemplate(dr);
	  dst.verifyPage(schoolname, scenario);
  }

  @When("^select sms type on define sms template page$")
  public void select_sms_type_on_define_sms_template_page() throws Throwable {
      DefineSmsTemplate dst= new DefineSmsTemplate(dr);
      dst.selectSmsType();
  }

  @When("^enter sms as \"([^\"]*)\" on define sms template page$")
  public void enter_sms_as_on_define_sms_template_page(String arg1) throws Throwable {
      DefineSmsTemplate dst= new DefineSmsTemplate(dr);
      dst.enterSms(arg1);
  }

  @When("^select is enable on define sms template page$")
  public void select_is_enable_on_define_sms_template_page() throws Throwable {
      DefineSmsTemplate dst= new DefineSmsTemplate(dr);
      dst.selectIsEnable();
  }

  @Then("^click save on define sms template page$")
  public void click_save_on_define_sms_template_page() throws Throwable {
      DefineSmsTemplate dst= new DefineSmsTemplate(dr);
      dst.clickSave(schoolname, scenario);
  }

  @Then("^click view on define sms template page$")
  public void click_view_on_define_sms_template_page() throws Throwable {
      DefineSmsTemplate dst= new DefineSmsTemplate(dr);
      dst.clickView(schoolname, scenario);
  }

//requisition order
  @When("^user open requisition order page$")
  public void user_open_requisition_order_page() throws Throwable {
	  RequisitionOrder ro= new RequisitionOrder(dr);
	  ro.openRequisitionOrder();
  }

  @Then("^verify requisition order page$")
  public void verify_requisition_order_page() throws Throwable {
	  RequisitionOrder ro= new RequisitionOrder(dr);
	  ro.verifyPage(schoolname, scenario);
  }
  
//purchase order
  @When("^user open purchase order page$")
  public void user_open_purchase_order_page() throws Throwable {
	  PurchaseOrder po= new PurchaseOrder(dr);
	  po.openPurchaseOrder();
  }

  @Then("^verify purchase order page$")
  public void verify_purchase_order_page() throws Throwable {
	  PurchaseOrder po= new PurchaseOrder(dr);
	  po.verifyPage(schoolname, scenario);
  }

//stock in entry
  @When("^user open stock in entry page$")
  public void user_open_stock_in_entry_page() throws Throwable {
	  StockInEntry se= new StockInEntry(dr);
	  se.openStockInEntry();
  }

  @Then("^verify stock in entry page$")
  public void verify_stock_in_entry_page() throws Throwable {
	  StockInEntry se= new StockInEntry(dr);
	  se.verifyPage(schoolname, scenario);
  }

//stock bill entry
  @When("^user open stock bill entry page$")
  public void user_open_stock_bill_entry_page() throws Throwable {
	  StockBillEntry sbe= new StockBillEntry(dr);
	  sbe.openStockBillEntry();
  }

  @Then("^verify stock bill entry page$")
  public void verify_stock_bill_entry_page() throws Throwable {
	  StockBillEntry sbe= new StockBillEntry(dr);
	  sbe.verifyPage(schoolname, scenario);
  }
  
//purchase return entry
  @When("^user open purchase return entry page$")
  public void user_open_purchase_return_entry_page() throws Throwable {
	  PurchaseReturnEntry pre= new PurchaseReturnEntry(dr);
	  pre.openPurchaseReturnEntry();
  }

  @Then("^verify purchase return entrypage$")
  public void verify_purchase_return_entrypage() throws Throwable {
	  PurchaseReturnEntry pre= new PurchaseReturnEntry(dr);
	  pre.verifyPage(schoolname, scenario);
  }
  
//stock issue
  @When("^user open stock issue page$")
  public void user_open_stock_issue_page() throws Throwable {
	  StockIssue si= new StockIssue(dr);
	  si.openStockIssue();
  }

  @Then("^verify stock issue page$")
  public void verify_stock_issue_page() throws Throwable {
	  StockIssue si= new StockIssue(dr);
	  si.verifyPage(schoolname, scenario);
  }
  
//stock return
  @When("^user open stock return page$")
  public void user_open_stock_return_page() throws Throwable {
	  StockReturn sr= new StockReturn(dr);
	  sr.openStockReturn();
  }

  @Then("^verify stock return page$")
  public void verify_stock_return_page() throws Throwable {
	  StockReturn sr= new StockReturn(dr);
	  sr.verifyPage(schoolname, scenario);
  }
  
//asset opening entry
  @When("^user open asset opening entry page$")
  public void user_open_asset_opening_entry_page() throws Throwable {
	  AssetOpeningEntry aoe= new AssetOpeningEntry(dr);
	  aoe.openAssetOpeningEntry();
  }

  @Then("^verify asset opening entry page$")
  public void verify_asset_opening_entry_page() throws Throwable {
	  AssetOpeningEntry aoe= new AssetOpeningEntry(dr);
	  aoe.verifyPage(schoolname, scenario);
  }
  
//opening quantity
  @When("^user open opening quantity page$")
  public void user_open_opening_quantity_page() throws Throwable {
	  OpeningQuantity oq= new OpeningQuantity(dr);
	  oq.openOpeningQuantity();
  }

  @Then("^verify opening quantity page$")
  public void verify_opening_quantity_page() throws Throwable {
	  OpeningQuantity oq= new OpeningQuantity(dr);
	  oq.verifyPage(schoolname, scenario);
  }
  
//stock return item wise
  @When("^user open stock return item wise page$")
  public void user_open_stock_return_item_wise_page() throws Throwable {
	  StockReturnItemWise sriw= new StockReturnItemWise(dr);
	  sriw.openOpeningQuantity();
  }

  @Then("^verify stock return item wise page$")
  public void verify_stock_return_item_wise_page() throws Throwable {
	  StockReturnItemWise sriw= new StockReturnItemWise(dr);
	  sriw.verifyPage(schoolname, scenario);
  }
  
//multiple stock issue
  @When("^user open multiple stock issue page$")
  public void user_open_multiple_stock_issue_page() throws Throwable {
	  MultipleStockIssue msi= new MultipleStockIssue(dr);
	  msi.openMultipleStockIssue();
  }

  @Then("^verify multiple stock issue page$")
  public void verify_multiple_stock_issue_page() throws Throwable {
	  MultipleStockIssue msi= new MultipleStockIssue(dr);
	  msi.verifyPage(schoolname, scenario);
  }

//stock destroy
  @When("^user open stock destroy page$")
  public void user_open_stock_destroy_page() throws Throwable {
     
  }

  @Then("^verify stock destroy page$")
  public void verify_stock_destroy_page() throws Throwable {
    
  }
}
