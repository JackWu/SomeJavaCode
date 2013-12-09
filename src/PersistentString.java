import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class PersistentString {
	
	private StringBuffer bigString = null;
	
	private String loadPath, writePath;

	public PersistentString(String loadPath, String writePath){
		bigString = new StringBuffer();
		this.loadPath = loadPath;
		this.writePath = writePath;
		load();
		
	}
	
	
	public boolean isPalindrome(String s){
	    if (s==null || s.length()==0)
	        return true;

	    int i=0, j=s.length()-1;        
	    while(i<j){
	        char a = s.charAt(i);
	        char b = s.charAt(j);

	        if(!Character.isLetterOrDigit(a)){
	            i++;
	            continue;
	        }

	        if(!Character.isLetterOrDigit(b)){
	            j--;
	            continue;
	        }

	        if(Character.toLowerCase(a)!=Character.toLowerCase(b))
	            return false;
	        i++;j--;
	    }
	    return true;
	        
	}
	
	public String getString(){
		
		if(bigString == null)
			return "";
		return bigString.toString();
		
	}
	
	public int getLength(){
		if(bigString == null)
			return 0;
		return bigString.length();
	}
	
	public void addText(StringBuffer str){
		if(str == null){
			throw new NullPointerException("Cannot add a null string");
		}
		bigString.append(str);
		System.out.println("Add String is completed");
	}

	
	public synchronized void load(){
		try (BufferedReader br = new BufferedReader(new FileReader(loadPath)))
		{
 
			String sCurrentLine;
 
			while ((sCurrentLine = br.readLine()) != null) {
				bigString.append(sCurrentLine);
				bigString.append("\n");
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public synchronized void persist(){
		
		try {
			 
			File file = new File(writePath);
 
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(bigString.toString());
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	protected void finalize() throws Throwable{
		persist();
	}

}
