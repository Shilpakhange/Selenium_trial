package com.Datadriventest;

import java.util.Scanner;

import com.excel.utility.Xls_Reader;

public class Exceloperations {

	public static void main(String[] args) {

		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\Shilpa Khandge\\eclipse-workspace\\selenium_trial\\testData\\ebaytest.xlsx");

		Scanner sheetname = new Scanner(System.in);
		String str;
		do {
			System.out.println("Enter the sheetname:");
			String sname = sheetname.next();
			boolean b = reader.addSheet(sname);
			if (b == true) {
				System.out.println("Sheet already exist");
			} else {
				System.out.println("New sheet created");
				break;
			}
			System.out.println("Do you want to enter the new sheetname:");
					
			 str = sheetname.next();

		} while (str != null);

		
	}

}
