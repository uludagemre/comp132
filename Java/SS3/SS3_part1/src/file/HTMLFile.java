package file;

import java.util.*;

public class HTMLFile extends TextFile implements Openable {

	private ExecutableFile browserCompatibleWith;
	private ArrayList<HTMLFile> linksTo;
	private int htmlVersion;
	
	public HTMLFile(String fName, long fSize, String encoding, int htmlVersion, ExecutableFile compatibleBrowser, ArrayList<HTMLFile> links) {
		//Default numChars for HTML files: 10000
		super(fName, fSize, encoding, 10000);
		this.htmlVersion = htmlVersion;
		this.browserCompatibleWith = compatibleBrowser;
		this.linksTo = links;
	}
	
	public int getHTMLVersion() {
		return this.htmlVersion;
	}
	
	public ExecutableFile getCompatibleBrowser() {
		return this.browserCompatibleWith;
	}
	
	public ArrayList<HTMLFile> getLinks() {
		return this.linksTo;
	}

	//Opens this file with its compatible browser
	@Override
	public void onClick() {
		System.out.println("On click: " + this.opensWith() + " " + this.getName());
	}
	
	//Clears the "linksTo" list and sets "browserCompatibleWith" to "iexplore.exe"
	@Override
	public void clear() {
		try{
		    this.linksTo.clear();
		}catch(UnsupportedOperationException e) {
			throw new UnsupportedOperationException(e.getMessage());
		}
		this.browserCompatibleWith = new ExecutableFile("iexplore.exe", 200000, true, "Windows on Intel");
	}
	
	//Implements the Interface method
	@Override
	public String opensWith() {
		return this.browserCompatibleWith.getName();
	}
	
	public String toString() {
	    String res = "Type: HTML File \n" + super.toString();
	    
	    res += "Compatible with: " + this.browserCompatibleWith.getName() + "\n";
	    res += "HTML version: " + this.htmlVersion + "\n";
	   
	    if(linksTo != null) {
	        res += "Links to: ";
    	    for(File f: linksTo) {
    	        res += f.getName() + " ";
    	    }
	    }
	        
	    return res + "\n";
	}
	
}
