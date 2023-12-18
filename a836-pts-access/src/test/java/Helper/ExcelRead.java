package Helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelRead {
	
	
	//private WebDriver driver;



	//public ExcelRead(WebDriver driver) {
		
	//	this.driver=driver;
		// TODO Auto-generated constructor stub
	//}



	public ExcelRead(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}



	/* public List<Map<String,String>> getData(String excelFilePath, String sheetName)throws DataFormatException,IOException
	{
		Sheet sheet=getSheetByName(excelFilePath,sheetName);
		return readSheet(sheet);
		
	}



	public List<Map<String,String>> getData(String excelFilePath, int sheetNumber)throws DataFormatException,IOException
	{
		Sheet sheet=getSheetByIndex(excelFilePath,sheetNumber);
		return readSheet(sheet);
		
	} */

	public Cell[][] getExcelData(String excelFilePath, int sheetNumber)throws DataFormatException,IOException
	{
		Sheet sheet=getSheetByIndex(excelFilePath,sheetNumber);
		return getRows(sheet);
		
	}


	/* private List<Map<String, String>> readSheet(Sheet sheet) {
		Row row;
		int totalRow= sheet.getPhysicalNumberOfRows();
		List<Map<String,String>> excelRows=new ArrayList<Map<String,String>>();
		int headerRowNumber=getHeaderRowNumber(sheet);
		if(headerRowNumber !=-1) {
			Row headerRow = sheet.getRow(headerRowNumber);
			int totalColumn=headerRow.getLastCellNum();
			int setCurrentRow=1;
			for(int CurrentRow=setCurrentRow; CurrentRow <= totalRow-1; CurrentRow++)
			{
				row = sheet.getRow(sheet.getFirstRowNum()+ CurrentRow);
				System.out.println("row: " + row);
				//LinkedHashMap<String,String> ColunMapdata=new LinkedHashMap<String,String>();
				
				Map<String, String> cellValueMap = getCellValue(headerRow, row, CurrentRow, totalColumn);
				System.out.println("cellValueMap: " + cellValueMap);
				excelRows.add(cellValueMap);
			
			}	
		}
		return excelRows;
	} */


	private Cell[][] getRows(Sheet sheet) {
		Row row;
		int totalRow= sheet.getPhysicalNumberOfRows();
		int headerRowNumber=getHeaderRowNumber(sheet);
		Cell[][] rowArray = new Cell[totalRow][];
		if(headerRowNumber !=-1) {
			Row headerRow = sheet.getRow(headerRowNumber);
			int totalColumn=headerRow.getLastCellNum();
			int setCurrentRow=1;
			for(int CurrentRow=setCurrentRow; CurrentRow <= totalRow-1; CurrentRow++)
			{
				row = sheet.getRow(sheet.getFirstRowNum()+ CurrentRow);
				//System.out.println("row: " + row);
				//LinkedHashMap<String,String> ColunMapdata=new LinkedHashMap<String,String>();
				
				Cell[] cellArray = getCells(row, totalColumn);
				rowArray[CurrentRow-1] = cellArray;
			
			}	
		}
		return rowArray;
	}


	/* private Row getRow(Sheet sheet, int i) {
		// TODO Auto-generated method stub
		return null;
	}



	private Map<String, String> getCellValue(Row headerRow, Row row, int currentColumn, int totalColumn) {
		// TODO Auto-generated method stub
		Map<String, String> cellValueMap = new HashMap<String, String>();
		for(int CurrentColumn=0;CurrentColumn<totalColumn; CurrentColumn++ ) {
			String cellValue = row.getCell(CurrentColumn).getStringCellValue();
			String headerName = headerRow.getCell(CurrentColumn).getStringCellValue();
			System.out.println("headerName: " + headerName + "cellValue: " + cellValue);
			cellValueMap.put(headerName, cellValue);
		}
		return cellValueMap;
	} */

	private Cell[] getCells(Row row, int totalColumn) {
		// TODO Auto-generated method stub
		Cell[] cellArray = new Cell[totalColumn];
		for(int CurrentColumn=0;CurrentColumn<totalColumn; CurrentColumn++ ) {
			Cell cell = row.getCell(CurrentColumn);
			cellArray[CurrentColumn] = cell;
		}
		return cellArray;
	}



	private int getHeaderRowNumber(Sheet sheet) {
		// TODO Auto-generated method stub
		return 0;
	}



	private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		Sheet sheet=((Workbook) getWorkBook(excelFilePath)).getSheetAt(sheetNumber);
		return sheet;
	}



	private Object getWorkBook(String excelFilePath) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		return WorkbookFactory.create(new File(excelFilePath));
	}



	/* private Sheet getSheetByName(String excelFilePath, String sheetName) throws DataFormatException,IOException
	{
	Sheet sheet=((Workbook) getWorkBook(excelFilePath)).getSheet(sheetName);
	return sheet;
	} */
	
	}
