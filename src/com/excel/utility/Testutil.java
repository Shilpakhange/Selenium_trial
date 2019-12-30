package com.excel.utility;

import java.util.ArrayList;

public class Testutil {

	public static ArrayList<Object[]> getDatafromExcel() {
		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\Shilpa Khandge\\eclipse-workspace\\selenium_trial\\testData\\ebaytest.xlsx");

		int rowcnt = reader.getRowCount("RegTestData");
		ArrayList<Object[]> obj = new ArrayList<Object[]>();

		for (int i = 2; i <= rowcnt; i++) {
			String fname = reader.getCellData("RegTestData", "businessname", i);

			String email = reader.getCellData("RegTestData", "email", i);

			String password = reader.getCellData("RegTestData", "password", i);

			Object ob[] = { fname, email, password };
			obj.add(ob);
		}
		return obj;
	}

}
