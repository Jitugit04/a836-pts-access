package runners.testng;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.zip.DataFormatException;

import Helper.Base;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.Assert;
import org.testng.annotations.*;

import Helper.ExcelRead;
import PageObject.A836Page;

public class TestApp extends Base {

   String message = "Hello World";
   A836Page page;
   ExcelRead er = new ExcelRead(null);
   Workbook wb;
   String excelFilePath = "QA_Automation_Task_Data.xlsx";
    String outExcelFilePath = "QA_Automation_Task_Data_Results.xlsx";

   @BeforeMethod
   public void setup() throws MalformedURLException {
       super.setup();
       super.openUrl("https://a836-pts-access.nyc.gov/care/search/CommonSearch.aspx?mode=PERSPROP");
       this.page = new A836Page(driver);
   }

   @DataProvider (name = "BBL_Search_Data")
    public Object[][] dpMethod() throws DataFormatException, IOException {
        Cell[][] rowArray = er.getExcelData(this.excelFilePath, 0);
        this.wb = er.wb;
        return rowArray;
    }


   @Test (dataProvider = "BBL_Search_Data")
   public void testBBLSearch(Cell bbl, Cell borough, Cell block, Cell lot, Cell status) throws InterruptedException {
        String bbl_value = bbl.getStringCellValue();
       int borough_value = (int) borough.getNumericCellValue();
       int block_value = (int) block.getNumericCellValue();
       int lot_value = (int) lot.getNumericCellValue();
       String status_value = status.getStringCellValue();

       System.out.println("########## ROW Processing: " + bbl_value + "," + borough_value + "," + block_value + "," + lot_value + "," + status_value + " #############");

       page.clickAgree();
       page.selectBorough(borough_value);
       page.setBlock(block_value);
       page.setLot(lot_value);
       page.clickSearch();
       boolean isResultFound = page.checkIfResultFound();

       if (isResultFound) {
           status.setCellValue("Success");
       } else {
           status.setCellValue("Failure");
       }

       Assert.assertTrue(isResultFound);

   }

   @AfterMethod
    public void close() throws IOException {
       driver.close();
   }

   @AfterTest
    public void writeXls() throws IOException {
       this.er.file.close();

       FileOutputStream outFile =new FileOutputStream(new File(this.outExcelFilePath));
       this.wb.write(outFile);
       outFile.close();
   }
}