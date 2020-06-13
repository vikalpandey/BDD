package files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Writefile {

	public static void main(String[] args) throws IOException {
		//Stream connectivity
		//1- file class have constructor which accept path of file
		File f=new File("E:/2 Selenium/Z Eclipse new Java/JAVA OOPS Concept/File/VPtest3.html");
		//or
//		File f=new File("E:\\2 Selenium\\Z Eclipse new Java\\JAVA OOPS Concept\\File\\VPtest2.html");
//		String Filepath="E:/2 Selenium/Z Eclipse new Java/JAVA OOPS Concept/File";
//		File f=new File (Filepath +"/"+ "Vptest4.html");
		// you just change the name and extension then new file will be created like txt, csv, html, (docx, xlsx- file not opened) etc. 
		//FileWriter fw=new FileWriter(f);
		FileWriter fw1=new FileWriter(f, false); // for append it is true
		BufferedWriter writer=new BufferedWriter(fw1);
		
		// writing inside file 
/*		writer.write("this is first line");
		writer.newLine();
		writer.write("2nd line");
		writer.newLine();
		writer.write("3rd line ");*/
		
		writer.write("<html>   <head> <title>Avitus Net Report</title> <h1> h1 tag </h1>     <body> "
				+ "<header> this is header </header>"
				+ "<div>  thsi is div  </div>"
				+ " <body>  </head> </html> ");
		
/*		for(int i=0;i<5;i++)
		{
			for(int j=0;j<4;j++)
			{
				//writer.newLine();
				//System.out.println(i+","+j);
				//writer.write(j+"\t");
				int num=(int)(Math.random()*100);
				writer.write(num+",");
				
				//writer.newLine();
			}
			writer.newLine();
		}*/
		
		// closing the streams
		writer.close();
		System.out.println("file closed");
		
	}

}
