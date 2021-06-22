package files;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Find_total_no_files {
	
	public static void main(String[] args) {
		
		File file=new File("C:/Users/vikal.pandey/Desktop/VP10 aug");
		//int length=file.listFiles().length;
		int length=file.list().length;
		

		System.out.println("total no of files in given path ="+length);

		try (Stream<Path> files = Files.list(Paths.get("C:/Users/vikal.pandey/Desktop/VP10 aug"))) {
		    long count = files.count();
		    System.out.println("count = "+count);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
		
		
			     List<String> fileNames = new ArrayList<>();
			    try {
			      DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("C:/Users/vikal.pandey/Desktop/VP10 aug"));
			      for (Path path : directoryStream) {
			        fileNames.add(path.toString());
			      }
			    } catch (IOException ex) {
			    }
			    System.out.println("File Count--new ==:"+fileNames.size());
			  
		
		
		
		
		
	//	getFile("C:/Users/vikal.pandey/Desktop/VP10 aug"); 
		
		
		
	}
	
	 static int count = 0;
	

	private static void getFile(String dirPath) {
	    File f = new File(dirPath);
	    File[] files = f.listFiles();

	    if (files != null)
	    for (int i = 0; i < files.length; i++) {
	        count++;
	        File file = files[i];

	        if (file.isDirectory()) {   
	             getFile(file.getAbsolutePath()); 
	        }
	    }
	    System.out.println("count ===="+ count);
	}



	

}
