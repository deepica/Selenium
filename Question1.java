import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Question1 {
	
	public static void main(String[] Args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.wellsfargo.com/");
		
		Thread.sleep(5000);
		
		WebElement PersonalTab = driver.findElement(By.xpath(".//*[@id='tabNav']/ul/li[1]"));
		if(PersonalTab.isDisplayed()){
			if(PersonalTab.isEnabled())
			{
				System.out.println("Personal tab is selected");
			}
			else
			{
				System.out.println("Personal tab not selected");
			}
		}
		else{
			System.out.println("There is no Personal Tab, please check application");
		}
		
		Thread.sleep(5000);
		
		WebElement AboutWF = driver.findElement(By.xpath(".//*[@id='headerTools']/nav/ul/li[2]/a"));
		if(AboutWF.isDisplayed()){
			AboutWF.click();
			System.out.println("About page link is clicked");
		}
		else{
			System.out.println("About page link not available");
		}
		
		WebElement AboutWFPage = driver.findElement(By.xpath(".//*[@id='headerTools']/nav/ul/li[2]"));
		if(AboutWFPage.isEnabled()){
			System.out.println("You are on the About Wells Fargo page");
		}
		else{
			System.out.println("You are not on About Wells Fargo page");
		}
		
		Thread.sleep(5000);
		
		String ExpectedHead = "About Wells Fargo";
		
		WebElement WFAboutHead = driver.findElement(By.xpath(".//*[@id='shell']/div[1]/h1"));
		String ActualHead =WFAboutHead.getText();
		
		System.out.println(ActualHead);
		if(ActualHead.equals(ExpectedHead)){
			System.out.println("The expected Heading '"+ExpectedHead + "'matches the actual heading '" + ActualHead );
		}
		
		Thread.sleep(4000);
		
		WebElement HomePage = driver.findElement(By.xpath(".//*[@id='brand']/a/img"));
		HomePage.click();
		System.out.println("You are on the home page");
		
		Thread.sleep(10000);
		
		WebElement PersonalTab1 = driver.findElement(By.xpath(".//*[@id='tabNav']/ul/li[1]"));
		if(PersonalTab1.isDisplayed()){
			if(PersonalTab1.isEnabled())
			{
				System.out.println("Personal tab is selected");
			}
			else
			{
				System.out.println("Personal tab not selected");
			}
		}
		else{
			System.out.println("There is no Personal Tab, please check application");
		}
		
		WebElement InsuranceTab = driver.findElement(By.xpath(".//*[@id='insuranceTab']/a"));
		if(InsuranceTab.isDisplayed()){
			InsuranceTab.click();
			System.out.println("Insurance tab clicked");
			
			WebElement HomeOwners = driver.findElement(By.xpath(".//*[@id='insurance']/div[1]/div[2]/ul/li[1]/a"));
			HomeOwners.click();
			System.out.println("Home Owners link clicked");
			
		}
		else
			System.out.println("There is no Insurance Tab");
		
		Thread.sleep(5000);
		
		WebElement ZipCode = driver.findElement(By.xpath(".//*[@id='zipCode']"));
		ZipCode.sendKeys("95120");
		System.out.println("ZipCode is entered");
		
		Thread.sleep(5000);
	
		driver.quit();
	}

}
