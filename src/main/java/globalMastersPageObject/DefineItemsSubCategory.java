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

public class DefineItemsSubCategory {
  WebDriver dr;
  String pg="DefineItemsSubCategory";
  Utility u= new Utility();

  @FindBy(id="ContentPlaceHolder1_ddlItemCatName")WebElement itemcategoryname;
  @FindBy(id="ContentPlaceHolder1_txtItemSubCat_TextBox")WebElement itemsubcategory;
  @FindBy(id="ContentPlaceHolder1_txtDescription_TextBox")WebElement description;
  @FindBy(id="ContentPlaceHolder1_BtnControls1_btnSave")WebElement save;
  @FindBy(id="ContentPlaceHolder1_BtnControls1_btnView")WebElement view;

  public DefineItemsSubCategory(WebDriver d)
  {
	  this.dr=d;
	  PageFactory.initElements(d, this); 
  }
  public void openDefineItemsSubCategory()
  {
      WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Global-Masters.png']"));
 	  Actions builder= new Actions(dr);
	  builder.moveToElement(menu).build().perform();
	  dr.findElement(By.linkText("Define Items Sub Category")).click();
	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/StockManager/DefineItemSubCategory.aspx']")));
  }
  public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
  {
	  dr.findElement(By.xpath("//div[@class='content']")).click();
	  Thread.sleep(1000);
	  u.captureScreenshot(dr,schl,pg,sc);
  }
  public void selectItemCategoryName()
  {
      new Select(itemcategoryname).selectByIndex(1);
  }
  public void enterItemSubCategory(String ictry)
  {
      itemsubcategory.sendKeys(ictry);
  }
  public void enterDescription(String desc)
  {
      description.sendKeys(desc);
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
              cell.findElement(By.xpath("//input[starts-with(@id,'ContentPlaceHolder1_rptItemGroup')]")).click();
              break;
          }
          dr.findElement(By.id("ContentPlaceHolder1_BtnControls1_btnModify")).click();
          dr.findElement(By.id("popup_ok")).click();
      }else
          System.out.println("No record Found");
      u.verifyView(dr,school, pg, sc);
  }
}
