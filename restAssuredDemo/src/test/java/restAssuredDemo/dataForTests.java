package restAssuredDemo;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class dataForTests {
	
	
	@DataProvider(name="postRequest")
	public Object[][] fetchDataForPost()
	{
		
	  /*  Object[][] data =new Object[3][4];
		data[0][0]="Tan";
		data[0][1]="bin";
		data[0][2]="t1.b@gmail.com";
		data[0][3]=1;
		
		data[1][0]="Sun";
		data[1][1]="due";
		data[1][2]="s1.d@gmail.com";
		data[1][3]=2;
		
		data[2][0]="Joy";
		data[2][1]="blue";
		data[2][2]="j11.b@gmail.com";
		data[2][3]=2;
		return data;
		*/
		return new Object[][] {
			{"Graham","Bell","g.h@gmai.com",1},
			{"Dye","Rose","d11.rose@gmai.com",2}
		};
	}
	@DataProvider(name="deletetRequest")
	public Object[] fetchDataForDelete()
	{
		return new Object[] {
			4,5,6,7,8
		};
	}
	
	@DataProvider(name="dataFromExcel")
	public static String[][] getCellData() {
		XSSFWorkbook book = null;
		XSSFSheet sheet = null;
		String[][] data =null;
		try {
			 book = new XSSFWorkbook("./data/testData.xlsx");
			 sheet = book.getSheet("Sheet1");
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Number of rows " + rowCount);
		 sheet = book.getSheet("Sheet1");
		DataFormatter formater = new DataFormatter();
	//	Object value = formater.formatCellValue(sheet.getRow(rownum).getCell(colnum));
	//	System.out.println("value from excel is " + value);

		// Create a loop over all the rows of excel file to read it

		for (int i = 1; i < rowCount; i++) {

			Row row = sheet.getRow(i);

			// Create a loop to print cell values in a row

			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				 data =new String[rowCount][row.getPhysicalNumberOfCells()];
			//	data[i][j] = formater.formatCellValue(row.getCell(j));
				data[i][j] = row.getCell(j).toString();
				// Print Excel data in console
				//System.out.print(row.getCell(j).getStringCellValue() + "|| ");
				System.out.print(data+ " ");

			}

			System.out.println();
		}
		return  data;

	}
}
