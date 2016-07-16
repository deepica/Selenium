import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AmazonExecEng extends AmazonAutomation {
	
		public static void main(String[] args) throws IOException, InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
			
			
			String[][] recdata =AmazonAutomation.readExcel("C:/Users/Deepika/Documents/AbhiClass/SeleniumTest/TestData/Testsuite.xls", "Sheet1");
			
			String automationscript;
			String RunNoRun;
			
			for(int i=1;i<recdata.length;i++)
			{
				RunNoRun = recdata[i][1];
				if(RunNoRun.equalsIgnoreCase("Y"))
				{
					automationscript=recdata[i][2];
			
					/*Java Reflection*/
					Method ts = AmazonAutomation.class.getMethod(automationscript);
					ts.invoke(ts);
				}
			}
		
		//AmazonExecEng.LaunchApp();
		//AmazonExecEng.VerifyDropDwnOp();
		//AmazonExecEng.SearchButton();
		//AmazonExecEng.VerifyColOnLeft();
		//AmazonExecEng.CompNAccs();
		//AmazonExecEng.ElectronicsHeader();
		//AmazonExecEng.CheckMainTab();
		//AmazonExecEng.ValidateDeptList();	
		//AmazonExecEng.VerifyDispColLeft();
	}

}
