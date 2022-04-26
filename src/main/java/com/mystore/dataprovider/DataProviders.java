package com.mystore.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.mystore.utility.XLUtils;

/**
 * @author swayam
 *
 */
public class DataProviders {
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
	
		String path=System.getProperty("user.dir")+"/src/test/resources/TestData/loginCredentiaks.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
		}
		
		return logindata;
	}
	

}
