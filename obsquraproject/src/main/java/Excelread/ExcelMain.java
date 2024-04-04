package Excelread;

import java.io.IOException;



/*dependencies required for excel operations
 * 1.poi
 * 2.poi-ooxml
 * */
public class ExcelMain {
	public static void main(String[] args) throws IOException {

		String name = Excel.readStringData(3, 0);

		System.out.println("Name :" + "\t" + name);

		String id = Excel.readIntegerData(3, 1);

		System.out.println("id :" + "\t" + id);

	}

}