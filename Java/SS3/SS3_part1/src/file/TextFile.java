package file;

public abstract class TextFile extends File {
	
	//can be ASCII, Unicode, DOS, etc.
	private String encoding;
	private long numChars;
	
    public TextFile(String fName, long fSize, String encoding, long numChars) {
        super(fName, fSize);
        this.encoding = encoding;
        this.numChars = numChars;
    }
    
	public String getEncoding() {
		return this.encoding;
	}
	
	public long getNumChars() {
		return this.numChars;
	}
		
	//Every kind of TextFile implements differently
	public abstract void clear(); 
	
	public String toString() {
	    String res = super.toString();
	    res += "Encoding: " + this.encoding + "\n";
	    res +=  "Number of characters: " + numChars + "\n";
	    
	    return res;
	}
}
