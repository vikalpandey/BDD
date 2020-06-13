
// Commented Full page by using ctrol +shift+/

/*like this line */

/*

package p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Excel {
	public static FileInputStream openFile(String filename) throws Exception {
		File fileobj = null;
		FileInputStream fis = null;
		fileobj = new File(filename);
		fis = new FileInputStream(fileobj.getAbsolutePath());
		return fis;
	}

	public static HSSFWorkbook getWorkBook(FileInputStream fis) throws Exception {
		HSSFWorkbook wbobj = null;
		wbobj = new HSSFWorkbook(fis);
		return wbobj;
	}

	public static Sheet getSheet(Workbook wbobj, String sheetName) throws Exception {
		Sheet sheetobj = null;
		sheetobj = wbobj.getSheet(sheetName);
		return sheetobj;
	}

	public static Sheet getSheet(HSSFWorkbook wbobj, Integer sheetNum) throws Exception {
		Sheet sheetobj = null;
		sheetobj = wbobj.getSheetAt(sheetNum);
		return sheetobj;
	}

	public static Row getRow(Sheet sheetobj, int rownum) {
		Row rowobj = null;
		rowobj = sheetobj.getRow(rownum);
		return rowobj;
	}

	public static Cell getcell(Row rowobj, int cellpos) {
		Cell cellobj = null;
		cellobj = rowobj.getCell(cellpos, Row.CREATE_NULL_AS_BLANK);
		return cellobj;
	}

	public static String getCellVal(Cell cellobj) {
		cellobj.setCellType(Cell.CELL_TYPE_STRING);
		String cellval = cellobj.getStringCellValue();
		return cellval;
	}

	public static void closeFile(FileInputStream fis) throws Exception {
		fis.close();
	}

	public static File createExcelFile(String filePath) throws Exception {
		File file = new File(filePath);
		FileOutputStream fout = new FileOutputStream(file);
		fout.close();
		return file;
	}

	public static HSSFWorkbook createWorkBook(File file) throws Exception {
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		return wb;
	}

	public static HSSFSheet createWorkSheet(HSSFWorkbook wb, String sheetName) {
		HSSFSheet sheet = wb.createSheet(sheetName);
		return sheet;
	}

	public static HSSFRow createRow(HSSFSheet sheet, int rowNum) {
		HSSFRow row = sheet.createRow(rowNum);
		return row;
	}

	public static HSSFCell createCell(HSSFRow row, int cellNum) {
		HSSFCell cell = row.createCell(cellNum);
		return cell;
	}

	public static String generateGridPortNumbers() throws Exception {
		String fileName = "c:\\automation_data\\port.xls";
		File fileDir = new File("c:\\automation_data");

		if (fileDir.exists()) {
			// do nothing
		} else {
			fileDir.mkdir();
		}

		File file = new File(fileName);
		if (file.exists()) {
			// do nothing
		} else {
			// file.createNewFile();
			FileOutputStream fileOut = new FileOutputStream(file);
			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet worksheet = workbook.createSheet("ports");

			HSSFRow row;
			HSSFCell cell;
			row = worksheet.createRow(0);
			cell = row.createCell(0);
			cell.setCellValue("port");
			cell = row.createCell(1);
			cell.setCellValue("flag");

			for (int x = 1; x <= 50; x++) {
				row = worksheet.createRow(x);
				cell = row.createCell(0);
				cell.setCellValue(1000 + x);
				cell = row.createCell(1);
				cell.setCellValue("unused");
			}
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			workbook.close();
		}
		return fileName;
	}

	public static String bookUnusedPortNumber() throws Exception {

		String availablePortNumber = "0000";
		String fileName = Excel.generateGridPortNumbers();
		File file = new File(fileName);
		if (file.exists()) {
			// do nothing
			System.out.println("File exist");
		} else {
			System.out.println("File does not exist");
		}

		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);

		HSSFSheet sheet = workbook.getSheet("ports");
		Row row = null;
		Cell cell = null;
		Cell cell2 = null;
		List<String> availablePort = new ArrayList<String>();
		for (int x = 1; x <= 50; x++) {
			row = sheet.getRow(x);
			cell = row.getCell(0);
			cell2 = row.getCell(1);
			if (cell2.getStringCellValue().equalsIgnoreCase("unused")) {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				availablePort.add(cell.getStringCellValue());
			}
		}
		if (availablePort.size() > 0) {
			Random r = new Random();
			availablePortNumber = availablePort.get(r.nextInt(availablePort.size()));
			System.out.println(availablePortNumber);
			for (int x = 1; x <= 50; x++) {
				row = sheet.getRow(x);
				cell = row.getCell(0);
				cell2 = row.getCell(1);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				if (cell.getStringCellValue().equalsIgnoreCase(availablePortNumber)) {
					System.out.println("Booked" + availablePortNumber + "   : " + x);
					cell2.setCellValue("used");
				}
			}
			fis.close();
			FileOutputStream fout = new FileOutputStream(file);
			workbook.write(fout);
			fout.flush();
			fout.close();
			workbook.close();
		} else {
			availablePortNumber = "0000";
		}
		return availablePortNumber;
	}

	public static void flushUsedPortNumber(String usedPortNumber) throws Exception {
		String fileName = Excel.generateGridPortNumbers();
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(fileName);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);

		HSSFSheet sheet = workbook.getSheet("ports");
		Row row = null;
		Cell cell = null;
		Cell cell2 = null;

		for (int x = 1; x <= 50; x++) {
			row = sheet.getRow(x);
			cell = row.getCell(0);
			cell2 = row.getCell(1);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			if (cell.getStringCellValue().equalsIgnoreCase(usedPortNumber)) {
				System.out.println("Freed" + usedPortNumber + "   : " + x);
				cell2.setCellValue("unused");
			}
		}
		fis.close();
		FileOutputStream fout = new FileOutputStream(file);
		workbook.write(fout);
		fout.flush();
		fout.close();
		workbook.close();
	}
}



*/