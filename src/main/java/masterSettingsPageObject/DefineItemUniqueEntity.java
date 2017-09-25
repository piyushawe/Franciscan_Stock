package masterSettingsPageObject;

import java.io.IOException;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Utility;

public class DefineItemUniqueEntity {
   WebDriver dr;
   String pg="DefineItemUniqueEntity";
   Utility u= new Utility();
			  
   public DefineItemUniqueEntity(WebDriver d)
   {
	  this.dr=d;
	  PageFactory.initElements(d, this); 
   }
   public void openDefineItemUniqueEntity()
   {
      WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Master-Settings.png']"));
 	  Actions builder= new Actions(dr);
	  builder.moveToElement(menu).build().perform();
	  dr.findElement(By.linkText("Define Item Unique Identity")).click();
	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/StockManager/ItemUniqueIdentity.aspx']")));
   }
   public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
   {
	  dr.findElement(By.xpath("//div[@class='content']")).click();
	  Thread.sleep(1000);
	  u.captureScreenshot(dr,schl,pg,sc);
   }
}
