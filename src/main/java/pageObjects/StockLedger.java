package pageObjects;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StockLedger {
  WebDriver dr;
  String r="StockLedger";
  Utility u= new Utility();
	  
  @FindBy(id="ContentPlaceHolder1_txtfromDate_TextBox")WebElement fromdate;
  @FindBy(id="ContentPlaceHolder1_txttoDate_TextBox")WebElement todate;
  @FindBy(id="ContentPlaceHolder1_Button1")WebElement show;
	  
  public StockLedger(WebDriver d)
  {
	this.dr=d;
	PageFactory.initElements(d, this);
  }
  public void openStockLedger()
  {
	WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	Actions builder= new Actions(dr);
	builder.moveToElement(menu).build().perform();
	dr.findElement(By.linkText("Stock Ledger")).click();
	dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/Report/Stock/RptStockLedger.aspx']")));
  }
  public void selectFromDate(String mm, String yy, String dd) throws InterruptedException
  {
	u.selectDate(dr,fromdate,mm,yy,dd);
  }
  public void selectToDate(String mm, String yy, String dd) throws InterruptedException
  {
	u.selectDate(dr,todate,mm,yy,dd);
  }  
  public void selectCategory(String c) throws InterruptedException
  {
	dr.findElement(By.xpath("//*[@id=\"MainLeftPanel\"]/div/div[3]/div/button")).click();  
	if(c.equals("All"))
		dr.findElement(By.xpath("/html/body/div[3]/div/ul/li[1]/a")).click();
	else
	{
	   WebElement select= dr.findElement(By.xpath("/html/body/div[3]/ul"));
	   List<WebElement>options= select.findElements(By.tagName("span"));
	   for(WebElement option:options)
	   {
		   if(c.equals(option.getText()))
			   option.click();
	   }
	}Thread.sleep(2000);
  }
  public void selectSubCategory(String c) throws InterruptedException
  {
	dr.findElement(By.xpath("//*[@id=\"MainLeftPanel\"]/div/div[4]/div/button")).click();  
	if(c.equals("All"))
		dr.findElement(By.xpath("/html/body/div[4]/div/ul/li[1]/a")).click();
	else
	{
	   WebElement select= dr.findElement(By.xpath("/html/body/div[4]/ul"));
	   List<WebElement>options= select.findElements(By.tagName("span"));
	   for(WebElement option:options)
	   {
		   if(c.equals(option.getText()))
			   option.click();
	   }
	}Thread.sleep(2000);
  }
  public void selectItem(String itm)
  {
	dr.findElement(By.xpath("//*[@id=\"MainLeftPanel\"]/div/div[5]/div/button")).click();
	if(itm.equals("All"))
	  dr.findElement(By.xpath("/html/body/div[5]/div/ul/li[1]/a")).click();
	else
	{
	  WebElement select= dr.findElement(By.xpath("/html/body/div[5]/ul"));
	  List<WebElement>options= select.findElements(By.tagName("span"));
	  for(WebElement option:options)
	  {
	    if(itm.equals(option.getText()))
			  option.click();
	  }
   }dr.findElement(By.xpath("/html/body/div[5]/div/ul/li[3]")).click();
  }
  public void selectBrandName(String bname)
  {
	dr.findElement(By.xpath("//*[@id=\"MainLeftPanel\"]/div/div[6]/div/button")).click();
	if(bname.equals("All"))
	  dr.findElement(By.xpath("/html/body/div[6]/div/ul/li[1]/a")).click();
	else
	{
	  WebElement select= dr.findElement(By.xpath("/html/body/div[6]/ul"));
	  List<WebElement>options= select.findElements(By.tagName("span"));
	  for(WebElement option:options)
	  {
	    if(bname.equals(option.getText()))
			  option.click();
	  }
   }dr.findElement(By.xpath("/html/body/div[6]/div/ul/li[3]")).click();
  }
  public void clickShow(String str, Collection<String>sc ) throws InterruptedException, IOException
  {
	show.click();
	Thread.sleep(5000);
	 u.captureScreenshot(dr, str, r,sc);
  }
}
