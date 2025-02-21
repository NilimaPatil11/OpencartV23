package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
 

  @DataProvider(name="logindata")
  public String[][] getdata() throws IOException {
	
	  String path=("C://selenium training//OpencartV23//testData//logindata.xlsx");
	  
	  ExcelUtility xlutil=new ExcelUtility(path);
	  System.out.println(xlutil.path);
	  
	  int totalrows=xlutil.getRowCount("Sheet1");
	  System.out.println(totalrows);
	  int totalcolumns=xlutil.getCellCount("Sheet1", 1);
	 System.out.println(totalcolumns);
	  String logindata[][]=new String[totalrows][totalcolumns];
	  System.out.println(logindata);
	  for(int i=1;i<=totalrows;i++)
		  
	  {
		  for(int j=0;j<=totalcolumns;j++)
		  {
			  logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			
		  }
	  }
	  
	  System.out.println(logindata);
	  return  logindata ;
	 
  }
}
