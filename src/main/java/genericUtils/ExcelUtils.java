package genericUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	public static Object[][] readMultipleDataFromExcel(String excelFile, String sheetName)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(excelFile);
		Workbook wk = WorkbookFactory.create(fis);
		Sheet sheet = wk.getSheet(sheetName);
		int row = sheet.getPhysicalNumberOfRows();
		Object[][] obj = new Object[row][];
		for (int i = 0; i < row; i++) {
			int column = sheet.getRow(i).getPhysicalNumberOfCells();
			obj[i] = new Object[column];
			for (int j = 0; j < column; j++) {
				obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
	public String readSingleDataFromExcel(String excelfilePath,String SheetName,int row,int column) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IPathConstants.Excelpath);
		Workbook wk = WorkbookFactory.create(fis);
		Sheet sheet = wk.getSheet(SheetName);
		return sheet.getRow(row).getCell(column).getStringCellValue();
		
		
		
		
	}
}
