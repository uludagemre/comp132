package test;

import java.util.*;

import file.*;

public class Test {

	public static void main(String[] args) {
		
		ExecutableFile browser = new ExecutableFile("chrome.exe", 824000, true, "Mac on Intel");
		
		HTMLFile page1 = new HTMLFile("aboutme.html", 5000, "Unicode", 5, browser, null);
		HTMLFile page2 = new HTMLFile("publications.html", 5000, "Unicode", 5, browser, null);
		
		ArrayList<HTMLFile> myPageLinks = new ArrayList<HTMLFile>();
		myPageLinks.add(page1);
		myPageLinks.add(page2);
		
		File myWebpage = new HTMLFile("mywebpage.html", 5000, "Unicode", 5, browser, myPageLinks);
		
		File todos = new PlainTextFile("my todos", 3000, "ASCII", new String[]{"Do homework1", "Read the new paper", "Do homework2", "Go to gym"});
		
		ExecutableFile player = new ExecutableFile("vmplayer.exe", 160000, false, "Windows on Intel");
		
		File music = new DataFile("Walking On Air.mp3", 350000, true, "mp3", player);
		File movie = new DataFile("Up.mkv", 150000, false, "mkv", player);
		
		File[] files = new File[] {browser, myWebpage, todos, player, music, movie};

		System.out.println("Calling toString methods:");
		for(File f: files) {
            System.out.println(f.toString());
        }
        
        System.out.println("Calling polymorphic methods:");
		File.callPolymorphicMethods(files);
	}

}
