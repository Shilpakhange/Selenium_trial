package excelExportandFileIO;



	import org.apache.poi.hssf.util.HSSFColor;
	import org.apache.poi.ss.usermodel.FillPatternType;
	import org.apache.poi.xssf.usermodel.*;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	 
	public class WriteExcel
	{
	    public static void main(String args[]) throws Exception
	    {
	        FileInputStream fis = new FileInputStream("C:\\Users\\Shilpa Khandge\\eclipse-workspace\\selenium_trial\\testData\\testwritedata.xlsx");
	        FileOutputStream fos = null;
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet sheet = workbook.getSheet("Credentials");
	        XSSFRow row = null;
	        XSSFCell cell = null;
	        XSSFFont font = workbook.createFont();
	        XSSFCellStyle style = workbook.createCellStyle();
	 
	        int col_Num = -1;
	        row = sheet.getRow(0);
	       // System.out.println(row);
	       // System.out.println(row.getLastCellNum());
	        for(int i = 0; i < row.getLastCellNum(); i++)
	        {
	            if(row.getCell(i).getStringCellValue().trim().equals("Result"))
	            {
	                col_Num = i;
	            }
	        }
	 
	        row = sheet.getRow(1);
	        if(row == null)
	            row = sheet.createRow(1);
	 
	        cell = row.getCell(col_Num);
	        if(cell == null)
	            cell = row.createCell(col_Num);
	 
	        font.setFontName("Comic Sans MS");
	        font.setFontHeight(14.0);
	        font.setBold(true);
	        font.setColor(HSSFColor.WHITE.index);
	 
	        style.setFont(font);
	        style.setFillForegroundColor(HSSFColor.GREEN.index);
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	 
	        cell.setCellStyle(style);
	        cell.setCellValue("PASS");
	 
	        fos = new FileOutputStream("C:\\Users\\Shilpa Khandge\\eclipse-workspace\\selenium_trial\\testData\\testwritedata.xlsx");
	        workbook.write(fos);
	        fos.close();
	    }
	}
	

