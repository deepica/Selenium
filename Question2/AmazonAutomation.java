import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AmazonAutomation extends ReUsableMethodAmazon {
	
	static WebDriver driver;
	static WebDriver wait;
	
	//Test ID 001
	public static void LaunchApp() throws IOException {
		
		startReport("LaunchApp", "C:/Users/Deepika/Documents/AbhiClass/SeleniumTest/Report");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");
		Update_Report("Pass", "Launch Amazon application", "Amazon application launched");
		
		driver.manage().window().maximize();
		
		bw.close();
		driver.quit();
		
	}
	
	//Test ID 002
	public static void VerifyDropDwnOp() throws IOException, InterruptedException {
		
		startReport("VerifyDropDwnOp", "C:/Users/Deepika/Documents/AbhiClass/SeleniumTest/Report");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");
		Update_Report("Pass", "Launch Amazon application", "Amazon application launched");
		
		driver.manage().window().maximize();
		
		
		WebElement SearchBox = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
		EnterText(SearchBox, "Iphone", "search");
		
		WebElement DropDownIphone1 = driver.findElement(By.xpath(".//*[@id='issDiv0']"));
		ClickElement(DropDownIphone1, "Dropdown1");
		Thread.sleep(5000);
		
		WebElement SearchBox1 = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
		SearchBox1.clear();
		EnterText(SearchBox1, "Iphone", "search");
		Thread.sleep(5000);
		
		WebElement DropDownIphone2 = driver.findElement(By.xpath(".//*[@id='issDiv1']"));
		ClickElement(DropDownIphone2, "Dropdown2");
		
		Thread.sleep(5000);
		
		WebElement SearchBox2 = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
		SearchBox2.clear();
		EnterText(SearchBox2, "Iphone", "search");
		Thread.sleep(5000);
		
		WebElement DropDownIphone3 = driver.findElement(By.xpath(".//*[@id='issDiv2']"));
		ClickElement(DropDownIphone3, "Dropdown3");
		
		Thread.sleep(5000);
		
		bw.close();
		driver.quit();
		
	}
	
	//Test ID 003
	public static void SearchButton() throws IOException {
		
		startReport("SearchButton", "C:/Users/Deepika/Documents/AbhiClass/SeleniumTest/Report");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");
		Update_Report("Pass", "Launch Amazon application", "Amazon application launched");
		
		driver.manage().window().maximize();
		
		WebElement SearchBox = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
		EnterText(SearchBox, "Iphone", "search");
		
		WebElement Searchbtn = driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input"));
		ClickElement(Searchbtn, "search button");
		
		bw.close();
		driver.quit();
	}
	
	//Test ID 004
	public static void VerifyColOnLeft() throws IOException, InterruptedException {
		
		startReport("ColOnLeft", "C:/Users/Deepika/Documents/AbhiClass/SeleniumTest/Report");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");
		Update_Report("Pass", "VerifyColOnLeft", "The required link is launched");
		
		Thread.sleep(5000);
		
		WebElement cellphones = driver.findElement(By.xpath(".//*[@id='s-result-count']/span/a"));
		if(cellphones.isDisplayed())
		{
			Update_Report("Pass", "Click on Cellphones Link", "Cellphone link is displayed");
			ClickElement(cellphones, "Cellphones option");
		}
		else
		{
			Update_Report("Fail", "Click on Cellphones Link", "Cellphone link is not displyed");
		}
		
		WebElement unlockedPh = driver.findElement(By.xpath(".//*[@id='nav-subnav']/a[3]/span"));
		if(unlockedPh.isDisplayed()){
				Update_Report("Pass", "Click Unlock phones", "Unlock phone is displayed");
				ClickElement(unlockedPh, "Unlocked option");
		}
		else
		{
			Update_Report("Fail", "Unlocked phone Link", "Unlocked phone link is not displayed");
		}
		
		WebElement CellAccs = driver.findElement(By.xpath(".//*[@id='nav-subnav']/a[5]/span"));
		if(CellAccs.isDisplayed()){
			Update_Report("Pass", "Cell phone Accessories Link", "Cell phone Accessories Link is displayed");
			ClickElement(CellAccs, "Cell phone Accessories Link");
		}
		else
		{
			Update_Report("Fail", "Cell phone Accessories Link", "Cell phone Accessories link is not displayed");
		}
		
		Thread.sleep(5000);
		
		WebElement CellCases = driver.findElement(By.xpath(".//*[@id='nav-subnav']/a[6]/span"));
		if(CellCases.isDisplayed()){
			Update_Report("Pass", "Cell phone Cases Link", "Cell phone Cases Link is displayed");
			ClickElement(CellCases, "Cell phone Cases Link");
		}
		else
		{
			Update_Report("Fail", "Cell phone Cases Link", "Cell phone Cases link is not displayed");
		}
		
		Thread.sleep(5000);
		
		WebElement SeeMore = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[8]/a/span"));
		if(SeeMore.isDisplayed()){
			Update_Report("Pass", "SeeMore", "SeeMore Link is displayed");
			ClickElement(SeeMore, "SeeMore Link");
		}
		else
		{
			Update_Report("Fail", "SeeMore Link", "SeeMore link is not displayed");
		}	
		Thread.sleep(5000);
		
		bw.close();
		driver.quit();	
	}
	
	//Test ID 005
	public static void CompNAccs() throws IOException {
		
		startReport("CompNAccs", "C:/Users/Deepika/Documents/AbhiClass/SeleniumTest/Report");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=computer");
		Update_Report("Pass", "CompNAccs", "The required link is launched");
		
		WebElement CompandAccs = driver.findElement(By.xpath(".//*[@id='s-result-count']/span/a[2]"));
		if(CompandAccs.isDisplayed()){
			Update_Report("Pass", "CompandAccs Link", "CompandAccs link is displayed");
			ClickElement(CompandAccs, "Computer and Accessories");
		}
		else{
			Update_Report("Fail", "CompandAccs Link", "CompandAccs link is not displayed");
		}
		
		bw.close();
		driver.quit();	
	}
	
	//Test ID 006
	public static void ElectronicsHeader() throws IOException, InterruptedException {
		startReport("ElectronicsHeader", "C:/Users/Deepika/Documents/AbhiClass/SeleniumTest/Report");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");
		Update_Report("Pass", "ElectronicsHeader", "The required link is launched");
		
		WebElement SmartWatches = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[8]/a/span[1]"));
		if(SmartWatches.isDisplayed()){
			Update_Report("Pass", "SmartWatches Link", "SmartWatches link is displayed");
			ClickElement(SmartWatches, "SmartWatches");
		}
		else{
			Update_Report("Fail", "SmartWatches Link", "SmartWatches link is not displayed");
		}
		Thread.sleep(5000);
		
		driver.get("https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");
		Thread.sleep(5000);
		
		WebElement PortBluTooth = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[7]/a/span[1]"));
		if(PortBluTooth.isDisplayed()){
			Update_Report("Pass", "PortBluTooth Link", "PortBluTooth link is displayed");
			ClickElement(PortBluTooth, "PortBluTooth");
		}
		else{
			Update_Report("Fail", "PortBluTooth Link", "PortBluTooth link is not displayed");
		}
		
		bw.close();
		driver.quit();
	}
	
	//Test ID 007
	public static void VerifyDispColLeft() throws IOException, InterruptedException {
		
		startReport("VerifyDispColLeft", "C:/Users/Deepika/Documents/AbhiClass/SeleniumTest/Report");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");
		Update_Report("Pass", "VerifyDispColLeft", "The required link is launched");
		
		driver.manage().window().maximize();
		
		Thread.sleep(10000);
		
		WebElement AmPrime = driver.findElement(By.xpath(".//*[@id='ref_2470954011']/li/a"));
		DeSelectCheckBox(AmPrime, "Amazon Prime");
		
		WebElement FreeShipping= driver.findElement(By.xpath(".//*[@id='refinements']/h2[3]"));
		CheckifAvailable(FreeShipping, "Eligible for Free Shipping");
		
		WebElement FreeShipAm = driver.findElement(By.xpath(".//*[@id='ref_2491144011']/li/a/span"));
		DeSelectCheckBox(FreeShipAm, "Free shipping by Amazon");
		
		WebElement Brand =driver.findElement(By.xpath(".//*[@id='refinements']/h2[4]"));
		CheckifAvailable(Brand, "Brand");
		
		WebElement BrandOptions = driver.findElement(By.xpath(".//*[@id='ref_2528832011']"));
		List<WebElement> AllBrOps =BrandOptions.findElements(By.tagName("li"));
		for(int i=0;i<AllBrOps.size();i++){
			CheckifAvailable(BrandOptions, "Brand Options");
		}
		
		WebElement InterMem = driver.findElement(By.xpath(".//*[@id='refinements']/h2[6]"));
		CheckifAvailable(InterMem, "Internal memory");
		
		WebElement InterMemOptions = driver.findElement(By.xpath(".//*[@id='ref_7805160011']"));
		List<WebElement> AllInterMemOps =BrandOptions.findElements(By.tagName("li"));
		for(int i=0;i<AllInterMemOps.size();i++){
			CheckifAvailable(InterMemOptions, "Internal Memeory Options");
		}
		
		WebElement DisplaySize =driver.findElement(By.xpath(".//*[@id='refinements']/h2[10]"));
		CheckifAvailable(DisplaySize, "DisplaySize");
		
		WebElement DisplaySizeOptions = driver.findElement(By.xpath(".//*[@id='ref_6215726011']"));
		List<WebElement> AllDisplaySize =DisplaySizeOptions.findElements(By.tagName("li"));
		for(int i=0;i<AllDisplaySize.size();i++){
			CheckifAvailable(DisplaySizeOptions, "DisplaySize Options");
		}
		
		WebElement Compatibility =driver.findElement(By.xpath(".//*[@id='refinements']/h2[12]"));
		CheckifAvailable(Compatibility, "Compatibility");
		
		WebElement CompatibilityOptions = driver.findElement(By.xpath(".//*[@id='ref_2488708011']"));
		List<WebElement> AllCompatibility =CompatibilityOptions.findElements(By.tagName("li"));
		for(int i=0;i<AllCompatibility.size();i++){
			CheckifAvailable(CompatibilityOptions, "Compatibility Options");
		}
		
		Thread.sleep(10000);
		
		/*WebElement AvgCustRev =driver.findElement(By.xpath(".//*[@id='refinements']/h2[15]"));
		CheckifAvailable(AvgCustRev, "AvgCustRev");
		
		WebElement AvgCustRevOptions = driver.findElement(By.xpath(".//*[@id='ref_2491147011']"));
		List<WebElement> AllAvgCustRev =AvgCustRevOptions.findElements(By.tagName("li"));
		for(int i=0;i<AllAvgCustRev.size();i++){
			CheckifAvailable(AvgCustRevOptions, "AvgCustRev Options");
		}*/
		
		bw.close();
		driver.quit();	
	}
	
	//Test ID 008
	public static void CheckMainTab() throws IOException, InterruptedException {
		
		startReport("CheckMainTab", "C:/Users/Deepika/Documents/AbhiClass/SeleniumTest/Report");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");
		Update_Report("Pass", "Launch Amazon application", "Amazon application launched");
		
		driver.manage().window().maximize();
		
		WebElement ShopByDept = driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
		CheckifAvailable(ShopByDept, "Shop by Department");
		
		WebElement YourAmazon = driver.findElement(By.xpath(".//*[@id='nav-your-amazon']"));
		CheckifAvailable(YourAmazon, "Your Amazon");
		
		WebElement TodaysDeal = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[2]"));
		CheckifAvailable(TodaysDeal, "Todays Deal");
		
		WebElement Giftcards = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[3]"));
		CheckifAvailable(Giftcards, "Gift cards");
		
		Thread.sleep(5000);
		WebElement Sell = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[4]"));
		CheckifAvailable(Sell, "Sell");
		
		Thread.sleep(5000);
		WebElement Help = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[5]"));
		CheckifAvailable(Help, "Help");
		
		WebElement HelloSignIn = driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']"));
		CheckifAvailable(HelloSignIn, "Hello..Sign In");
		
		WebElement TryPrime = driver.findElement(By.xpath(".//*[@id='nav-link-prime']"));
		CheckifAvailable(TryPrime, "Try Prime");
		
		WebElement YourLists = driver.findElement(By.xpath(".//*[@id='nav-link-wishlist']/span[2]"));
		CheckifAvailable(YourLists, "Your Lists");
		
		WebElement Cart = driver.findElement(By.xpath(".//*[@id='nav-cart']"));
		CheckifAvailable(Cart, "Cart");
		
		bw.close();
		driver.quit();
		
	}
	
	//Test ID 009
	public static void ValidateDeptList() throws Exception {
		
		/*List<String> expectedItems = new ArrayList<>(Arrays.asList("Amazon Video", "Digital & Prime Music", "Appstore for Android", "Amazon Photos & Drive", "Kindle E-readers & Books", 
				"Fire Tablets","Fire TV","Echo & Alexa","AmazonFresh","Books & Audible","Movies, Music & Games","Electronics & Computers","Home, Garden & Tools","Beauty, Health & Grocery",
				"Toys, Kids & Baby","Clothing, Shoes & Jewelry","Sports & Outdoors","Automotive & Industrial","Handmade","Home Services","Credit & Payment Products","Full Store Directory"));
		*/
		
		String[] expectedItems = {"Amazon Video", "Digital & Prime Music", "Appstore for Android", "Amazon Photos & Drive", "Kindle E-readers & Books", 
				"Fire Tablets","Fire TV","Echo & Alexa","AmazonFresh","Books & Audible","Movies, Music & Games","Electronics & Computers","Home, Garden & Tools","Beauty, Health & Grocery",
				"Toys, Kids & Baby","Clothing, Shoes & Jewelry","Sports & Outdoors","Automotive & Industrial","Handmade","Home Services","Credit & Payment Products","Full Store Directory"};
		
		startReport("ValidateDeptList", "C:/Users/Deepika/Documents/AbhiClass/SeleniumTest/Report");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");
		Update_Report("Pass", "Launch Amazon application", "Amazon application launched");
		
		driver.manage().window().maximize();
		
		//WebElement ShopByDept = driver.findElement(By.xpath(".//*[@id='nav-link-shopall']"));
		
		Actions action = new Actions(driver);    
		WebElement optionsList = driver.findElement(By.xpath(".//*[@id='nav-link-shopall']"));
		action.moveToElement(optionsList);

		List<WebElement> options = driver.findElements(By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]"));
		int size = options.size();
		for(int i =0; i<size; i++){
			System.out.println(options.get(i).getText()+ " ");
		}
			/*if(options.get(i).getText().equals(expectedItems[i]))
			{
				System.out.println("Done");
				Update_Report("Pass", "validateTextInDropdn",  "Expected menu item is: "  +expectedItems[i]+ " is matched to actual item: "+options.get(i).getText());
			}
			else{
				System.out.println("Not done");
				Update_Report("Fail", "validateTextInDropdn",  "Expected menu item is: "  +expectedItems[i]+ " is Not matched to actual item: "+options.get(i).getText());
			}
		}*/
	
		bw.close();
		driver.quit();
	}

}
