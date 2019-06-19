package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public FileInputStream fis;
	private XSSFWorkbook wb;
	private XSSFSheet sheet;
	
	
	public ExcelReader(String FilePath) {
		
			try {
				fis = new FileInputStream(FilePath);
				wb = new XSSFWorkbook(fis);
				sheet = wb.getSheetAt(0);
				fis.close();
			} catch (Exception e) {
					e.printStackTrace();
			}
		
	}

	public int getRowCount(String sheetName) {
		
		sheet = wb.getSheet(sheetName);
		int rowSize = sheet.getLastRowNum()+1;
		return rowSize;
		}
	
	public int getColumnCount(String sheetName) {
		
		sheet = wb.getSheet(sheetName);
		int columnSize = sheet.getRow(0).getLastCellNum();
		return columnSize;
		}
	
	public String getData(String sheetName, int RowNum, int ColNum)
	{
		
		sheet = wb.getSheet(sheetName);
		String data = sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
		return data;
		
	}

}
