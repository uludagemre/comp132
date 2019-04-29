package file;


public class DataFile extends BinaryFile implements Openable {

	private String compressionFormat;
	private ExecutableFile opensWith;

	public DataFile(String fName, long fSize, boolean canCopy, String format, ExecutableFile exeFile) {
		super(fName, fSize, canCopy);
		this.compressionFormat = format;
		this.opensWith = exeFile; 
	}
	
	@Override
	public void onClick() {
		System.out.println("On click: " + this.opensWith() + " " + this.getName());
	}
	
	@Override
	public BinaryFile getCopy() throws IllegalArgumentException {
		DataFile newInstance = null;
		
		if(this.getCanCopy()) {
			String newName=this.getName();
			if(newName.contains(".")) {
				int extensionIndex = newName.indexOf(".");
				newName = newName.substring(0, extensionIndex).concat("(copy)").concat(newName.substring(extensionIndex));
			} else
				newName += "(copy)";
			
			//While getting copy of a data file, its exe file is not get copied.
			newInstance = new DataFile(newName, this.getSize(), this.getCanCopy(), new String(this.compressionFormat), this.opensWith);

		
		} else
			throw new IllegalArgumentException("You cannot make a copy of this file due to the copyright law!");
		
		return newInstance;
	}
	
	@Override
	public String opensWith() {
		return this.opensWith.getName();
	}
	
	public String toString() {
	    String res = "Type: Data File \n" + super.toString();
	    res += "Compression format: " + this.compressionFormat + "\n";
	    res += "Opens with: " + this.opensWith() + "\n";
	        
	    return res;
	}
}
