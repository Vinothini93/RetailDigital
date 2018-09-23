package utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DynamicData {
	
	public static String sTestCaseName;
	public static int iTestCaseRow;
	public static String driverPath = "C://Users//dell//Desktop//2018//";
	public static String SheetName;;
	
	
	 @DataProvider(name="Auth")
	 
	  public static Object[][] demo(Method m) throws Exception{
	 
		    // Setting up the Test Data Excel filea 
		 
		 System.out.println("THE TEST SHEETNAME:"+SheetName);
	 
		 	ExcelUtils.setExcelFile("C:\\Users\\dell\\Desktop\\2018\\SignOn.xlsx",SheetName);
	 
		 	
	 
		  	// From above method we get long test case name including package and class name etc.
	 
		  	// The below method will refine your test case name, exactly the name use have used
	 
		  	sTestCaseName = ExcelUtils.getTestCaseName(m.getName());
	 
		    // Fetching the Test Case row number from the Test Data Sheet
	 
		    // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
	 
		 	iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
	 
		    Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\dell\\Desktop\\2018\\SignOn.xlsx",SheetName,iTestCaseRow);
	 
		    	return (testObjArray);
	 
			}
	 
}
