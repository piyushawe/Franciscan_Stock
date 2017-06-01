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

public class StockReturnItemWise {
  WebDriver dr;
  String pg="StockReturnItemWise";
  Utility u= new Utility();
															  
  public StockReturnItemWise(WebDriver d)
  {
	  this.dr=d;
	  PageFactory.initElements(d, this); 
  }
  public void openOpeningQuantity()
  {
	  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Stock.png']"));
 	  Actions builder= new Actions(dr);
	  builder.moveToElement(menu).build().perform();
	  dr.findElement(By.linkText("Stock Return Item Wise")).click();
	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/StockManager/BulkStockReturn.aspx']")));
  }
  public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
  {
	  dr.findElement(By.xpath("//div[@class='content']")).click();
	  Thread.sleep(1000);
	  u.captureScreenshot(dr,schl,pg,sc);	
	  verifyStaffType();
  }
  public void verifyStaffType()
  {
	  List<WebElement>stafftype= dr.findElements(By.name("ctl00$ContentPlaceHolder1$PO"));
	  boolean flag= true;
	  int i=0;
	  for(WebElement stype:stafftype)
	  {
		  if(stafftype.get(i).isSelected())
			  flag=true;
		  i++;
	  }
	  if(flag)
		  System.out.println("Staff type is selected");
	  else
		  System.out.println("Staff type is not selected");
  }
}
