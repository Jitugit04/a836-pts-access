package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class A836Page {

	WebDriver driver;

	public A836Page(WebDriver driver)

	{
		this.driver = driver;

	}

	// OwnerSite
	private String xpath_agree = "//*[@id='btAgree']";
	private String xpath_borough = "//*[@id='inpParid']";
	private String xpath_block = "//*[@id='inpTag']";
	private String xpath_lot = "//*[@id='inpStat']";
	private String xpath_search = "//*[@id='btSearch']";

	private String xpath_result = "//*[@id='datalet_header_row']";
	private String xpath_failure_result = "//*[@id='frmMain']//div[@class='contentpanel']//p[contains(text(), 'Your search did not find any records')]";


	public void clickAgree() {
		WebElement agreeElement = driver.findElement(By.xpath(xpath_agree));
		agreeElement.click();
	}

	public void selectBorough(int borough) {
		WebElement boroughElement = driver.findElement(By.xpath(xpath_borough));
		Select boroughDropdown = new Select(boroughElement);
		boroughDropdown.selectByIndex(borough);
	}

	public void setBlock(int block) {
		WebElement blockElement = driver.findElement(By.xpath(xpath_block));
		blockElement.sendKeys("" + block);
	}

	public void setLot(int lot) {
		WebElement blockElement = driver.findElement(By.xpath(xpath_lot));
		blockElement.sendKeys("" + lot);
	}

	public void clickSearch() {
		WebElement searchElement = driver.findElement(By.xpath(xpath_search));
		searchElement.click();
	}

	public boolean checkIfResultFound() throws InterruptedException {
		Thread.sleep(2000);
		WebElement resultElement = null;
		try {
			resultElement = driver.findElement(By.xpath(xpath_failure_result));
			System.out.println("resultElement.isDisplayed(): " + resultElement.isDisplayed());
		} catch (NoSuchElementException e ) {
			System.out.println(" Failure response element not found ");
		}
		if (resultElement != null && resultElement.isDisplayed()) {
			return false;
		}
		return true;

	}

}
