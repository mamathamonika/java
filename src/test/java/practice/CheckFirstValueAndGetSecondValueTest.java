package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class CheckFirstValueAndGetSecondValueTest {

	public static void main(String[] args) throws Throwable, Throwable {


		FileInputStream fis= new FileInputStream("./src/test/resources/data.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("sheet1");
		
		int lastrow = sheet.getLastRowNum();
		
		String required="TC-2";
		
		for(int i=1;i<lastrow;i++)
		{
			Row row = sheet.getRow(i);
			String value = row.getCell(1).getStringCellValue();
			
			if (required.equals(value))
			{
				String secondcellvalue = row.getCell(2).getStringCellValue();
				System.out.println(secondcellvalue);
			}
		}
		
		workbook.close();

	}

}
