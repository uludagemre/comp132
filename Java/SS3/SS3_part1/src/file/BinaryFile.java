package file;


public abstract class BinaryFile extends File {
	
	//Digital rights management.
	private boolean canCopy; 
	
	public BinaryFile(String fName, long fSize, boolean canCopy) {
	    super(fName, fSize);
	    this.canCopy = canCopy;
	}

	@Override
	public String toString() {
		return super.toString() + "Can copy = " + (canCopy? "It can copy ": "It can't copy") + "\n";
	}

	protected boolean getCanCopy() {
		return this.canCopy;
	}

	//Returns an independent copy of the file if canCopy is true. 
	// Throws the CopyingNotAllowedException otherwise.
	public abstract BinaryFile getCopy() throws IllegalArgumentException;
	
}
