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

public class ItemMasterReport {
  WebDriver dr;
  String r="ItemMasterReport_";
  Utility u= new Utility();
  
  @FindBy(id="ContentPlaceHolder1_ddlCatId")WebElement category;
  @FindBy(id="ContentPlaceHolder1_ddlSubCatId")WebElement subcategory;
  @FindBy(name="ctl00$ContentPlaceHolder1$SingleButton1$ctl00")WebElement show;
  
  public ItemMasterReport(WebDriver d)
  {
	  this.dr=d;
	  PageFactory.initElements(d, this);
  }
  public void openItemMasterReport()
  {
	  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	  Actions builder= new Actions(dr);
	  builder.moveToElement(menu).build().perform();
	  dr.findElement(By.linkText("Item Master Report")).click();
	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/Report/Stock/ItemMasterReport.aspx']")));
  }
  public void selectCategory(String c)
  {
	  new Select(category).selectByVisibleText(c);
  }
  public void selectSubCategory(String subc)
  {
	  new Select(subcategory).selectByVisibleText(subc);
  }
  public void clickShow(String str, Collection<String>sc ) throws InterruptedException, IOException
  {
	show.click();
	Thread.sleep(5000);
	 u.captureScreenshot(dr, str, r,sc);
  }
}
