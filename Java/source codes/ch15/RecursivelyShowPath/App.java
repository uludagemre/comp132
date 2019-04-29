// In class exercise - list all files under a directory recursively
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App
{
   public static void main(String[] args) throws IOException
   {
      Scanner input = new Scanner(System.in);

      System.out.println("Enter file or directory name:");

      // create Path object based on user input
      Path path = Paths.get(input.nextLine());
      
      listAll(path,4);
   }
   
   
   
   private static void listAll(Path path, int depth) throws IOException {
	  
	   System.out.printf("%"+depth+"s%s%n","",path.getFileName());
	   
	   if (Files.isDirectory(path)) {
		   DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
		   for (Path p : directoryStream)
	           listAll(p,depth+5);
		   
	   }
   }
} // end class FileAndDirectoryInfo
