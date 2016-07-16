import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ReUsableMethodAmazon{
	//	static WebDriver driver;
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;
	
	
	/*Name of the method:Enterext
	 * desciption: Enter text into text box
	 * Arguments obj -->WebElement(Object, Text to be entered,objName->object name
	 * Created by: TechPirates
	 * Creation date :7/4/2016
	 * Updation date: 7/4/2016
	 */
	public static void EnterText(WebElement obj, String TextVal, String objName) throws IOException{
		
		if(obj.isDisplayed())
		{
			obj.sendKeys(TextVal);
			Update_Report("Pass", "EnterText", TextVal + "is entered in " + objName + "field");
		}
		else
		{
			Update_Report("Fail", "EnterText", objName + "  field is not displayed please check your application");
		}
		
	}
	
	/*Name of the method:ClickElement
	 * desciption: Click an element
	 * Arguments obj -->WebElement(Object, Text to be entered,objName->object name
	 * Created by: TechPirates
	 * Creation date :7/4/2016
	 * Updation date: 7/4/2016
	 */
	
	public static void ClickElement(WebElement obj, String objName) throws IOException
	{
		if(obj.isDisplayed()){
			obj.click();
			Update_Report("Pass", "ClickElement", objName + "button is clicked");
		}
		else
		{
			Update_Report("fail", "ClickElement", objName + "button not displayed");
		}
	}
	
	/*Name of the method:ValidateTextMsg
	 * desciption: Validating a text message
	 * Arguments obj -->WebElement(Object, expected message,objName->object name
	 * Created by: TechPirates
	 * Creation date :7/4/2016
	 * Updation date: 7/4/2016
	 */
	public static void validateTextMsg(WebElement Obj, String expectedTextMsg, String ObjName) throws IOException
	{
		if(Obj.isDisplayed()){
		String ActualTextMsg = Obj.getText().trim();
		if(expectedTextMsg.equals(ActualTextMsg)){
			Update_Report("Pass", "ValidateTextMsg ", "Actual Text message match with expected Text message " + ActualTextMsg);
		}else{
			Update_Report("Fail", "ValidateTextMsg", "Actual Text message '" + ActualTextMsg + "' is not matching with expected text message '"+ expectedTextMsg +"'.");
		}
		}
		else
			{
			Update_Report("Fail", "ValidateTextMsg", ObjName+" is not displayed");
			}
	}
	
	/*Name of the method:SelectCheckBox
	 * desciption: Selecting a check box
	 * Arguments obj -->WebElement, ObjName->object name
	 * Created by: TechPirates
	 * Creation date :7/4/2016
	 * Updation date: 7/4/2016
	 */
	public static void SelectCheckBox(WebElement Obj, String ObjName) throws IOException 
	{
		if(Obj.isDisplayed())
		{
			if(Obj.isSelected())
			{
				Update_Report("Pass", "SelectCheckBox", ObjName+ "Check box is already selected");
			}
			else
			{
				Obj.click();
				Update_Report("Pass", "Select Check Box", ObjName+ "Check box is selected");
			}
		}
		else{
			Update_Report("Fail", "Select Check Box", ObjName+ "is not displayed");
		}
	}
	
	/*Name of the method:DeSelectCheckBox
	 * desciption: DeSelecting a check box
	 * Arguments obj -->WebElement, ObjName->object name
	 * Created by: TechPirates
	 * Creation date :7/4/2016
	 * Updation date: 7/4/2016
	 */
	public static void DeSelectCheckBox(WebElement Obj, String ObjName) throws IOException 
	{
		if(Obj.isDisplayed())
		{
			Update_Report("Pass", "DeselectCheckBox", ObjName+ "the check box is displayed");
			if(Obj.isSelected())
			{
				Obj.click();
				Update_Report("Pass", "DeSelectCheckBox", ObjName+ "the check box is deselected");
			}
			else
			{
				Update_Report("Pass", "DeSelectCheckBox", ObjName+ "the check box is already deselected");
			}
		}
		else
		{ 
			Update_Report("Fail", "DeselectCheckBox", ObjName+ "the check box is not displayed");
		}
		
	}

	/*Name of the method:CheckifAvailable
	 * desciption: To check if a link is available
	 * Arguments: obj -->WebElement, ObjName->object name
	 * Created by: TechPirates
	 * Creation date :7/15/2016
	 * Updation date: 7/15/2016
	 */	
	public static void CheckifAvailable(WebElement Obj, String ObjName) throws IOException {
		if(Obj.isDisplayed()){
			Update_Report("Pass", "YourAmazon link", ObjName+ " link is displayed");
		}
		else{
			Update_Report("Fail", "YourAmazon link", ObjName+ " link is not displayed");
		}
		
	}
	
	/*Name of the method:readExcel
	 * desciption: Reading from an Excel file
	 * Arguments: Path -->dtTablePath, sheetName
	 * Created by: TechPirates
	 * Creation date :7/15/2016
	 * Updation date: 7/15/2016
	 */		
public static String[][] readExcel(String dtTablePath, String sheetName) throws IOException{
		
		
		File xlFile = new File(dtTablePath);
		
		FileInputStream xlDoc = new FileInputStream(xlFile);
		
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);
		
		HSSFSheet sheet =wb.getSheet(sheetName);
		
		int iRowCount = sheet.getLastRowNum()+1;
		int icolCount = sheet.getRow(0).getLastCellNum();
		
		String[][] xlData = new String[iRowCount][icolCount];
		
		for(int i=0;i<iRowCount;i++){
			for(int j=0;j<icolCount;j++){
				xlData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		return xlData;	
	}


	@Test
	public void test() throws Exception {

		startReport("Decending order sort","C:/Users/Deepika/Documents/AbhiClass/XeroTest/Report");

		Update_Report( "Pass", "Decending order sort",  "Decending order sort executing is complete.");
		
		
		bw.close();


	}


	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";



		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


	}

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");

		} 
	}
}

