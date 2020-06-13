package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Readfile {

	public static void main(String[] args) throws IOException {
		
		File f=new File("E:\\2 Selenium\\Z Eclipse new Java\\JAVA OOPS Concept\\File\\VPtest_for_read_file.txt");
		FileReader fr=new FileReader(f);
		BufferedReader reader=new BufferedReader(fr);
// read line by line and print it 
//		System.out.println(reader.readLine());
//		System.out.println(reader.readLine());

		// read whole page till end then we need while loop
		String line=null; 
		while ((line = reader.readLine()) !=null) {
			System.out.println(line);
		}
		
		


		
		
		reader.close();
		

	}

}
