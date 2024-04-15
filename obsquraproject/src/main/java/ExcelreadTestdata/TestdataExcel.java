package ExcelreadTestdata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*dependencies required for excel operations

 * 1.poi

 * 2.poi-ooxml

 * */
public class TestdataExcel {
	
	static String configpath="\\src\\main\\resources\\TestdataExcelpackage\\Testdata.xlsx";
	public static XSSFWorkbook w;// used to save excel workbook object

	public static XSSFSheet s;// used to hold excel sheet object

	public static FileInputStream f;

	public static String readStringData(int i, int j) throws IOException {
		String projectpath=System.getProperty("user.dir");

		f = new FileInputStream(projectpath+configpath);

		w = new XSSFWorkbook(f);// location will assign to w

		s = w.getSheet("Sheet1");// get the sheet1 and assign to s

		Row r = s.getRow(i);// ith row passes to r

		Cell c = r.getCell(j);// jth cell passes to c

		return c.getStringCellValue(); // gets the value

	}

	public static String readIntegerData(int i, int j) throws IOException {
		String projectpath=System.getProperty("user.dir");

		f = new FileInputStream(projectpath+configpath);
		w = new XSSFWorkbook(f);

		s = w.getSheet("Sheet1");

		Row r = s.getRow(i);

		Cell c = r.getCell(j);

		int value = (int) c.getNumericCellValue(); // typecasted to integer

		return String.valueOf(value);

	}
	public static void main(String[] args) throws IOException {

		String name = TestdataExcel.readStringData(3, 0);

		System.out.println("Name :" + "\t" + name);

		String id = TestdataExcel.readIntegerData(3, 1);

		System.out.println("id :" + "\t" + id);

	}

}
