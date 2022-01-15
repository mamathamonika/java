package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {


		FileInputStream fis = new FileInputStream("./src/test/resources/data.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("sheet1");
		Row row = sheet.getRow(3);
		
		Cell createcell = row.createCell(0);
		createcell.setCellValue("test 3");
		row.createCell(1).setCellValue("TC-3");
		row.createCell(2).setCellValue("TY3");
		
		//open same workbook in write mode and save file
		
		FileOutputStream fos= new FileOutputStream("./src/test/resources/data.xlsx");
		workbook.write(fos);
		
		workbook.close();
		

	}

}
