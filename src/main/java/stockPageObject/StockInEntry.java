package stockPageObject;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Utility;

public class StockInEntry {
  WebDriver dr;
  String pg="StockInEntry";
  Utility u= new Utility();
											  
  public StockInEntry(WebDriver d)
  {
	  this.dr=d;
	  PageFactory.initElements(d, this); 
  }
  public void openStockInEntry()
  {
	  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Stock.png']"));
 	  Actions builder= new Actions(dr);
	  builder.moveToElement(menu).build().perform();
	  dr.findElement(By.linkText("Stock In Entry")).click();
	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/StockManager/stockinentry.aspx']")));
	  verifyWithWithoutPurchaseOrder();
  }
  public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
  {
	  dr.findElement(By.xpath("//div[@class='content']")).click();
	  Thread.sleep(1000);
	  u.captureScreenshot(dr,schl,pg,sc);
  }
  public void verifyWithWithoutPurchaseOrder()
  {
	  List<WebElement>purchaseorder= dr.findElements(By.name("ctl00$ContentPlaceHolder1$PO"));
	  boolean flag= true;
	  int i=0;
	  for(WebElement porder:purchaseorder)
	  {
		  if(purchaseorder.get(i).isSelected())
			  flag=true;
		  i++;
	  }
	  if(flag)
		  System.out.println("Setting Type is selected");
	  else
		  System.out.println("Setting Type is not selected");
  }
}
