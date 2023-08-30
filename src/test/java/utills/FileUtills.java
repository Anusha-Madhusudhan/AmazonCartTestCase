/**
 * 
 */
package utills;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 */
public class FileUtills {
	
	public static String readPropertiesFile(String sFilePath,String sKey) {
		File f=new File(sFilePath);
		FileInputStream fi;
		Properties pro;
		String value = null;
		try {
			fi = new FileInputStream(f);
			pro=new Properties();
			pro.load(fi);
			value=pro.getProperty(sKey);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return value;
		
		
	}

}
