package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class GetFirstAndSecondColumnDataTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis= new FileInputStream("./src/test/resources/data.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("sheet1");
		int lastrow = sheet.getLastRowNum();
		System.out.println(lastrow);
		
		for(int i=1;i<lastrow;i++)
		{
			Row row = sheet.getRow(i);
			String firstvalue =  row.getCell(0).getStringCellValue();
			String secondvalue = row.getCell(1).getStringCellValue();
			
			System.out.println(firstvalue+"\t"+secondvalue);
		}
                 
		workbook.close();
	}

}
