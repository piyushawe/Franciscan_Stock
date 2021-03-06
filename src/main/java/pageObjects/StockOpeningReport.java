package pageObjects;

import java.io.IOException;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StockOpeningReport {
	WebDriver dr;
	 String r="StockOpeningReport";
	 Utility u= new Utility();
	  
	 @FindBy(id="ContentPlaceHolder1_txtfromDate_TextBox")WebElement ondated;
	 @FindBy(id="ContentPlaceHolder1_ddlItem")WebElement itemname;
	 @FindBy(id="ContentPlaceHolder1_ddlBrand")WebElement brandname;	 
	 @FindBy(id="ContentPlaceHolder1_Button1")WebElement show;
	 
	 public StockOpeningReport(WebDriver d)
	 {
		 this.dr=d;
		 PageFactory.initElements(d, this);
	 }
	 public void openStockOpeningReport()
	 {
		WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
		Actions builder= new Actions(dr);
		builder.moveToElement(menu).build().perform();
	    dr.findElement(By.linkText("Stock Opening Report")).click();
	    dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/Report/Stock/RptOpeningStockReport.aspx']")));
	 }
	 public void selectOnDated(String mm, String yy, String dd) throws InterruptedException
	 {
		 u.selectDate(dr,ondated,mm,yy,dd);
	 }
	 public void selectItemName(String iname)
	 {
		 new Select(itemname).selectByVisibleText(iname);
	 }
	 public void selectBrandName(String bname)
	 {
		 new Select(brandname).selectByVisibleText(bname);
	 }
	 public void clickShow(String str, Collection<String>sc ) throws InterruptedException, IOException
	 {
		show.click();
		u.verifyShow(dr, str, r, sc);
		Thread.sleep(5000);
		u.captureScreenshot(dr, str, r,sc);
	 }
}
