package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writeexcel {
public static void main(String[] args) throws Exception {
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet0=workbook.createSheet("firstsheet");		
//	    Row row0=sheet0.createRow(0);
//	    Cell cellA=row0.createCell(0);
//	    Cell cellB=row0.createCell(1);
//	    cellA.setCellValue("first cell value ");
//	    cellB.setCellValue("second cell value");    
	    for(int rows = 0;rows<10;rows++)
	    {
	    	Row row=sheet0.createRow(rows);
	    	for(int cols=0;cols<10;cols++)
	    	{
	    		Cell cell=row.createCell(cols);
	    		cell.setCellValue((int)(Math.random()*100));
	    	}  	
	    }      
	    //connection stream
	    File f=new File("E:\\2 Selenium\\Z Eclipse new Java\\JAVA OOPS Concept\\File\\VPtest4.xlsx");
	    FileOutputStream fo=new FileOutputStream(f);
	    workbook.write(fo);
	    // closing the stream
	    fo.close();
	    System.out.println("file closed");
	    
	    
	    
		
		
	}
}
