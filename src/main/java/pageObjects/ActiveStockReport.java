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

public class ActiveStockReport {
	WebDriver dr;
	String r="ActiveStockReport";
	Utility u= new Utility();
	
	@FindBy(id="ContentPlaceHolder1_txtfromDate_TextBox")WebElement fromdate;
	@FindBy(id="ContentPlaceHolder1_txtToDate_TextBox")WebElement todate;
	@FindBy(id="ContentPlaceHolder1_ddlCatId")WebElement category;
	@FindBy(id="ContentPlaceHolder1_ddlSubCatId")WebElement subcategory;
	@FindBy(id="ContentPlaceHolder1_ddlItem")WebElement itemname;
	@FindBy(id="ContentPlaceHolder1_ddlBrand")WebElement brandname;
	@FindBy(id="ContentPlaceHolder1_Button1")WebElement show;
	
	public ActiveStockReport(WebDriver d)
	{
		this.dr=d;
		PageFactory.initElements(d, this);
	}
	public void openActiveStockReport()
	{
		WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
		Actions builder= new Actions(dr);
		builder.moveToElement(menu).build().perform();
	    dr.findElement(By.linkText("Active Stock Report")).click();
	    dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/Report/Stock/RptClosingStockReport.aspx']")));
	}
	public void selectFromDate(String mm, String yy, String dd) throws InterruptedException
	{
		u.selectDate(dr,fromdate,mm,yy,dd);
	}
	public void selectToDate(String mm, String yy, String dd) throws InterruptedException
	{
		u.selectDate(dr,todate,mm,yy,dd);
	}
	public void selectCategory(String c)
	{
		new Select(category).selectByVisibleText(c);
	}
	public void selectSubCategory(String subc)
	{
		new Select(subcategory).selectByVisibleText(subc);
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
