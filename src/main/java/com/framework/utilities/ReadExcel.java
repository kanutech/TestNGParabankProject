package com.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readData(String workbook, String sheet) {
		String[][] data = null;
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\" + workbook);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet(sheet);
			int totalRows = sh.getPhysicalNumberOfRows();
			int totalColums = sh.getRow(0).getPhysicalNumberOfCells();
			data = new String[totalRows - 1][totalColums];
			for (int row = 1; row < totalRows; row++) {
				for (int col = 0; col < totalColums; col++) {
					data[row-1][col] = sh.getRow(row).getCell(col).getStringCellValue();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

}
