package generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author MADHUSUDAN
 *it is used to read data from excel file
 */
public class ExcelUtilities 
{
	
	public String ReadExceldataValue(String sheetnum,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileinput=new FileInputStream("src/main/resources/organisation_ass.xlsx");
		Workbook book=WorkbookFactory.create(fileinput);
		Sheet sheet = book.getSheet(sheetnum);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
	
		DataFormatter data=new DataFormatter();
		String Data = data.formatCellValue(cell);
		return Data;
	} 
/**
 * 
 * It is used to write data into excel 
 */
public void writeExcelDataValue(String sheetnum,int rownum,int cellnum,String data) throws IOException
{
	FileInputStream fileinput=new FileInputStream("src/main/resources/organisation_ass.xlsx");
	Workbook book=WorkbookFactory.create(fileinput);
	Sheet sheet = book.getSheet(sheetnum);
	Row row = sheet.createRow(rownum);
	Cell cell = row.createCell(cellnum);
	cell.setCellValue(data);
	FileOutputStream fileoutput=new FileOutputStream("src/main/resources/organisation_ass.xlsx");
	book.write(fileoutput);
}
}


