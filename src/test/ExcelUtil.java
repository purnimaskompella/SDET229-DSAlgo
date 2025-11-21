package Utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow headerRow, dataRow;
	private static XSSFCell cell;
	private static String filepath = "src/test/resources/TestData/DS-Algotestdata.xlsx ";

	// private static XSSFCell cell;

	public static List<Map<String, String>> getModuleData(String sheetName) {
		List<Map<String, String>> LoginData = new ArrayList<>();

		try {
			FileInputStream xlFile = new FileInputStream(filepath);
			workbook = new XSSFWorkbook(xlFile);
			sheet = workbook.getSheet(sheetName);

			headerRow = sheet.getRow(0);

			int rowCnt = sheet.getLastRowNum();
			int colCnt = headerRow.getLastCellNum();

			System.out.println("Rowcount is :" + rowCnt);
			System.out.println("Colcount is :" + colCnt);

			for (int i = 1; i <= rowCnt; i++) {
				dataRow = sheet.getRow(i);
				System.out.println("datarow is " + dataRow);

				Map<String, String> Logindata = new HashMap<>();

				for (int j = 0; j < colCnt; j++) {

					// String key = getCellValue(headerRow.getCell(j));
					// String value = getCellValue(datarow.getCell(j));
					// row.getCell(columnIndex, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
					String key = headerRow.getCell(j).getStringCellValue();
					System.out.println("key value key is " + key);
					cell = dataRow.getCell(j, XSSFRow.MissingCellPolicy.RETURN_BLANK_AS_NULL);
					String value = (cell == null) ? "" : cell.toString().trim();
					Logindata.put(key, value);

					Logindata.put(key, value);

				}
				System.out.println(Logindata);
				LoginData.add(Logindata);
				System.out.println(LoginData);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception is :" + e);

		}
		return LoginData;
	}

	public static List<Map<String, String>> getListMapData(String filePath, String sheetName) {
		List<Map<String, String>> LoginData = new ArrayList<>();

		try {
			FileInputStream xlFile = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(xlFile);
			sheet = workbook.getSheet(sheetName);

			headerRow = sheet.getRow(0);

			int rowCount = sheet.getLastRowNum();
			int colCount = headerRow.getLastCellNum();

			System.out.println("Rowcount is :" + rowCount);
			System.out.println("Colcount is :" + colCount);

			for (int i = 1; i <= rowCount; i++) {
				dataRow = sheet.getRow(i);
				System.out.println("datarow is " + dataRow);

				Map<String, String> Logindata = new HashMap<>();

				for (int j = 0; j < colCount; j++) {

					// String key = getCellValue(headerRow.getCell(j));
					// String value = getCellValue(datarow.getCell(j));
					// row.getCell(columnIndex, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
					String key = headerRow.getCell(j).getStringCellValue();
					System.out.println("key value key is " + key);
					String value = dataRow.getCell(j, XSSFRow.MissingCellPolicy.RETURN_BLANK_AS_NULL)
							.getStringCellValue();
//					if (value == null) {
//						System.out.println("Key valu is " + value);
//						Logindata.put(key, "-");
//					} else {
					Logindata.put(key, value);
//					}

				}
				System.out.println(Logindata);
				LoginData.add(Logindata);
				System.out.println(LoginData);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception is :" + e);

		}
		return LoginData;

	}

	public static List<String> getListData(String filePath, String sheetName) {
		List<String> linkData = new ArrayList<>();

		try {
			FileInputStream xlFile = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(xlFile);
			sheet = workbook.getSheet(sheetName);

			// headerRow = sheet.getRow(0);

			int rowCount = sheet.getLastRowNum();
			for (int i = 1; i <= rowCount; i++) {
				dataRow = sheet.getRow(i);
				int colCount = headerRow.getLastCellNum();

				for (int j = 0; j < colCount; j++) {
					// String key = headerRow.getCell(j).getStringCellValue();
					String value = dataRow.getCell(j).getStringCellValue();
					// Logindata.put(key, value);
					linkData.add(value);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return linkData;

	}

}
