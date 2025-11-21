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

	// private static XSSFCell cell;

	public static List<Map<String, String>> getData(String filePath, String sheetName) {
		List<Map<String, String>> LoginData = new ArrayList<>();

		try {
			FileInputStream xlFile = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(xlFile);
			sheet = workbook.getSheet(sheetName);

			headerRow = sheet.getRow(0);

			int rowCnt = sheet.getLastRowNum();
			int colCnt = headerRow.getLastCellNum();

			for (int i = 1; i <= rowCnt; i++) {
				dataRow = sheet.getRow(i);

				Map<String, String> Logindata = new HashMap<>();

				for (int j = 0; j < colCnt; j++) {
					String key = headerRow.getCell(j).getStringCellValue();
					cell = dataRow.getCell(j, XSSFRow.MissingCellPolicy.RETURN_BLANK_AS_NULL);
					String value = (cell == null) ? "" : cell.toString().trim();
					Logindata.put(key, value);
				}
				LoginData.add(Logindata);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return LoginData;

	}

}
