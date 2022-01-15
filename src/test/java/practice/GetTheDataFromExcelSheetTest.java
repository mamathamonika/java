package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetTheDataFromExcelSheetTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		// java object repersentation of physical excel file
		
		FileInputStream fis=new FileInputStream("./src/test/resources/data.xlsx");
		
		//workbook creation for physical file object respresentation
		
		Workbook workbook = WorkbookFactory.create(fis);
		
		//get control of sheet
		
		Sheet sheet = workbook.getSheet("sheet1");
		
		//get control of row
		Row row = sheet.getRow(1);
		
		//get control of cell
		Cell cell = row.getCell(2);
		
		//fetch value from cell
		String orgname = cell.getStringCellValue();
		
		System.out.println(orgname);
		
		//close workbook
		
		workbook.close();
		


	}

}
