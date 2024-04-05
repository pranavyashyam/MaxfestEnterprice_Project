package Excelread;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		String usernme = Excel.readStringData(1, 0);
		String pswd = Excel.readIntegerData(1, 1);
		System.out.println( usernme);
		System.out.println( pswd);	// TODO Auto-generated method stub

	}

}
