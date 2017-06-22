package globalMastersPageObject;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;
import pageObjects.Utility;

public class DefineItems {
  WebDriver dr;
  String pg="DefineItems";
  Utility u= new Utility();

  @FindBy(id="ContentPlaceHolder1_ddlItemCategory")WebElement itemcategory;
  @FindBy(id="ContentPlaceHolder1_ddlItemSubCat")WebElement subcategory;
  @FindBy(id="ContentPlaceHolder1_txtItemName_TextBox")WebElement itemname;
  @FindBy(id="ContentPlaceHolder1_txtItemCode_TextBox")WebElement itemcode;
  @FindBy(id="ContentPlaceHolder1_ddlUnit")WebElement unit;
  @FindBy(id="ContentPlaceHolder1_txtMaxQty_TextBox")WebElement maximumquantity;
  @FindBy(id="ContentPlaceHolder1_txtMinQty_TextBox")WebElement minimumquantity;
  @FindBy(id="ContentPlaceHolder1_chkIsFixedAsset")WebElement isfixedasset;
  @FindBy(id="ContentPlaceHolder1_BtnControls1_btnSave")WebElement save;
  @FindBy(id="ContentPlaceHolder1_BtnControls1_btnView")WebElement view;

  public DefineItems(WebDriver d)
  {
	  this.dr=d;
	  PageFactory.initElements(d, this); 
  }
  public void openDefineItems()
  {
      WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Global-Masters.png']"));
 	  Actions builder= new Actions(dr);
	  builder.moveToElement(menu).build().perform();
	  dr.findElement(By.linkText("Define Items")).click();
	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/StockManager/DefineItem.aspx']")));
  }
  public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
  {
     dr.findElement(By.xpath("//div[@class='content']")).click();
	 Thread.sleep(1000);
	 u.captureScreenshot(dr,schl,pg,sc);
  }
  public void selectItemCategory() throws InterruptedException {
      new Select(itemcategory).selectByIndex(1);
      Thread.sleep(500);
  }
  public void selectSubCategory()
  {
      new Select(subcategory).selectByIndex(1);
  }
  public void enterItemName(String iname)
  {
      itemname.sendKeys(iname);
  }
  public void enterItemCode(String icode)
  {
      itemcode.sendKeys(icode);
  }
  public void selectUnit()
  {
      new Select(unit).selectByIndex(1);
  }
  public void enterMaximumQuantity(String maxq)
  {
      maximumquantity.sendKeys(maxq);
  }
  public void enterMinimumQuantity(String minq)
  {
      minimumquantity.sendKeys(minq);
  }
  public void selectIsFixedAsset()
  {
      isfixedasset.click();
  }
  public void clickSave(String school, Collection<String> sc)throws IOException
  {
      save.click();
      u.verifySave(dr, school, pg, sc);
  }
  public void clickView(String school, Collection<String> sc)throws IOException
  {
      view.click();
      WebElement table= dr.findElement(By.id("example"));
      List<WebElement> cells= table.findElements(By.tagName("td"));
      if (cells.size()>1) {
          for (WebElement cell : cells) {
              cell.findElement(By.xpath("//input[starts-with(@id,'ContentPlaceHolder1_rptView')]")).click();
              break;
          }
          dr.findElement(By.id("ContentPlaceHolder1_BtnControls1_btnModify")).click();
      }else
          System.out.println("No record Found");
      u.verifyView(dr,school, pg, sc);
  }
}
