package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
 public static void main(String[] args) throws Exception, IOException {
	
	 File f=new File("E:\\2 Selenium\\Z Eclipse new Java\\JAVA OOPS Concept\\File\\VPtestReadfile.xlsx");
	 FileInputStream fi=new FileInputStream(f);
	 Workbook workbook=WorkbookFactory.create(fi);
	 Sheet sheet0= workbook.getSheetAt(0);
//	 //get the first row
//	 Row row0=sheet0.getRow(0);
//	 //get the columns
//	 int physicalnoofcell=row0.getPhysicalNumberOfCells();
//	 System.out.println(physicalnoofcell);
//	 Cell cell0=row0.getCell(0);
//	 Cell cell1=row0.getCell(1);
//	 Cell cell2=row0.getCell(2);
//	 System.out.println("cell0 = "+cell0 +"cell1= "+ cell1+"cell2 = "+cell2 );
	 
	 for(Row row : sheet0)	 {
		 for(Cell cell : row)		 {
			 switch(cell.getCellType())
			 {
			case BLANK:
				System.out.print("blank cell"+"\t");
				break;
			case BOOLEAN:
				break;
			case ERROR:
				break;
			case FORMULA:
				break;
			case NUMERIC:
				System.out.print(cell.getNumericCellValue()+"\t");
				break;
			case STRING:
				System.out.print(cell.getStringCellValue()+"\t");
				break;
			case _NONE:
				break;
			default:
				break;
 
			 }
		 }
		 System.out.println();
	 }
		 
		 
	 
	
	fi.close();
	

	
}
	
	
	
	
}
