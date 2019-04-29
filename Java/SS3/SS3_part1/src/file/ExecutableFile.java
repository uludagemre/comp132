package file;

import java.util.Arrays;


public class ExecutableFile extends BinaryFile {

	//contains the platform (Mac OS on Intel or Android on ARM) that the file can execute on.
	private String platform;
	
	//Constructor
	public ExecutableFile(String fName, long fSize, boolean canCopy, String platform) {
		super(fName, fSize, canCopy);
		this.platform = platform;
	}
	
	@Override
	public String toString() {
		return "Type: Executable File \n" + super.toString() + "Platform: " + platform + "\n"; 
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}


	@Override
	public void onClick() {
		System.out.println("On click: " + this.getName());
	}
	
	@Override
	public BinaryFile getCopy() throws IllegalArgumentException {
		ExecutableFile newInstance = null;
		
		if(this.getCanCopy()) {
			String newName=this.getName();
			if(newName.contains(".")) {
				int extensionIndex = newName.indexOf(".");
				newName = newName.substring(0, extensionIndex).concat("(copy)").concat(newName.substring(extensionIndex));
			} else
				newName += "(copy)";
			
			newInstance = new ExecutableFile(newName, this.getSize(), this.getCanCopy(), new String(this.platform));

		} else
			throw new IllegalArgumentException("You cannot make a copy of this file due to the copyright law!");
		
		return newInstance;
	}
	

}
